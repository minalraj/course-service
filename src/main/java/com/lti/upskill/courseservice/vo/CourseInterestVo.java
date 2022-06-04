package com.lti.upskill.courseservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseInterestVo extends StatusVo {

    private long courseId;
    private long interestId;
}
