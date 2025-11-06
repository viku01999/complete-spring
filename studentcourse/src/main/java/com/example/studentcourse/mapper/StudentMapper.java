package com.example.studentcourse.mapper;

import com.example.studentcourse.dto.CourseDTO;
import com.example.studentcourse.dto.StudentDTO;
import com.example.studentcourse.entity.Student;

import java.util.stream.Collectors;

public class StudentMapper {

    public  static StudentDTO toDto(Student student){
        StudentDTO studentDTO = new StudentDTO();
        studentDTO.setId(student.getId());
        studentDTO.setName(student.getName());
        studentDTO.setEmail(student.getEmail());
        studentDTO.setEnrolledDate(student.getEnrolleddate());

        if(student.getCourses() != null){
            studentDTO.setCourses(student.getCourses().stream()
                    .map(course -> {
                        CourseDTO courseDTO = new CourseDTO();
                        courseDTO.setId(course.getId());
                        courseDTO.setTitle(course.getTitle());
                        courseDTO.setDurationInWeek(course.getDurationInWeek());
                        return  courseDTO;
                    }).collect(Collectors.toSet()));
        }
        return studentDTO;
    }
}
