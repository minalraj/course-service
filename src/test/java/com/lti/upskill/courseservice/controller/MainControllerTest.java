package com.lti.upskill.courseservice.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lti.upskill.courseservice.entity.Course;
import com.lti.upskill.courseservice.repository.CourseRepository;
import com.lti.upskill.courseservice.service.CourseService;
import com.lti.upskill.courseservice.vo.CourseVo;
import com.lti.upskill.courseservice.vo.StatusVo;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


@WebMvcTest
@Slf4j
class MainControllerTest {

    @MockBean
    CourseService mockCourseService;

    @MockBean
    CourseRepository mockCourseRepository;

    @Autowired
    private MockMvc mockMvc;

    private static ObjectMapper objectMapper = new ObjectMapper().findAndRegisterModules();


//    @Test
//    void helloCourse() {
//        String HELLO_COURSE = "Hello,  Welcome to Upskill Learning Platform - Course Module!";
//        Course course = mock(Course.class);
//        when(course.hello()).thenReturn(HELLO_COURSE);
//        System.out.println("Foo greets: " + foo.greet());
//        assertEquals(foo.greet(), HELLO_COURSE);
//    }

    @Test
    void TestSaveCourse() throws Exception {

        Course course = new Course();
        course.setCourseId(1L);
        course.setCourseName("Java");
        course.setCourseDetails("Its a java test course");
        course.setCourseDuration("2 hours");
        Mockito.when(mockCourseRepository.save(course)).thenReturn(course);
        Mockito.when(mockCourseService.saveCourse(ArgumentMatchers.any())).thenReturn(course);
        String json = objectMapper.writeValueAsString(course);
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post("http://localhost:9002/courses/register")
                .contentType(MediaType.APPLICATION_JSON).content(json).accept(MediaType.APPLICATION_JSON)).andReturn();
        String result = mvcResult.getResponse().getContentAsString();
        CourseVo courseVo = new ObjectMapper().readValue(result, CourseVo.class);
        assertEquals(StatusVo.statusType.SUCCESS, courseVo.getStatus());
    }



}
