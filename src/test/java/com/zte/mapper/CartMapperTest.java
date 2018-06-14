package com.zte.mapper;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zte.po.Cart;

@RunWith(SpringJUnit4ClassRunner.class) //使用junit4进行测试  
@ContextConfiguration(locations={"classpath:spring/spring-dao.xml"}) 
public class CartMapperTest {

	@Autowired
	private CartMapper cartMapper;
	
	@Test
	public void testSelectByMemberId() {
		List<Cart> cart=cartMapper.selectByMemberId(1);
		System.out.println(cart);
	}

}
