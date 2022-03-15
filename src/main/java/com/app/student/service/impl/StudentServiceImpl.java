package com.app.student.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.student.model.Student;
import com.app.student.repository.StudentRepository;
import com.app.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	private StudentRepository studentRepository;
		@Override
		public List<Student> getAllStudent() {
			
			return studentRepository.findAll();
		}
		@Override
		public Student saveStudent(Student student) {
			// TODO Auto-generated method stub
			return studentRepository.save(student);
		}
		@Override
		public Student getStudentById(int id) {
			// TODO Auto-generated method stub
			return studentRepository.findById(id).get();
		}
		@Override
		public Student updateStudent(Student student) {
			// TODO Auto-generated method stub
			return studentRepository.save(student);
		}
		@Override
		public void deleteStudentById(int id) {
			studentRepository.deleteById(id);
			
			
		}
		
}
