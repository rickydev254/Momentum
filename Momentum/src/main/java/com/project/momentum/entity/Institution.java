package com.project.momentum.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "Institution") //Creating table to store institution details
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Institution {
	@Id @GeneratedValue
	private int id;
	@Column(unique = true) //Ensure every name is unique
	private String name;
	@Column
	private String address;
	@Column
	private int population;
	
	public void setId(int id) {
		this.id = id;
	}
	public int getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return address;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getPopulation() {
		return population;
	}

}
