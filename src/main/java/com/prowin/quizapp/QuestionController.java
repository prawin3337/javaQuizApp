package com.prowin.quizapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("question")
public class QuestionController {
	@GetMapping("allQuestons")
	public String getQuestions() {
		return "from questons";
	}
}
