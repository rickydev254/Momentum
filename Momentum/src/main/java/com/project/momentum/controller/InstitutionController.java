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

import com.project.momentum.entity.Institution;
import com.project.momentum.entity.Student;
import com.project.momentum.exception.ResourceNotFound;
import com.project.momentum.repository.InstitutionRepository;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class InstitutionController {
	@Autowired
	public InstitutionRepository repository;
	
	//list all institution
	@GetMapping("institution")
	public List<Institution> getAllInstitution(){
		return repository.findAll();
	}
	
	//saves a new institution
	@PostMapping("institution")
	public Institution saveInstitution(@RequestBody Institution institution) {
		return repository.save(institution);
	}
	//filter the list of institutions
	//Limits results returned per page to 10
	@GetMapping("institution/search")
	public Page<Institution> getAllInstitution(@RequestParam Optional<String> name, @RequestParam Optional<Integer> page, Optional<String> sortBy ){
		return repository.findByName1(name.orElse("_"), PageRequest.of(page.orElse(0), 10,Sort.Direction.ASC, sortBy.orElse("id")));
	}
	
	//show institution details of a given id
	@GetMapping("institution/{id}")
	public ResponseEntity<Institution> getInstitutionByID(@PathVariable int id){
		Institution institution = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id: "+id));
		return ResponseEntity.ok(institution);
	}
	//update an existing institution
	@PutMapping("institution/{id}")
	public ResponseEntity<Institution> updateInstitution(@PathVariable int id, @RequestBody Institution institution){
		Institution institution2= repository.findById(id).orElseThrow(() -> new ResourceNotFound("No record found with this id:"+id));
		institution2.setName(institution.getName());
		institution2.setAddress(institution.getAddress());
		institution2.setPopulation(institution.getPopulation());
		Institution updateInstitution=repository.save(institution2);
		return ResponseEntity.ok(updateInstitution);
		
	}
	//delete an institution
	@DeleteMapping("institution/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterInstitution(@PathVariable int id){
	Institution institution= repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id:"+id));
	repository.delete(institution);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
