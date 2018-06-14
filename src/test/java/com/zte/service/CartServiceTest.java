package com.zte.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zte.po.Cart;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-service.xml","classpath:spring/spring-dao.xml" })
public class CartServiceTest {

	@Autowired
	private CartService cartService;
	
	@Test
	public void testSelectByMemberId() {
		List<Cart> list=cartService.selectByMemberId(1, 2, 1);
		
		for(int i=0;i<list.size();i++) {
			Cart cart=list.get(i);
			System.out.println(cart+"llllllllllll");
			
			for(int j=0;j<cart.getBriefGoods().size();j++) {
				System.out.println(cart.getBriefGoods().get(j)+"vvvvvvvvvvvv");
			}
			
		}
		
	}

}
