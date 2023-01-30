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
import com.project.momentum.exception.ResourceNotFound;
import com.project.momentum.repository.InstitutionRepository;

@RestController
@RequestMapping("api/v1")
@CrossOrigin(origins = "http://localhost:4200")
public class InstitutionController {
	@Autowired
	public InstitutionRepository repository;
	
	@GetMapping("institution")
	public List<Institution> getAllInstitution(){
		return repository.findAll();
	}
	
	@PostMapping("institution")
	public Institution saveInstitution(@RequestBody Institution institution) {
		return repository.save(institution);
	}
	
	@GetMapping("institution/{id}")
	public ResponseEntity<Institution> getInstitutionByID(@PathVariable int id){
		Institution institution = repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id: "+id));
		return ResponseEntity.ok(institution);
	}
	
	@PutMapping("institution/{id}")
	public ResponseEntity<Institution> updateInstitution(@PathVariable int id, @RequestBody Institution institution){
		Institution institution2= repository.findById(id).orElseThrow(() -> new ResourceNotFound("No record found with this id:"+id));
		institution2.setName(institution.getName());
		institution2.setAddress(institution.getAddress());
		institution2.setPopulation(institution.getPopulation());
		Institution updateInstitution=repository.save(institution2);
		return ResponseEntity.ok(updateInstitution);
		
	}
	
	@DeleteMapping("institution/{id}")
	public ResponseEntity<Map<String, Boolean>> deleterInstitution(@PathVariable int id){
	Institution institution= repository.findById(id).orElseThrow(()-> new ResourceNotFound("No record found with this id:"+id));
	repository.delete(institution);
	Map<String, Boolean> response = new HashMap<>();
	response.put("deleted", Boolean.TRUE);
	return ResponseEntity.ok(response);
	}

}
