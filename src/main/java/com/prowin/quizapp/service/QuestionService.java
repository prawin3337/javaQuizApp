package com.prowin.quizapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prowin.quizapp.dao.QuestionDao;
import com.prowin.quizapp.model.Questions;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public List<Questions> getAllQuestions() {
		// TODO Auto-generated method stub
		return questionDao.findAll();
	}
	
}
