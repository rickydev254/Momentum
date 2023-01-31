package com.project.momentum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.momentum.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{
	
	@Query ("select s from Course s where name like %?1%")
	Page<Course> findByCourseName(String name, PageRequest pageRequest);
	List<Course> findByName(String name);

}
