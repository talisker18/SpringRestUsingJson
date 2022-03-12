package com.henz.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.henz.model.Greeting;

/*
 * spring web starter (see child dependencies) uses jackson under the hood with default deserializing using json
 * 
 * 
 * */


/**
 * see also: /SpringRestUsingJson2, using lombok annotations, validation annotations, exception handling etc
 * 
 * */

@RestController
public class GreetingController {
	
	private static final String template = "hello, %s";
	private final AtomicLong counter = new AtomicLong();
	
	@GetMapping("/greeting") //it returns json by default because under the hood jackson deserializes to json
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "world") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@PostMapping("/greeting")
	public void createGreeting(@Validated @RequestBody Greeting greeting) {
		System.out.println(greeting.getId());
		System.out.println(greeting.getContent());
	}

}
