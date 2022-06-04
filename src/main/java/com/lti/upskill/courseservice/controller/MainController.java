package com.lti.upskill.courseservice.controller;

import com.lti.upskill.courseservice.entity.Course;
import com.lti.upskill.courseservice.entity.CourseInterestMapping;
import com.lti.upskill.courseservice.entity.Interest;
import com.lti.upskill.courseservice.entity.Status;
//import com.lti.upskill.courseservice.model.CourseModel;
import com.lti.upskill.courseservice.repository.CourseRepository;
import com.lti.upskill.courseservice.service.CourseService;
import com.lti.upskill.courseservice.vo.CourseInterestVo;
import com.lti.upskill.courseservice.vo.CourseVo;
import com.lti.upskill.courseservice.vo.InterestVo;
import com.lti.upskill.courseservice.vo.StatusVo;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/courses")
public class MainController {

    @Autowired
    private CourseService courseService;

    @Autowired
    private CourseRepository courseRepository;

    //Logger log = LoggerFactory.getLogger(MainController.class);

    @GetMapping("/helloCourse")
    public String helloCourse() {

        log.info("Welcome to Upskill");
        return " Hello,  Welcome to Upskill Learning Platform - Course Module!";
    }


    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public CourseVo saveCourse(@RequestBody Course course) {
        log.info("Inside saveCourse of Course Controller");
        CourseVo courseVo = new CourseVo();

        try {
            Course registeredCourse = courseService.saveCourse(course);
            //check  ??? courseVo.setCourseId(registeredCourse.getCourseId());
            courseVo.setCourseName(registeredCourse.getCourseName());
            courseVo.setCourseDetails(registeredCourse.getCourseDetails());
            courseVo.setCourseDuration(registeredCourse.getCourseDuration());
            courseVo.setMessage("Course Registered Successfully!!");
            courseVo.setStatus(StatusVo.statusType.SUCCESS);
            return courseVo;

        } catch (Exception e) {
            courseVo.setMessage(e.getMessage());
            courseVo.setStatus(StatusVo.statusType.FAILED);
            return courseVo;
        }
    }

    //    @RequestMapping(value = "/get/{courseId}", method = RequestMethod.GET)
//    public @ResponseBody
//    Course findCourseById(@PathVariable(required=false,name="courseId") Long courseId){
//        log.info("Inside find by course Id of Course Controller");
//        return courseService.findCourseById(courseId);
//    }
//
    //testing vo
    @RequestMapping(value = "/get/{courseId}", method = RequestMethod.GET)
    public @ResponseBody
    CourseVo findCourseById(@PathVariable(required = false, name = "courseId") Long courseId) {
        log.info("Inside find by course Id of Course Controller");
        CourseVo courseVo = new CourseVo();
        try {
            Course retrievedCourse = courseService.findCourseById(courseId);
            courseVo.setCourseId(retrievedCourse.getCourseId());
            courseVo.setCourseName(retrievedCourse.getCourseName());
            courseVo.setCourseDetails(retrievedCourse.getCourseDetails());
            courseVo.setCourseDuration(retrievedCourse.getCourseDuration());
            courseVo.setMessage("Retrieved Successfully");
            courseVo.setStatus(StatusVo.statusType.SUCCESS);
            return courseVo;
        } catch (Exception e) {
            courseVo.setMessage(e.getMessage());
            courseVo.setStatus(StatusVo.statusType.FAILED);
            return courseVo;
        }
    }


    @RequestMapping(value = "/get/all", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

//    @RequestMapping(value = "/removeCourse/{courseId}", method = RequestMethod.DELETE)
//    public String removeCourse(@PathVariable(required=false,name="courseId") Long courseId) {
//        courseService.removeCourse(courseId);
//        return " requested course of course id :" + courseId+ " is removed";
//    }

    //testing vo
    @RequestMapping(value = "/removeCourse/{courseId}", method = RequestMethod.DELETE)
    public StatusVo removeCourse(@PathVariable(required = false, name = "courseId") Long courseId) {
        StatusVo statusVo = new StatusVo();
        try {
            courseService.removeCourse(courseId);
            statusVo.setMessage("Course Deleted Successfully!!");
            statusVo.setStatus(StatusVo.statusType.SUCCESS);
            return statusVo;
        } catch (Exception e) {
            statusVo.setMessage(e.getMessage());
            statusVo.setStatus(StatusVo.statusType.FAILED);
            return statusVo;
        }
    }

    @RequestMapping(value = "/interest", method = RequestMethod.POST)
    public InterestVo saveInterest(@RequestBody Interest interest) {
        log.info("Inside saveInterest of Course Controller");
        InterestVo interestVo = new InterestVo();

        try {
            Interest savedInterest = courseService.saveInterest(interest);
            interestVo.setInterestId(savedInterest.getInterestId());
            interestVo.setInterest(savedInterest.getInterest());
            interestVo.setMessage("Interest saved Successfully!!");
            interestVo.setStatus(StatusVo.statusType.SUCCESS);
            return interestVo;

        } catch (Exception e) {
            throw new RuntimeException(e);
//            interestVo.setMessage(e.getMessage());
//            interestVo.setStatus(StatusVo.statusType.FAILED);
//            return interestVo;

        }
    }

    @RequestMapping(value = "/getAllInterests", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<Interest> getAllInterests() {
        log.info("Inside getAllInterests of Course Controller");
        return courseService.getAllInterests();
    }

    //CourseInterestMapping

    @RequestMapping(value = "/courseInterest", method = RequestMethod.POST)
    public CourseInterestVo saveCourseInterest(@RequestBody CourseInterestMapping courseInterestMapping) {
        log.info("Inside saveCourseInterest of Course Controller");
        CourseInterestVo courseInterestVo = new CourseInterestVo();

        try {
            CourseInterestMapping courseInterestMapping1 = courseService.saveCourseInterest(courseInterestMapping);
            courseInterestVo.setCourseId(courseInterestMapping1.getCourseId());
            courseInterestVo.setInterestId(courseInterestMapping1.getInterestId());
            courseInterestVo.setMessage("Course and Interest mapper saved Successfully!!");
            courseInterestVo.setStatus(StatusVo.statusType.SUCCESS);
            return courseInterestVo;

        } catch (Exception e) {
            throw new RuntimeException(e);

        }
    }

    @RequestMapping(value = "/getAllCourseInterestMapping", method = RequestMethod.GET)
    public @ResponseBody
    Iterable<CourseInterestMapping> getAllCourseInterestMapping() {
        log.info("Inside getAllCourseInterestMapping of Course Controller");
        return courseService.getAllCourseInterestMapping();
    }

}