package com.prowin.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowin.quizapp.model.BaseQuestion;
import com.prowin.quizapp.service.QuizService;

@RestController
@RequestMapping("quiz")
public class QuizController {
	
	@Autowired
	QuizService quizService;
	
	@PostMapping("create")
	public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int numQ, @RequestParam String title) {
		return quizService.createQuiz(category, numQ, title);
	}
	
	@GetMapping("get")
	public ResponseEntity<List<BaseQuestion>> getQuiz(@RequestParam int id) {
		return new ResponseEntity(quizService.getQuiz(id), HttpStatus.OK);
	}
}
