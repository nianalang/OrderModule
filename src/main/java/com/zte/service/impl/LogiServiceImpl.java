package com.zte.service.impl;

import java.sql.Timestamp;
import java.util.UUID;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.zte.mapper.LogiMapper;
import com.zte.mapper.OrderLogMapper;
import com.zte.mapper.OrderMapper;
import com.zte.po.Logi;
import com.zte.po.Order;
import com.zte.po.OrderLog;
import com.zte.service.LogiService;

@Service("logiService")
public class LogiServiceImpl implements LogiService {
	@Resource
	private LogiMapper logiMapper;
	@Resource
	private OrderMapper orderMapper;
	@Resource
	private OrderLogMapper orderLogMapper;

	/**
	 * 1.更新物流(已发货)
	 * 2.更新订单(待收货)
	 * 3.日志记录
	 */
	public String updateLogi(int orderId) {
		Order order = orderMapper.findById(orderId);
		// 更新物流信息
		int logiId = order.getLogi_id();
		Logi logi = new Logi();
		logi.setLogi_id(logiId);//
		logi.setShip_id(1);//货运公司编号
		logi.setSn(UUID.randomUUID().toString().replaceAll("-", ""));//物流编号
		logi.setSender("张三");
		logi.setStatus(1);// 1:发货状态
		Timestamp now = new Timestamp(System.currentTimeMillis());
		logi.setModifytime(now);// 发货时间
		logiMapper.dynamicUpdate(logi);

		// 更新订单状态
		Order updateOrder = new Order();
		updateOrder.setOrder_id(orderId);
		updateOrder.setStatus(2);// 2:发货完成，待收货
		orderMapper.dynamicUpdate(updateOrder);
		// 向日志添加一条记录
		OrderLog orderLog = new OrderLog();
		orderLog.setLog_id(null);
		orderLog.setOrder_id(orderId);
		orderLog.setStatus(updateOrder.getStatus());
		orderLog.setTime(now);
		orderLogMapper.save(orderLog);
		return "发货完成";
	}
}
