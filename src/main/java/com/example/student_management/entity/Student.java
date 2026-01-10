package com.example.student_management.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name="students")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message="Name cannot be empty")
    private String name;

    @Email(message="Email must be valid")
    @NotBlank(message = "Email cannot be empty")
    @Column(unique = true)
    private String email;

    @Min(value=1, message = "Semester must be between 1 and 8")
    @Max(value=8, message = "Semester must be between 1 and 8")
    private Integer semester;

    public Student(){}

    public Student(String name,String email,Integer semester)
    {
        this.name=name;
        this.email=email;
        this.semester=semester;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSemester() {
        return semester;
    }

    public void setSemester(Integer semester) {
        this.semester = semester;
    }
}
