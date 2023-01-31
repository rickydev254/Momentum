package com.project.momentum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.momentum.entity.Student;
import com.project.momentum.exception.ResourceNotFound;
import com.project.momentum.repository.StudentRepository;

import org.springframework.data.domain.Sort;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class StudentController {
	@Autowired
	public StudentRepository repository;
	
	//list all students
	//limit number of results to 10
	@GetMapping("student")
	public Page<Student> getAllStudent1(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<String> sortBy ){
		return repository.findByName(name.orElse("_"), PageRequest.of(page.orElse(0), 10,Sort.Direction.ASC, sortBy.orElse("id")));
	}

	//filter students using name and sort
	//pagination is also included
	@GetMapping("student/search")
	public Page<Student> getAllStudent(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<String> sortBy ){
		return repository.findByName(name.orElse("_"), PageRequest.of(page.orElse(0), 10,Sort.Direction.ASC, sortBy.orElse("id")));
		}
	
	//save a student
	@PostMapping("student")
	public Student saveStudent(@RequestBody Student student) {
		return repository.save(student);
	}
	//list a student using student id
	@GetMapping("student/{id}")
	public ResponseEntity<Student> getStudentByID(@PathVariable int id){
		Student student = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id: "+id));
		return ResponseEntity.ok(student);
	}
	
	//Update course and name and change university
	@PutMapping("student/{id}")
	public ResponseEntity<Student> updateInstitution(@PathVariable int id, @RequestBody Student student){
		Student student2= repository.findById(id).orElseThrow(() -> new ResourceNotFound("No record found with this id:"+id));
		student2.setName(student.getName());
		student2.setCourse(student.getCourse());
		student2.setUniversity(student.getUniversity());
		Student updateStudent=repository.save(student2);
		return ResponseEntity.ok(updateStudent);
		
	}
	
	//Delete student
	@DeleteMapping("student/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterStudent(@PathVariable int id){
	Student student = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id:"+id));
	repository.delete(student);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
