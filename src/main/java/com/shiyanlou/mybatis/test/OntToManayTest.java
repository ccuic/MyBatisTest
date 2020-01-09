package com.shiyanlou.mybatis.test;
import com.shiyanlou.mybatis.mapper.ClassesMapper;
import com.shiyanlou.mybatis.mapper.ClassesMapper2;
import com.shiyanlou.mybatis.model.Classes;
import com.shiyanlou.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class OntToManayTest {
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
		ClassesMapper2 mapper = session.getMapper(ClassesMapper2.class);
		try {
			Classes classes = mapper.selectClassAndStudentsById(1);
			session.commit();
			System.out.println("班级信息："+classes.getId()+","+classes.getName());
			List<Student> students=classes.getStudents();
			System.out.println("学生信息：");
			for (Student student : students) {
				System.out.println(student.toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
}