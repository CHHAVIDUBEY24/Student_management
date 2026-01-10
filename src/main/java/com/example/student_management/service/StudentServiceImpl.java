package com.example.student_management.service;

import com.example.student_management.entity.Student;
import com.example.student_management.repository.StudentRepository;
import com.example.student_management.exception.ResourceNotFoundException; // see file below (or create your own)
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student createStudent(Student student) {
        // null-check and repository-level uniqueness check
        if (student.getEmail() != null && studentRepository.existsByEmail(student.getEmail())) {
            throw new IllegalArgumentException("Email already in use: " + student.getEmail());
        }
        return studentRepository.save(student);
    }

    @Override
    @Transactional(readOnly = true)
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found with id: " + id));
    }

    @Override
    public Student updateStudent(Long id, Student updated) {
        Student existing = getStudentById(id); // will throw if not present

        // update allowed fields
        if (updated.getName() != null) {
            existing.setName(updated.getName());
        }
        if (updated.getSemester() != null) {
            existing.setSemester(updated.getSemester());
        }

        // email update: check not null, different, and unique
        if (updated.getEmail() != null && !updated.getEmail().equals(existing.getEmail())) {
            if (studentRepository.existsByEmail(updated.getEmail())) {
                throw new IllegalArgumentException("Email already in use: " + updated.getEmail());
            }
            existing.setEmail(updated.getEmail());
        }

        return studentRepository.save(existing);
    }

    @Override
    public void deleteStudent(Long id) {
        Student existing = getStudentById(id);
        studentRepository.delete(existing);
    }
}
