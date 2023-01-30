package com.project.momentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.momentum.entity.Course;

public interface CourseRepository extends JpaRepository<Course, Integer>{

}
