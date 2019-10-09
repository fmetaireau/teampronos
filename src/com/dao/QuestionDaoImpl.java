package com.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.betforum.Question;

public class QuestionDaoImpl implements QuestionDao {
	private DaoFactory daoFactory;

    QuestionDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    public void ajouter(Question question) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO question(id, question, auteur, date) VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, question.getId());
            preparedStatement.setString(2, question.getQuestion());
            preparedStatement.setInt(3, question.getIdUser());
            Date date_util = question.getDate();
            java.sql.Date date_sql = new java.sql.Date(date_util.getTime());
            preparedStatement.setDate(4, date_sql);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Question> lister() {
        List<Question> questions = new ArrayList<Question>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, question, auteur, date FROM question;");

            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String questionSt = resultat.getString("question");
                int idUser = resultat.getInt("auteur");
                Date date = resultat.getDate("date");

                Question question = new Question();
                question.setId(id);
                question.setQuestion(questionSt);
                question.setIdUser(idUser);
                question.setDate(date);

                questions.add(question);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }
}
