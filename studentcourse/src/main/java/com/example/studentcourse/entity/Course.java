package com.example.studentcourse.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "course")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "students")
@EqualsAndHashCode(exclude = "students")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private int durationInWeek;

    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Student> students = new HashSet<>();

}
