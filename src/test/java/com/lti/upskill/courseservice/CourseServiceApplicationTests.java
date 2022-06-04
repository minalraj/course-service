package com.lti.upskill.courseservice;

import com.lti.upskill.courseservice.controller.TestController;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class CourseServiceApplicationTests {

	private TestController testController;

	@Test
	void contextLoads()throws Exception {
		assertThat(testController).isNotNull();
	}

}
