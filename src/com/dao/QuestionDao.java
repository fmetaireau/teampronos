package com.dao;

import java.util.List;

import com.betforum.Question;

public interface QuestionDao {
	void ajouter( Question question );
    List<Question> lister();
}
