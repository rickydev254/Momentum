package com.project.momentum.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

import com.project.momentum.entity.Course;
import com.project.momentum.entity.Institution;
import com.project.momentum.entity.Student;
import com.project.momentum.exception.ResourceNotFound;
import com.project.momentum.repository.CourseRepository;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class CourseController {
	@Autowired
	public CourseRepository repository;
	//list all courses
	@GetMapping("course")
	public List<Course> getAllCourse(){
		return repository.findAll();
	}
	//filter students using name and sort
	//pagination is limited to 10
	@GetMapping("course/search")
	public Page<Course> getAllCourse(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<String> sortBy ){
		return repository.findByCourseName(name.orElse("_"), PageRequest.of(page.orElse(0), 10,Sort.Direction.ASC, sortBy.orElse("id")));
		}
	//Add a new course
	@PostMapping("course")
	public Course saveCourse(@RequestBody Course course) {
		return repository.save(course);
	}
	//Get a course by its ID
	@GetMapping("course/{id}")
	public ResponseEntity<Course> getCourseByID(@PathVariable int id){
		Course course = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id: "+id));
		return ResponseEntity.ok(course);
	}
	//Edit a course name
	@PutMapping("course/{id}")
	public ResponseEntity<Course> updateCourse(@PathVariable int id, @RequestBody Course course){
		Course course2= repository.findById(id).orElseThrow(() -> new ResourceNotFound("No record found with this id:"+id));
		course2.setName(course.getName());
		Course updateCourse=repository.save(course2);
		return ResponseEntity.ok(updateCourse);
		
	}
	//Delete a course
	@DeleteMapping("course/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterCourse(@PathVariable int id){
	Course course= repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id:"+id));
	repository.delete(course);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
