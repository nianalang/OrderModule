package com.zte.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zte.mapper.CartMapper;
import com.zte.po.Cart;
import com.zte.service.CartService;

/**
 * 购物车业务逻辑层
 * @author 郎媛勤
 *
 */
@Service("cartService")
public class CartServiceImpl implements CartService{

	@Autowired
	private CartMapper cartMapper;
	/**
	 * pageNum 第几页 pageSize 每页记录数
	 * member_id 成员id
	 */
	public List<Cart> selectByMemberId(int pageNum, int pageSize, int member_id) {
		
		PageHelper.startPage(pageNum, pageSize);
		//查询数据
		List<Cart> carts=cartMapper.selectByMemberId(member_id);
		// 使用pageInfo分页
		PageInfo<Cart> pageInfo = new PageInfo<Cart>(carts);
		//返回分好页的数组
		return pageInfo.getList();
	}

}
