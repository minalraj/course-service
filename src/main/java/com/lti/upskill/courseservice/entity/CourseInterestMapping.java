package com.lti.upskill.courseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "course_interest_mapping")
@AllArgsConstructor
@NoArgsConstructor
public class CourseInterestMapping {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "COURSE_ID", unique = true,  nullable = false)
    private Long courseId;

    @Column(name = "INTEREST_ID", unique = true,  nullable = false)
    private Long interestId;


}
