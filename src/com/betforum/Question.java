package com.betforum;

import java.util.Date;

public class Question {
	
	private int id;
	private String question;
	private int idUser;
	private Date date;
	private String sport;
	private String ligue;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public int getIdUser() {
		return idUser;
	}
	public void setIdUser(int idUser) {
		this.idUser = idUser;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date time) {
		this.date = time;
	}
	public String getSport() {
		return sport;
	}
	public void setSport(String sport) {
		this.sport = sport;
	}
	public String getLigue() {
		return ligue;
	}
	public void setLigue(String ligue) {
		this.ligue = ligue;
	}
}
