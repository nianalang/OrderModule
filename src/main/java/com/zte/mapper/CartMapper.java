package com.zte.mapper;

import com.zte.po.Cart;

public interface CartMapper {
    int insert(Cart record);

    int insertSelective(Cart record);
}