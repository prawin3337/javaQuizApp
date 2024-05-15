package com.prowin.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prowin.quizapp.dao.QuestionDao;
import com.prowin.quizapp.dao.QuizDao;
import com.prowin.quizapp.model.Questions;
import com.prowin.quizapp.model.Quiz;

@Service
public class QuizService {
	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Questions> questions = questionDao.findRandomQuestionsByCategory(category, numQ);
		
		Quiz quiz = new Quiz();
		quiz.setTitle(title);
		quiz.setQuestions(questions);
		
		quizDao.save(quiz);
		
		return new ResponseEntity("success", HttpStatus.CREATED); 
	}

}
