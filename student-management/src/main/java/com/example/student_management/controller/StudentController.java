package com.example.student_management.controller;

import com.example.student_management.entity.Student;
import com.example.student_management.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    @Autowired
    private StudentService studService;

    @GetMapping
    public List<Student> getAllStudents() {
        return studService.getAllStudent();
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student) {
        System.out.println("Received student: " + student);
        //install lambok plugin
        return studService.saveAndUpdateStudent(student);
    }

    public String deleteStudent(@PathVariable Long id) {
        studService.deleteStudent(id);
        return "Student deleted successfully . . . ";
    }
}