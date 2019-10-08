package com.servlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.DaoFactory;
import com.dao.UserDao;
import com.formulaire.User;

/**
 * Servlet implementation class Test
 */
@WebServlet("/Test")
public class InscriptionServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private UserDao utilisateurDao;

    public void init() throws ServletException {
        DaoFactory daoFactory = DaoFactory.getInstance();
        this.utilisateurDao = daoFactory.getUtilisateurDao();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("utilisateurs", utilisateurDao.lister());
        this.getServletContext().getRequestDispatcher("/jsp/profil/inscription.jsp").forward(request, response);
    }

    public void doPost( HttpServletRequest request, HttpServletResponse response ) throws ServletException, IOException {
        com.formulaire.User utilisateur = new User();
        int id = utilisateurDao.lister().size() + 1;
        utilisateur.setId(id);
        utilisateur.setEmail(request.getParameter("email"));
        utilisateur.setLogin(request.getParameter("pseudo"));
        utilisateur.setPassword(request.getParameter("password"));
        System.out.println(utilisateur);
        utilisateurDao.ajouter(utilisateur);
//        request.removeAttribute("email");
//        request.removeAttribute("pseudo");
//        request.removeAttribute("password");
        
        request.setAttribute("utilisateurs", utilisateurDao.lister());
        
        this.getServletContext().getRequestDispatcher("/jsp/profil/inscription.jsp").forward(request, response);
    }
    
    

}