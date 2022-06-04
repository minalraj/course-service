package com.lti.upskill.courseservice.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InterestVo extends StatusVo {

    private Long interestId;
    private String interest;
}
