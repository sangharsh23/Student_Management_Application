package com.app.student.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.app.student.model.Student;
import com.app.student.service.StudentService;

@Controller
public class StudentController {
@Autowired
private StudentService studentService;
//create the handler method to handle list student request and return model and view
@GetMapping("/students/info")
public String listStudent(Model model) {
	model.addAttribute("student", studentService.getAllStudent());
	return "students";
	
}
@GetMapping("/students/new")
public String createStudentForm(Model model) {
	Student student=new Student();
	model.addAttribute("student", student);
	return "create_student";
}
@PostMapping("/students")
public String saveStudent(@ModelAttribute("student") Student student ) {
	studentService.saveStudent(student);
	return "redirect:/students/info";
}
@GetMapping("/students/edit/{id}")
public String editStudentForm(@PathVariable int id,Model model) {
	model.addAttribute("student", studentService.getStudentById(id));
	return "edit_student";
}
@PostMapping("/students/{id}")
public String updateStudent(@PathVariable int id, @ModelAttribute("student") Student student,
		Model model) {
	Student existingStudent = studentService.getStudentById(id);
	existingStudent.setId(id);
	existingStudent.setFirstName(student.getFirstName());
	existingStudent.setLastName(student.getLastName());
	existingStudent.setEmail(student.getEmail());
	studentService.updateStudent(existingStudent);
	return "students";
}
@GetMapping("/students/{id}")
public String deleteStudent(@PathVariable int id) {
	studentService.deleteStudentById(id);
	return "students";
}

}
