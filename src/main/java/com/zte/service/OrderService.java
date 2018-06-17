package com.zte.service;

/**
 * 订单业务逻辑层
 * @author 郎媛勤
 *
 */
public interface OrderService {

	/**
	 * 添加一个订单
	 * @param memberId
	 * @param addressId
	 * @param paytypeId
	 * @return
	 */
	public String addOrder(int memberId,int addressId,int paytypeId,double carriage);
}
