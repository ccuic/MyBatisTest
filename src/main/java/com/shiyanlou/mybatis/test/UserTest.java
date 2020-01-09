package com.shiyanlou.mybatis.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.shiyanlou.mybatis.mapper.UserMapper;
import com.shiyanlou.mybatis.model.User;
public class UserTest {
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
        //insertUser();
         //updateUser();
         //deleteUser();
        // selectUserById();
         selectAllUser();
    }

    private static void insertUser() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = new User();
        user.setUsername("liu mei");
        user.setPassword("999333");
        user.setSex("female");
        user.setAddress("zhengzhou Road 101");
        try {
            mapper.insertUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
    }

    private static void updateUser() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user=null;
        try {
            user = mapper.selectUserById(1);
        } catch (Exception e) {
            e.printStackTrace();
        }
        user.setAddress("chongqing");
        try {
            mapper.updateUser(user);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }

    private static void deleteUser() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            mapper.deleteUser(3);
            session.commit();
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }

    private static void selectUserById() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
           User user= mapper.selectUserById(1);
            session.commit();
            System.out.println(user.getId()+" , "+user.getUsername()+" , "
                    +user.getPassword()+" , "+user.getSex()+" , "+user.getAddress() );
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
    private static void selectAllUser() {
        SqlSession session = sqlSessionFactory.openSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        try {
            List<User> userList= mapper.selectAllUser();
            session.commit();
            for(User user:userList) {
                System.out.println(user.getId() + " , " + user.getUsername() + " , "
                        + user.getPassword() + " , " + user.getSex() + " , " + user.getAddress());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
}
