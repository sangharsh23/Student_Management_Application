package com.app.student.service;

import java.util.List;

import com.app.student.model.Student;

public interface StudentService {
	List<Student> getAllStudent();
	Student saveStudent(Student student);
	Student getStudentById(int id);
	Student updateStudent(Student student);
	void deleteStudentById(int id);
}
