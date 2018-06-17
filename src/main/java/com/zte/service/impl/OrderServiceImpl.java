package com.zte.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zte.mapper.CartMapper;
import com.zte.mapper.GoodsMapper;
import com.zte.mapper.LogiMapper;
import com.zte.mapper.OrderGoodsMapper;
import com.zte.mapper.OrderLogMapper;
import com.zte.mapper.OrderMapper;
import com.zte.po.Cart;
import com.zte.po.Goods;
import com.zte.po.Logi;
import com.zte.po.Order;
import com.zte.po.OrderGoods;
import com.zte.po.OrderLog;
import com.zte.service.OrderService;

/**
 * 订单业务逻辑层
 * 
 * @author 郎媛勤
 *
 */
@Service("orderService")
public class OrderServiceImpl implements OrderService {
	@Autowired
	private CartMapper cartMapper;
	@Autowired
	private LogiMapper logiMapper;
	@Autowired
	private OrderMapper orderMapper;
	@Autowired
	private GoodsMapper goodsMapper;
	@Autowired
	private OrderGoodsMapper orderGoodsMapper;
	@Autowired
	private OrderLogMapper orderLogMapper;
 
	/**
	 * 增加一个订单
	 * 1.新增订单(待发货)
	 * 2.创建物流(已创建)
	 * 3.订单商品表中增加数据
	 * 4.将购物车中的记录删除
	 * 5.日志记录
	 */
	public String addOrder(int memberId, int addressId, int paytypeId, double carriage) {
		// 默认选中购物车中的所有商品
		List<Cart> carts = cartMapper.selectByMemberId(memberId);
		// 计算购物车中商品总的数量
		double totalAmount = carriage;
		for (Cart cart : carts) {
			double amount = cart.getAmount();
			totalAmount += amount;
		}
		// 新增订单
		Order order = new Order();
		// 订单编号采用UUID生成
		order.setSn(UUID.randomUUID().toString().replaceAll("-", ""));
		order.setMember_id(memberId);
		order.setStatus(1);// 订单状态,1:待发货
		// 设置支付id
		order.setPayment_id(paytypeId);
		// 创建物流
		Logi logi = new Logi();
		logi.setLogi_id(null);
		logi.setShip_id(0);// 还未关联货运公司id
		logi.setSn("");
		logi.setCarriage(carriage);
		logi.setSender("");
		logi.setStatus(0);// 物流状态，0：创建
		logi.setCreatime(null);
		logi.setModifytime(null);
		logiMapper.save(logi);
		// 设置物流id
		order.setLogi_id(logi.getLogi_id());
		order.setTotal_amount(totalAmount);
		order.setAddress_id(addressId);
		order.setCreatime(null);
		order.setModifytime(null);
		orderMapper.save(order);
		int orderId = order.getOrder_id();
		// 在订单商品表中增加数据
		for (Cart cart1 : carts) {
			OrderGoods orderGoods = new OrderGoods();
			orderGoods.setId(null);
			orderGoods.setOrder_id(orderId);
			int goodsId = cart1.getGoods_id();
			orderGoods.setGoods_id(goodsId);
			orderGoods.setGoods_num(cart1.getGoods_num());
			Goods goods = goodsMapper.findById(goodsId);
			orderGoods.setPrice(goods.getPrice());
			orderGoodsMapper.save(orderGoods);
		}
		// 将购物车中的记录删除
		for (Cart cart2 : carts) {
			cartMapper.deleteById(cart2.getCart_id());
		}
		// 在订单日志表中记录
		OrderLog orderLog = new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(order.getStatus());
		orderLog.setTime(order.getCreatime());
		orderLogMapper.save(orderLog);
		return "新建订单成功";
	}

}
