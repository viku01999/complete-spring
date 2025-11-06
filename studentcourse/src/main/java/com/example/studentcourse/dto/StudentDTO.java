package com.example.studentcourse.dto;

import lombok.Data;

import java.time.LocalDate;
import java.util.Set;

@Data
public class StudentDTO {

    private Long id;
    private String name;
    private String email;
    private LocalDate enrolledDate;
    private Set<CourseDTO> courses;
}
