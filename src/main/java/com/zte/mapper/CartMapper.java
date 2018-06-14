package com.zte.mapper;

import java.util.List;

import com.zte.po.Cart;

public interface CartMapper {
	/**
	 * 插入数据
	 * @param record 
	 * @return
	 */
    int insert(Cart record);

    int insertSelective(Cart record);
    
    /**
     * 通过会员id查询订单
     */
    List<Cart> selectByMemberId(int member_id);
}