package com.zte.service;

import java.util.List;

import com.zte.po.Cart;

/**
 * 业务逻辑层
 * @author 郎媛勤
 *
 */
public interface CartService {
	
	/**
	 * pageNum 第几页 pageSize 每页记录数
	 * member_id 成员id
	 */
	List<Cart> selectByMemberId(int pageNum,int pageSize,int member_id);
}
