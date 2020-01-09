package com.shiyanlou.mybatis.mapper;

import com.shiyanlou.mybatis.model.Classes;

public interface ClassesMapper {
	public Classes selectClassById(Integer id) throws Exception;
}
