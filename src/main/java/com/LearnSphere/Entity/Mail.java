package com.LearnSphere.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Mail {
	String message;
	
	@Id
	@GeneratedValue(strategy =GenerationType.AUTO)
	int id;
}
