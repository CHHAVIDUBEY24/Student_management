package com.example.student_management.service;

import com.example.student_management.entity.Student;

import java.util.List;

public interface StudentService {
    Student createStudent(Student student) throws IllegalAccessException;
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student updateStudent(Long id,Student student);
    void deleteStudent(Long id);

}
