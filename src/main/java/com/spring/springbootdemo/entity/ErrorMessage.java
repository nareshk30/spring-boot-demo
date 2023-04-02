package com.spring.springbootdemo.entity;

import org.springframework.http.HttpStatus;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ErrorMessage {
	
	private HttpStatus status;
	private String message;
	public ErrorMessage(HttpStatus status, String message) {
		super();
		this.status = status;
		this.message = message;
	}
	
	

}
