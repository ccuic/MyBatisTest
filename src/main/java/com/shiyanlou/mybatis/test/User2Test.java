package com.shiyanlou.mybatis.test;

import com.shiyanlou.mybatis.mapper.User2Mapper;
import com.shiyanlou.mybatis.model.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class User2Test {
    private static SqlSessionFactory sqlSessionFactory;

    public static void main(String[] args) {
        // mybatis 配置文件
        String resource = "mybatis.cfg.xml";
        InputStream inputStream=null;
        try {
            inputStream = Resources.getResourceAsStream(resource);

        } catch (IOException e) {
            e.printStackTrace();
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        HashMap<String, Object> argMap = new HashMap<String,Object>();
        argMap.put("phone", "15217888767");
        dynamicIfTest(argMap);
//        argMap.put("phone", null);
//        dynamicIfTest(argMap);
        //insertUser();
         //updateUser();
         //deleteUser();
        //selectUserById();
         //selectAllUser();
    }
    private static void dynamicIfTest(HashMap<String, Object> address) {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            List<User2> userList= mapper.dynamicIfTest(address);
            session.commit();
            for(User2 user:userList) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
    private static void insertUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        User2 user = new User2();
        user.setUsername("wang kang");
        user.setPassword("999333");
        user.setSex("male");
        user.setAge(22);
        user.setPhone("15217888767");
        user.setAddress("baoding");
        try {
            mapper.insertUser2(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    private static void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        User2 user=null;
        try {
            user = mapper.selectUser2ById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setAddress("suzhou");
        try {
            mapper.updateUser2(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }

    private static void deleteUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            mapper.deleteUser2(2);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }

    private static void selectUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
           User2 user= mapper.selectUser2ById(1);
            session.commit();
            System.out.println(user.toString() );
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
    private static void selectAllUser() {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            List<User2> userList= mapper.selectAllUser2();
            session.commit();
            for(User2 user:userList) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
}
