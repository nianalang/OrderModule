package com.zte.service;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml" })
public class OrderServiceTest {
	@Autowired
	private OrderService orderService;
	@Test
	public void testAddOrder() {
		String result=orderService.addOrder(1, 1, 1, 0);
		System.out.println(result);
	}
}
