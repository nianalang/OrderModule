package com.zte.mapper;

import com.zte.po.Ship;

public interface ShipMapper {
    int insert(Ship record);

    int insertSelective(Ship record);
}