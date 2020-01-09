package com.shiyanlou.mybatis.mapper;

import com.shiyanlou.mybatis.model.Classes;

public interface ClassesMapper2 {
	public Classes selectClassAndStudentsById(Integer id) throws Exception;
}
