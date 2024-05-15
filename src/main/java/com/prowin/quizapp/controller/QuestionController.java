package com.prowin.quizapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.prowin.quizapp.model.Questions;
import com.prowin.quizapp.service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
	
	@Autowired
	QuestionService questionService;
	
	@GetMapping("allQuestons")
	public List<Questions> getQuestions() {
		return questionService.getAllQuestions();
	}
	
	@GetMapping("category/{category}")
	public List<Questions> getQuestionByCategory(@PathVariable String category) {
		return questionService.getQuestionByCategory(category);
	}
	
	@PostMapping("add")
	public String addQuestion(@RequestBody Questions question) {
		return questionService.addQuestion(question);
	}
}
