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

import com.project.momentum.entity.Course;
import com.project.momentum.entity.Institution;
import com.project.momentum.exception.ResourceNotFound;
import com.project.momentum.repository.CourseRepository;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	@Autowired
	public CourseRepository repository;
	
	@GetMapping("course")
	public List<Course> getAllCourse(){
		return repository.findAll();
	}
	
	@PostMapping("course")
	public Course saveCourse(@RequestBody Course course) {
		return repository.save(course);
	}
	
	@GetMapping("course/{id}")
	public ResponseEntity<Course> getCourseByID(@PathVariable int id){
		Course course = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id: "+id));
		return ResponseEntity.ok(course);
	}
	
	@PutMapping("course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course){
		Course course2= repository.findById(id).orElseThrow(() -> new ResourceNotFound("No record found with this id:"+id));
		course2.setName(course.getName());
		Course updateCourse=repository.save(course2);
		return ResponseEntity.ok(updateCourse);
		
	}
	
	@DeleteMapping("course/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterCourse(@PathVariable int id){
	Course course= repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id:"+id));
	repository.delete(course);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
