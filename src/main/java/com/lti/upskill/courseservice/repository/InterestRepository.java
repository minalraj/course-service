package com.lti.upskill.courseservice.repository;

import com.lti.upskill.courseservice.entity.Interest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InterestRepository extends JpaRepository<Interest, Long> {

    //Interest findByInterestId(Long interestId);

}
