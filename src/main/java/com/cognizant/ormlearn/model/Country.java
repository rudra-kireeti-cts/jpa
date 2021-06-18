package com.cognizant.ormlearn.model;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "country", schema = "ormlearn")

public class Country {

	@Id
	@Column(name = "co_code")
	private String code;

	@Column(name = "co_name")
	private String name;

	// getters and setters

	// toString()
	
}