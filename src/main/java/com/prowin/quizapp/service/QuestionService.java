package com.prowin.quizapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prowin.quizapp.dao.QuestionDao;
import com.prowin.quizapp.model.Questions;

@Service
public class QuestionService {
	
	@Autowired
	QuestionDao questionDao;

	public ResponseEntity<List<Questions>> getAllQuestions() {
		try {
			return new ResponseEntity(questionDao.findAll(), HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return new ResponseEntity(new ArrayList(), HttpStatus.BAD_REQUEST);
		
	}

	public ResponseEntity<List<Questions>> getQuestionByCategory(String category) {
		try {
			return new ResponseEntity(questionDao.findByCategory(category), HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return new ResponseEntity(new ArrayList(), HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> addQuestion(Questions question) {
		try {
			questionDao.save(question);
			return new ResponseEntity("success",HttpStatus.CREATED);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> deleteQuestion(int id) {
		try {
			questionDao.deleteById(id);
			return new ResponseEntity("success", HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<String> updateQuestion(Questions question) {
		try {
			questionDao.save(question);
			return new ResponseEntity("success",HttpStatus.OK);
		}
		catch(Exception e) {
			System.out.println(e);
		}
		return new ResponseEntity("Failed", HttpStatus.BAD_REQUEST);
	}
	
}
