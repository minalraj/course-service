package com.lti.upskill.courseservice.controller;

import com.lti.upskill.courseservice.entity.Course;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {


    @RequestMapping(value = "/testcourse", method = RequestMethod.GET)
    public Course courseDetails() {

       Course course = new Course();

       course.getCourseId();
       course.setCourseName("Machine Learning");
       course.setCourseDetails("Indepth knowledge of AI, Machine Learning and Deep Learning");
       course.setCourseDuration("7 hours");

        return course;
    }
}
