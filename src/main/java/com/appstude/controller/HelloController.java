package com.appstude.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.appstude.dto.HelloDto;

@RestController
@RequestMapping("/api")
public class HelloController {

	@GetMapping("/hello")
	public String getData() {
		return "Hello Wrold";
	}
	
	@PostMapping(value = "/postData")
    public HelloDto postData(@RequestBody HelloDto hello) {
        return hello;
    }
	
	
	 @GetMapping(value = "/jsonData")
	    public HelloDto json() {
	        return new HelloDto("Greetings", "Hello World");
	    }
	 
	
}
