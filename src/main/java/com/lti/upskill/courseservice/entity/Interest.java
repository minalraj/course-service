package com.lti.upskill.courseservice.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import javax.persistence.*;

@Data
@Entity
@Table(name = "interest")
@AllArgsConstructor
@NoArgsConstructor
public class Interest {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "INTEREST_ID", unique = true,  nullable = false)
    private Long interestId;


    @Column(name = "INTEREST_NAME", unique = true,  nullable = false)
    private String interest;

}
