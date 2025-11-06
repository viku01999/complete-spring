package com.example.studentcourse.controller;

import com.example.studentcourse.validation.CourseRequest;
import com.example.studentcourse.entity.Course;
import com.example.studentcourse.service.CourseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody CourseRequest courseRequest) {
        Course savedCourse = courseService.saveCourse(courseRequest);
        return ResponseEntity.ok(savedCourse);
    }


    @GetMapping
    public ResponseEntity<List<Course>> getAllCourses() {
        return ResponseEntity.ok(courseService.getAllCourses());
    }
}



