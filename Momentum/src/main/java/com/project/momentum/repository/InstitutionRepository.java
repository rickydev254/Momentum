package com.project.momentum.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.project.momentum.entity.Institution;
import com.project.momentum.entity.Student;

public interface InstitutionRepository extends JpaRepository<Institution, Integer>{
	
	@Query ("select s from Institution s where name like %?1%")
	Page<Institution> findByName1(String name, PageRequest pageRequest);
	List<Institution> findByName(String name);

}
