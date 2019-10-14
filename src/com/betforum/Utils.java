package com.betforum;

import java.util.ArrayList;
import java.util.List;

import com.dao.DaoFactory;
import com.dao.LigueDao;
import com.dao.QuestionDao;
import com.dao.SportDao;
import com.dao.UserDao;
import com.formulaire.User;

public class Utils {
	
	private static QuestionDao questionDao;
	private static UserDao userDao;
	private static SportDao sportDao;
	private static LigueDao ligueDao;
	
	//Retourne la liste des questions
	public static List<Question> getListQuestion() {
		List<Question> listQuestion = new ArrayList<Question>();
		DaoFactory daoFactory = DaoFactory.getInstance();
        questionDao = daoFactory.getQuestionDao();
        listQuestion = questionDao.lister();
        return listQuestion;
	}
	
	//Retourne la liste des users
	public static List<User> getListUser() {
		List<User> listUser = new ArrayList<User>();
		DaoFactory daoFactory = DaoFactory.getInstance();
        userDao = daoFactory.getUtilisateurDao();
        listUser = userDao.lister();
        return listUser;
	}
	
	//Retourne l'utilsateur passé en paramètre
	public static User getUser(int id) {
		User user = new User();
		for (User u : getListUser()) {
			if (u.getId() == id) {
				user = u;
			}
		}
        return user;
	}
	
	//Retourne la liste des sports
	public static List<Sport> getListSport() {
		List<Sport> listSport = new ArrayList<Sport>();
		DaoFactory daoFactory = DaoFactory.getInstance();
        sportDao = daoFactory.getSportDao();
        listSport = sportDao.lister();
        return listSport;
	}
	
	//Retourne la liste des ligues en fonction du sport
	public static List<Ligue> getListLigue(int idSport) {
		List<Ligue> listLigue = new ArrayList<Ligue>();
		List<Ligue> result = new ArrayList<Ligue>();
		DaoFactory daoFactory = DaoFactory.getInstance();
	    ligueDao = daoFactory.getLigueDao();
	    listLigue = ligueDao.lister();
	    for (Ligue l : listLigue) {
			if (l.getIdSport() == idSport) {
				result.add(l);
			}
		}
	    return result;
	}

}
