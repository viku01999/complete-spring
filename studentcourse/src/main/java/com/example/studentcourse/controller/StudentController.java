package com.example.studentcourse.controller;

import com.example.studentcourse.dto.StudentDTO;
import com.example.studentcourse.mapper.StudentMapper;
import com.example.studentcourse.validation.StudentRequest;
import com.example.studentcourse.entity.Student;
import com.example.studentcourse.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService){
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Student> createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        Student savedStudent = studentService.saveStudent(studentRequest);
        return ResponseEntity.ok(savedStudent);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return ResponseEntity.ok(studentService.getAllStudents());
    }

    @PostMapping("/{studentId}/enroll/{courseId}")
    public ResponseEntity<StudentDTO> enrollStudent(
            @PathVariable Long studentId,
            @PathVariable Long courseId) {

        Student student = studentService.enrollStudentInCourse(studentId, courseId);
        return ResponseEntity.ok(StudentMapper.toDto(student));
    }

}
