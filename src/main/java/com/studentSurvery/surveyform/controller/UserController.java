package com.studentSurvery.surveyform.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.studentSurvery.surveyform.entity.UserDetails;
import com.studentSurvery.surveyform.repository.UserRepository;

import org.springframework.ui.Model;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;



@Controller
public class UserController {
	
	@Autowired
	private UserRepository repo;
	
	
	@GetMapping("/")
	public String home(Model model) {
		 model.addAttribute("UserDetails", new UserDetails());
		return "index";
	}
	
	@GetMapping("/surveys")
	public ResponseEntity<List<UserDetails>> getAllSurveys() {
	    List<UserDetails> surveys = repo.findAll();
	    if (surveys.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	    return new ResponseEntity<>(surveys, HttpStatus.OK);
	}

	
	@PostMapping("/submit")
    public ResponseEntity<?> submitForm(@RequestBody UserDetails userObject) {
        // map fields from userObject to Student entity
		System.out.println(userObject);
		repo.save(userObject);
        return ResponseEntity.ok().build();
    }
}


