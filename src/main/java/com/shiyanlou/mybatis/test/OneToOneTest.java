package com.shiyanlou.mybatis.test;

import com.shiyanlou.mybatis.mapper.ClassesMapper;
import com.shiyanlou.mybatis.model.Classes;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class OneToOneTest {
	private static SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) {
		// mybatis 配置文件
		String resource = "mybatis.cfg.xml";
		InputStream inputStream=null;
		try {
			inputStream = Resources.getResourceAsStream(resource);

		} catch (
				IOException e) {
			e.printStackTrace();
		}
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession session=sqlSessionFactory.openSession();
		ClassesMapper mapper = session.getMapper(ClassesMapper.class);
		try {
			Classes classes = mapper.selectClassById(1);
			session.commit();
			System.out.println(classes.getId() + "," + classes.getName() + ", Teacher:" +
					classes.getTeacher().getId() + "," + classes.getTeacher().getName() + "," + classes.getTeacher().getAge());
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}

}