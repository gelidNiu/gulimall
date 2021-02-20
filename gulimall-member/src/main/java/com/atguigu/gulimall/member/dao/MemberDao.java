package com.atguigu.gulimall.member.dao;

import com.atguigu.gulimall.member.entity.MemberEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 会员
 * 
 * @author niu
 * @email niu@gmail.com
 * @date 2021-01-16 14:24:16
 */
@Mapper
public interface MemberDao extends BaseMapper<MemberEntity> {
	
}
