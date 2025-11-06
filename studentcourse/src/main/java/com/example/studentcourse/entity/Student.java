package com.example.studentcourse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "students")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "courses")
@EqualsAndHashCode(exclude = "courses")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private  String email;

    private LocalDate enrolleddate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "student_courses",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private Set<Course> courses = new HashSet<>();

}
