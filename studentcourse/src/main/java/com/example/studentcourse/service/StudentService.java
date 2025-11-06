package com.example.studentcourse.service;

import com.example.studentcourse.dto.StudentDTO;
import com.example.studentcourse.mapper.StudentMapper;
import com.example.studentcourse.validation.StudentRequest;
import com.example.studentcourse.entity.Course;
import com.example.studentcourse.entity.Student;
import com.example.studentcourse.repository.CourseRepository;
import com.example.studentcourse.repository.StudentRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public StudentService(StudentRepository studentRepository, CourseRepository courseRepository) {
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;
    }

    public Student saveStudent(StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setEnrolleddate(studentRequest.getEnrolledDate());

        return studentRepository.save(student);
    }

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Transactional
    public Student enrollStudentInCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        Course course = courseRepository.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        for (Course courses : student.getCourses()) {
            System.out.println("Course ID: " + courses.getId() +
                    ", Title: " + courses.getTitle() +
                    ", Duration: " + courses.getDurationInWeek());
        }


        if (!student.getCourses().contains(course)) {
            student.getCourses().add(course);
            course.getStudents().add(student);
        }

        return studentRepository.save(student);
    }
}
