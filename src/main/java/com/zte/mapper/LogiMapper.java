package com.zte.mapper;

import com.zte.po.Logi;

public interface LogiMapper {
    int insert(Logi record);

    int insertSelective(Logi record);
}