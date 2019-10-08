package com.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.formulaire.User;

public class UserDaoImpl implements UserDao {
    private DaoFactory daoFactory;

    UserDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }

    @Override
    public void ajouter(User utilisateur) {
        Connection connexion = null;
        PreparedStatement preparedStatement = null;

        try {
            connexion = daoFactory.getConnection();
            preparedStatement = connexion.prepareStatement("INSERT INTO user(id, email, login, password) VALUES(?, ?, ?, ?);");
            preparedStatement.setInt(1, utilisateur.getId());
            preparedStatement.setString(2, utilisateur.getEmail());
            preparedStatement.setString(3, utilisateur.getLogin());
            preparedStatement.setString(4, utilisateur.getPassword());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<User> lister() {
        List<User> utilisateurs = new ArrayList<User>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, email, login, password FROM user;");

            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String email = resultat.getString("email");
                String login = resultat.getString("login");
                String password = resultat.getString("password");

                User utilisateur = new User();
                utilisateur.setId(id);
                utilisateur.setEmail(email);
                utilisateur.setLogin(login);
                utilisateur.setPassword(password);

                utilisateurs.add(utilisateur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return utilisateurs;
    }

}