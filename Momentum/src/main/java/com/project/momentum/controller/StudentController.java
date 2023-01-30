package com.project.momentum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.momentum.entity.Institution;
import com.project.momentum.entity.Student;
import com.project.momentum.exception.ResourceNotFound;
import com.project.momentum.repository.StudentRepository;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	public StudentRepository repository;
	
	@GetMapping("student")
	public List<Student> getAllStudent(){
		return repository.findAll();
	}
	
	@PostMapping("student")
	public Student saveStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable int id){
		Student student = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id: "+id));
		return ResponseEntity.ok(student);
	}
	
	@PutMapping("student/{id}")
	public ResponseEntity<Student> updateInstitution(@PathVariable int id, @RequestBody Student student){
		Student student2= repository.findById(id).orElseThrow(() -> new ResourceNotFound("No record found with this id:"+id));
		student2.setName(student.getName());
		Student updateStudent=repository.save(student2);
		return ResponseEntity.ok(updateStudent);
		
	}
	
	@DeleteMapping("student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterStudent(@PathVariable int id){
	Student student = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id:"+id));
	repository.delete(student);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
