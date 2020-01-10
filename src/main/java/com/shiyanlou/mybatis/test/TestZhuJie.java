package com.shiyanlou.mybatis.test;

import com.shiyanlou.mybatis.mapper.UserMapper;
import com.shiyanlou.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestZhuJie {
	private static SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) {
		String resource = "mybatis.cfg.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		insertUser();
		insertUser();
		selectUsersById();
		updateUser();
		System.out.println("修改年龄为100");
		selectAllUsers();
		deleteUser();
		System.out.println("删除后");
		selectAllUsers();
	}

	private static void insertUser() {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		User user=new User();
		user.setName("Jack");
		user.setSex("femail");
		user.setAge(23);
		try {
			mapper.insertUser(user);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
	private static void selectUsersById() {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			User user=mapper.selectUserById(1);
			session.commit();
			System.out.println(user.toString());
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
	private static void updateUser() {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			User user=mapper.selectUserById(1);
			user.setAge(100);
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
			mapper.deleteUser(2);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
	private static void selectAllUsers() {
		SqlSession session = sqlSessionFactory.openSession();
		UserMapper mapper = session.getMapper(UserMapper.class);
		try {
			List<User> userList=mapper.selectAllUser();
			session.commit();
			for (User user : userList) {
				System.out.println(user.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
}