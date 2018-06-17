package com.zte.mapper;

import com.zte.po.Logi;

public interface LogiMapper {
    int insert(Logi record);

    int insertSelective(Logi record);
    
    //保存物流数据
    int save(Logi logi);
    
    int dynamicUpdate(Logi logi);
}