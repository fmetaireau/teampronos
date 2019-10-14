package com.servlets;

import java.io.IOException;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.betforum.Question;
import com.dao.DaoFactory;
import com.dao.QuestionDao;
import com.dao.UserDao;
import com.formulaire.User;

public class ListeQuestionServlet extends HttpServlet {
	private QuestionDao questionDao;
	
	public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.questionDao = daoFactory.getQuestionDao();
    }
	
	public void doGet( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException{
		this.getServletContext().getRequestDispatcher( "/jsp/forum/listequestion.jsp" ).forward( request, response );
	}
	
	public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        com.betforum.Question question = new Question();
        int id = questionDao.lister().size() + 1;
        User obj = (User) request.getSession().getAttribute("sessionUtilisateur");
        int idUser = 0;
        if (obj != null) {
        	idUser = obj.getId();
        }
        GregorianCalendar calendar = new GregorianCalendar();
		Date time  = (Date) calendar.getTime();
        question.setId(id);
        question.setQuestion(request.getParameter("sujet"));
        question.setIdUser(idUser);
        question.setDate(time);
        question.setSport(request.getParameter("sport"));
        question.setLigue(request.getParameter("ligue"));
        questionDao.ajouter(question);
        
        this.getServletContext().getRequestDispatcher("/jsp/profil/inscription.jsp").forward(request, response);
    }
	
}
