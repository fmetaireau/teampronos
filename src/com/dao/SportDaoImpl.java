package com.dao;

import java.sql.Connection;
import java.util.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.betforum.Ligue;
import com.betforum.Question;
import com.betforum.Sport;

public class SportDaoImpl implements SportDao {
	private DaoFactory daoFactory;

    SportDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public List<Sport> lister() {
        List<Sport> sport = new ArrayList<Sport>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, libelleSport FROM sport;");

            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String sportSt = resultat.getString("libelleSport");

                Sport s = new Sport();
                s.setId(id);
                s.setLibelleSport(sportSt);

                sport.add(s);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sport;
    }
}
