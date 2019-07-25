package com.demo.basic;

import com.demo.basic.entity.Person;
import com.demo.basic.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BasicApplicationTests {

	@Autowired
	Person person;

	@Autowired
	ApplicationContext aoc;

	@Test
	public void contextLoads() {
		System.out.println(person);
	}


	@Test
	public void testAoc(){
		boolean result = aoc.containsBean("userService");
		System.out.println(result);
	}
}
