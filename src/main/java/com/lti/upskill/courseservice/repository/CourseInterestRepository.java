package com.lti.upskill.courseservice.repository;

import com.lti.upskill.courseservice.entity.CourseInterestMapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseInterestRepository extends JpaRepository<CourseInterestMapping, Long> {


}
