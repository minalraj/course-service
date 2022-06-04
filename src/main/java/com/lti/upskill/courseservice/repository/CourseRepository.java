package com.lti.upskill.courseservice.repository;

import com.lti.upskill.courseservice.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
   // Course findByCourseId(Long courseId);

    //fetch all user data form DB by searching using username
    Course findByCourseName(String courseName);


}