package com.example.studentcourse.validation;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class CourseRequest {

    @NotBlank(message = "Title is required")
    private String title;

    @Min(value = 1, message = "Duration must be at least 1 week")
    private int durationInWeek;

}
