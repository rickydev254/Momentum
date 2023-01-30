package com.project.momentum.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.project.momentum.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Integer>{

}
