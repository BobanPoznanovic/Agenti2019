package com.example.agenti.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
public class TestController {

	@RequestMapping(value="/hi", method = RequestMethod.GET)
	public void testMethod() {
		System.out.println("Test method");
	}
}
