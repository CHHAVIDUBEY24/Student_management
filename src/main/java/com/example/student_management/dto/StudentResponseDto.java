package com.example.student_management.dto;

public class StudentResponseDto {

    private Long id;
    private String name;
    private String email;
    private Integer semester;

    public StudentResponseDto() {}

    public StudentResponseDto(Long id, String name, String email, Integer semester) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.semester = semester;
    }

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Integer getSemester() { return semester; }
    public void setSemester(Integer semester) { this.semester = semester; }
}
