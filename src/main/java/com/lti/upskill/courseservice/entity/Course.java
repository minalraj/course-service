package com.lti.upskill.courseservice.entity;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "courses")
@AllArgsConstructor
@NoArgsConstructor
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID", unique = true, nullable = false)
    private Long courseId;

    @Column(name = "COURSE_NAME", unique = true,  nullable = false)
    private String courseName;

    @Column(name = "COURSE_DETAILS")
    private String courseDetails;

    @Column(name = "COURSE_DURATION")
    private String courseDuration;
}
