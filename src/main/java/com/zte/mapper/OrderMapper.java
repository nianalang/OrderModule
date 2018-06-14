package com.zte.mapper;

import com.zte.po.Order;

public interface OrderMapper {
    int insert(Order record);

    int insertSelective(Order record);
}