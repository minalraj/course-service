package com.lti.upskill.courseservice.service;

import com.lti.upskill.courseservice.entity.Course;
import com.lti.upskill.courseservice.entity.CourseInterestMapping;
import com.lti.upskill.courseservice.entity.Interest;
import com.lti.upskill.courseservice.exception.CourseException;
import com.lti.upskill.courseservice.repository.CourseInterestRepository;
import com.lti.upskill.courseservice.repository.CourseRepository;
import com.lti.upskill.courseservice.repository.InterestRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class CourseService {

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    public InterestRepository interestRepository;

    @Autowired
    public CourseInterestRepository courseInterestRepository;

//    public Course saveCourse(Course course) {
//        Course newCourse = new Course();
//        newCourse.setCourseName(course.getCourseName());
//        newCourse.setCourseDetails(course.getCourseDetails());
//        newCourse.setCourseDuration(course.getCourseDuration());
//        log.info("Inside saveCourse of CourseService");
//        courseRepository.save(newCourse);
//        return newCourse;
//    }

    //testing vo
    public Course saveCourse(Course course) {
        log.info("Inside saveCourse of CourseService");
        if (!isCourseName(course)) {
            return courseRepository.save(course);
        } else {
            throw new CourseException(course.getCourseName() + " already exists");
        }


    }

    public boolean isCourseName(Course course) {
        return getAllCourses().stream()
                .anyMatch(data -> data.getCourseName().equalsIgnoreCase(course.getCourseName()));
    }

//
//    public Course findCourseById(Long courseId ) {
//        log.info("Inside findCourseById of CourseService");
////        Optional<Course> result =  courseRepository.findById(courseId);
////        return result.orElse(null);
//        return courseRepository.findByCourseId(courseId);
//    }
//
    //testing vo
    public Course findCourseById(Long courseId ) {
        log.info("Inside findCourseById of CourseService");
        Optional<Course> findCourse = courseRepository.findById(courseId);
        if (!findCourse.isPresent()) {
            throw new CourseException("Course not found");
        } else {
            return findCourse.get();
        }
    }

    public List<Course> getAllCourses(){
       return courseRepository.findAll();
    }

    public void removeCourse(Long courseId) {
        Course course = findCourseById(courseId);
        courseRepository.deleteById(course.getCourseId());

    }

    //interest table
    public Interest saveInterest(Interest interest){
        log.info("Inside saveInterest of CourseService");
        return interestRepository.save(interest);
    }

    public List<Interest> getAllInterests(){
        return interestRepository.findAll();
    }


    //CourseInterestMapping table
    public CourseInterestMapping saveCourseInterest(CourseInterestMapping courseInterestMapping){
        log.info("Inside saveCourseInterest of CourseService");
        return courseInterestRepository.save(courseInterestMapping);
    }

    public List<CourseInterestMapping> getAllCourseInterestMapping(){
        return courseInterestRepository.findAll();
    }

}
