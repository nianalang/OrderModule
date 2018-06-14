package com.zte.mapper;

import com.zte.po.OrderLog;

public interface OrderLogMapper {
    int insert(OrderLog record);

    int insertSelective(OrderLog record);
}