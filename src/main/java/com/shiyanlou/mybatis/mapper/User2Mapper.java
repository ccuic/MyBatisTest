package com.shiyanlou.mybatis.mapper;

import com.shiyanlou.mybatis.model.User2;

import java.util.HashMap;
import java.util.List;

public interface User2Mapper {
    public int insertUser2(User2 user) throws Exception;
    public int updateUser2(User2 user) throws Exception;
    public int deleteUser2(Integer id) throws Exception;
    public User2 selectUser2ById(Integer id) throws Exception;
    public List<User2> selectAllUser2() throws Exception;
    public List<User2> dynamicIfTest(HashMap<String, Object> address) throws Exception;
}

