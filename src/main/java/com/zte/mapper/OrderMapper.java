package com.zte.mapper;

import com.zte.po.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
    //保存订单数据
    int save(Order order);
    //根据订单id查询订单
    Order findById(int order_id);
    
    int dynamicUpdate(Order order);
}