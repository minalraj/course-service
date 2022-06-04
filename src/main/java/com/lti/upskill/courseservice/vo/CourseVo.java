package com.lti.upskill.courseservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseVo extends StatusVo{

    private long courseId;
    private String courseName;
    private String courseDetails;
    private String courseDuration;

}
