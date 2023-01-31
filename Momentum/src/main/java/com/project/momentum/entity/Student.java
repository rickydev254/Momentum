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
@Table(name = "Student")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Student {
	@Id @GeneratedValue
	private int id;
	@Column
	private String name;
	@Column
	private String course;
	@Column
	private String university;
	
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
	public void setCourse(String course) {
		this.course = course;
	}
	public String getCourse() {
		return course;
	}
	public void setUniversity(String university) {
		this.university = university;
	}
	public String getUniversity() {
		return university;
	}

}
