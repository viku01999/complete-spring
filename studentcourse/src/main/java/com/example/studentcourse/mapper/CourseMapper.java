package com.example.studentcourse.mapper;

import com.example.studentcourse.dto.CourseDTO;
import com.example.studentcourse.dto.StudentDTO;
import com.example.studentcourse.entity.Course;
import com.example.studentcourse.entity.Student;

import java.util.stream.Collectors;

public class CourseMapper {

    public static CourseDTO toDTO(Course course){
        CourseDTO courseDTO = new CourseDTO();
        courseDTO.setId(course.getId());
        courseDTO.setTitle(course.getTitle());
        courseDTO.setDurationInWeek(course.getDurationInWeek());

//        if(course.getStudents() != null){
//            courseDTO.setStudents(course.getStudents().stream()
//                    .map(student -> {
//                        StudentDTO studentDTO = new StudentDTO();
//                        studentDTO.setName(student.getName());
//                        studentDTO.setId(student.getId());
//                        studentDTO.setEmail(student.getEmail());
//                        studentDTO.setEnrolledDate(student.getEnrolleddate());
//
//                        return studentDTO;
//                    }).collect(Collectors.toSet()));
//        }
        return  courseDTO;
    }

}
