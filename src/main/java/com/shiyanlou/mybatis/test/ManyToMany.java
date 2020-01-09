package com.shiyanlou.mybatis.test;

import com.shiyanlou.mybatis.mapper.StudentMapper;
import com.shiyanlou.mybatis.model.Course;
import com.shiyanlou.mybatis.model.Student;
import com.shiyanlou.mybatis.model.StudentCourseLink;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ManyToMany {
	private static SqlSessionFactory sqlSessionFactory;

	public static void main(String[] args) {
		// Mybatis 配置文件
		String resource = "mybatis.cfg.xml";

		// 得到配置文件流
		InputStream inputStream = null;
		try {
			inputStream = Resources.getResourceAsStream(resource);
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 创建会话工厂，传入 MyBatis 的配置文件信息
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

		selectStudentCourse();
		deleteStudentCourseById();
		System.out.println("删除Rose选课 history");
		selectStudentCourse();
	}

	private static void deleteStudentCourseById() {
		SqlSession session=sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		try {
			Student student=new Student();
			student.setId(3);
			Course course=new Course();
			course.setId(3);
			StudentCourseLink scLink = new StudentCourseLink();
			scLink.setStudent(student);
			scLink.setCourse(course);
			mapper.deleteStudentCouseById(scLink);
			session.commit();
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
//查询所有学生及选择的课程信息
	private static void selectStudentCourse() {
		SqlSession session=sqlSessionFactory.openSession();
		StudentMapper mapper = session.getMapper(StudentMapper.class);
		try {
			List<Student> students = mapper.selectStudentcourse();
			session.commit();
			for (Student s : students) {
				System.out.println("学生信息："+s.toString());
				List<Course> courses=s.getCourses();
				for (Course c : courses) {
					System.out.println(c.toString());
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			session.rollback();
		}
		session.close();
	}
}