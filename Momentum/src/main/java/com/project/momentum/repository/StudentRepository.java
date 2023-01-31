package com.project.momentum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.momentum.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{
	
	@Query ("select s from Student s where name like %?1%")
	Page<Student> findByName(String name, PageRequest pageRequest);
	
	//List<Student> findByStudentName(String name);
}
