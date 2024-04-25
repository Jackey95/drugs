package com.example;

import com.example.entity.Drugs;
import com.example.mapper.DrugMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.List;

@SpringBootTest
class DrugsApplicationTests {

	@Autowired
	private DrugMapper userMapper;

	@Test
//	void contextLoads() {
//	}
	public void testSelect(){
		System.out.println(("----- selectAll method test ------"));
		List<Drugs> userList = userMapper.selectList(null);

		userList.forEach(System.out::println);
	}
}
