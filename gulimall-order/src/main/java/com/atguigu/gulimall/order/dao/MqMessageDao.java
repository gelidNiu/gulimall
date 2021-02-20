package com.atguigu.gulimall.order.dao;

import com.atguigu.gulimall.order.entity.MqMessageEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 
 * 
 * @author niu
 * @email niu@gmail.com
 * @date 2021-01-16 14:55:17
 */
@Mapper
public interface MqMessageDao extends BaseMapper<MqMessageEntity> {
	
}
