package com.shiyanlou.mybatis.mapper;

import com.shiyanlou.mybatis.model.Student;
import com.shiyanlou.mybatis.model.StudentCourseLink;

import java.util.List;

public interface StudentMapper {
	public List<Student> selectStudentcourse() throws Exception;
	public void deleteStudentCouseById(StudentCourseLink scLink)throws Exception;
}
