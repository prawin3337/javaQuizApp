package com.prowin.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.prowin.quizapp.model.BaseQuestion;
import com.prowin.quizapp.model.UserRes;
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
	
	@GetMapping("get/{id}")
	public ResponseEntity<List<BaseQuestion>> getQuiz(@PathVariable int id) {
		return new ResponseEntity(quizService.getQuiz(id), HttpStatus.OK);
	}
	
	@PostMapping("result/{id}")
	public ResponseEntity<Integer> getResult(@PathVariable int id, @RequestBody List<UserRes> userRes) {
		return quizService.getResult(id, userRes);
	}
}
