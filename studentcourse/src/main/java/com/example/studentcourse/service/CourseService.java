package com.example.studentcourse.service;

import com.example.studentcourse.validation.CourseRequest;
import com.example.studentcourse.entity.Course;
import com.example.studentcourse.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public CourseService(CourseRepository courseRepository){
        this.courseRepository = courseRepository;
    }

    public Course saveCourse(CourseRequest courseRequest) {
        Course course = new Course();
        course.setTitle(courseRequest.getTitle());
        course.setDurationInWeek(courseRequest.getDurationInWeek());
        return courseRepository.save(course);
    }

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

}
