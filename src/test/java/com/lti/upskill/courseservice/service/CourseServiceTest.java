package com.lti.upskill.courseservice.service;

import com.lti.upskill.courseservice.entity.Course;
import com.lti.upskill.courseservice.exception.CourseException;
import com.lti.upskill.courseservice.repository.CourseRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CourseServiceTest {

    @MockBean
    CourseRepository mockCourseRepository;

    @Autowired
    CourseService courseService;

    @Test
    void testSaveCourse() {
        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("Java");
        course.setCourseDetails("Its a java test course");
        course.setCourseDuration("2 hours");
        Mockito.when(mockCourseRepository.save(course)).thenReturn(course);
        assertEquals(course, courseService.saveCourse(course));
    }


    @Test
    void testFindCourseById() {
        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("Java");
        course.setCourseDetails("Its a java test course");
        course.setCourseDuration("2 hours");
        Mockito.when(mockCourseRepository.findById(course.getCourseId())).thenReturn(Optional.of(course));
        long courseId = 1;
        assertEquals(course, courseService.findCourseById(courseId));
    }

    @Test
    public void testFindCourseByInvalidId(){
        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("Java");
        course.setCourseDetails("Its a java test course");
        course.setCourseDuration("2 hours");
        long courseId = 20;
        CourseException subjectException=assertThrows(CourseException.class,()-> courseService.findCourseById(courseId));
        assertEquals("Course Id is invalid!",subjectException.getMessage());
    }

    @Test
    void TestGetAllCourses() {
        Course course1 = new Course();
        course1.setCourseId(1L);
        course1.setCourseName("Java");
        course1.setCourseDetails("Its a java test course");
        course1.setCourseDuration("2 hours");

        Course course2 = new Course();
        course2.setCourseId(2L);
        course2.setCourseName("Python");
        course2.setCourseDetails("Its a python test course");
        course2.setCourseDuration("4 hours");

        List<Course> courseList=new ArrayList<>();
        courseList.add(course1);
        courseList.add(course2);
        Mockito.when(mockCourseRepository.findAll()).thenReturn(courseList);
        assertEquals(courseList, courseService.getAllCourses());
    }
//
//    @Test
//    void removeCourse() {
//        Course course = new Course();
//        course.setCourseId(1L);
//        course.setCourseName("Java");
//        course.setCourseDetails("Its a java test course");
//        course.setCourseDuration("2 hours");
//        Mockito.when(mockCourseRepository.findById(course.getCourseId())).thenReturn(Optional.of(course));
//        verify
//
//    }
}