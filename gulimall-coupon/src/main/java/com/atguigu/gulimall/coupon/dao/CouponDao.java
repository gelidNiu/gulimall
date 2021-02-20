package com.atguigu.gulimall.coupon.dao;

import com.atguigu.gulimall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author niu
 * @email niu@gmail.com
 * @date 2021-01-16 14:11:00
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}
