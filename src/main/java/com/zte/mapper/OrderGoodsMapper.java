package com.zte.mapper;

import com.zte.po.OrderGoods;

public interface OrderGoodsMapper {
    int insert(OrderGoods record);

    int insertSelective(OrderGoods record);
    
    int save(OrderGoods orderGoods);
}