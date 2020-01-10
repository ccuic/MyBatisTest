package com.shiyanlou.mybatis.test;

import com.shiyanlou.mybatis.mapper.User2Mapper;
import com.shiyanlou.mybatis.model.User2;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
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
        argMap.put("id",1);
        argMap.put("address","puyang");
        argMap.put("phone","13811656441");
        dyForeachTest();
    }
    private static void dyForeachTest() {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            ArrayList<Integer> ids=new ArrayList<Integer>();
            ids.add(1); ids.add(3);
            List<User2> user2List= mapper.dyForeachTest(ids);
            session.commit();
            for(User2 user:user2List) {
                System.out.println(user.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
    private static void dySetUser2(HashMap<String, Object> address) {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            int i= mapper.dySetUser2(address);
            session.commit();
            if (i == 1) {
                System.out.println("success cui");
            }
        } catch (Exception e) {
            e.printStackTrace();
            session.rollback();
        }
        session.close();
    }
    private static void dywhereTest(HashMap<String, Object> address) {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            List<User2> userList= mapper.dywhereTest(address);
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
    private static void dyTrimTest(HashMap<String, Object> address) {
        SqlSession session = sqlSessionFactory.openSession();
        User2Mapper mapper = session.getMapper(User2Mapper.class);
        try {
            List<User2> userList= mapper.dyTrimTest(address);
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
