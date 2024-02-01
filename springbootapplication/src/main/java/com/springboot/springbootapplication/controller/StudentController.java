package com.springboot.springbootapplication.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.springbootapplication.dto.Student;
import com.springboot.springbootapplication.repository.StudentRepository;
@RestController
public class StudentController {
	@Autowired
	StudentRepository sr;
	
	@PostMapping("/savestudent")
	public String saveStudent(@RequestBody Student s) {
		sr.save(s);
		return "Student Saved";
	}
	@GetMapping("/getstudent")
	public Student getStudent(int id) {
		Optional<Student> s = sr.findById(id);
		if(s.isPresent()) {
			return s.get();
		}else {
		return null;
		}
	}
	@GetMapping("/getallstudent")
	public List<Student> getAllStudent(){
		return sr.findAll();
	}
	@DeleteMapping("/deletestudent/{id}")
	public String deleteMapping(@PathVariable int id) {
		Optional<Student> s = sr.findById(id);
		if(s.isPresent()) {
		sr.deleteById(id);
		return "Deleted Successfully";
		}else {
			return "Not found Student";
		}
	}
	@PutMapping("/updatestudent")
	public Student uodateStudent(@RequestParam int id, Student s) {
		Optional<Student> o = sr.findById(id);
		if(o.isPresent()) {
			s.setId(id);
			return sr.save(s);
		}else {
			return null;
		}
	}
	@PatchMapping("/updatestudentpassword")
	public Student updateStudentPassword(@RequestParam int id, @RequestParam String password) {
		Optional<Student> o = sr.findById(id);
		if(o.isPresent()) {
			Student s = o.get();
			s.setPassword(password);
			return sr.save(s);
		}else {
			return null;
		}
	}
	@GetMapping("/getbyemail")
	public Student getStudentByEmail(@RequestParam  String email) {
		return sr.findByEmail(email);
	}
	@GetMapping("/agegreaterthan")
	public List<Student> getStudentAgeGreaterThan(@RequestParam int age){
		return sr.getByAgeGreaterThan(age);
	}
	@GetMapping("/getbyemailquery")
	public Student getByEmailQuery(@RequestParam String email) {
		return sr.getByEmailQuery(email);
	}
}
