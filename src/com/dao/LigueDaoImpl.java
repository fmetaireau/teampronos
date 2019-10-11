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

public class LigueDaoImpl implements LigueDao {
	private DaoFactory daoFactory;

    LigueDaoImpl(DaoFactory daoFactory) {
        this.daoFactory = daoFactory;
    }
    
    public List<Ligue> lister() {
        List<Ligue> ligue = new ArrayList<Ligue>();
        Connection connexion = null;
        Statement statement = null;
        ResultSet resultat = null;

        try {
            connexion = daoFactory.getConnection();
            statement = connexion.createStatement();
            resultat = statement.executeQuery("SELECT id, libelleLigue, idSport FROM ligue;");

            while (resultat.next()) {
            	int id = resultat.getInt("id");
                String ligueSt = resultat.getString("libelleLigue");
                int idSport = resultat.getInt("idSport");

                Ligue l = new Ligue();
                l.setId(id);
                l.setLibelleLigue(ligueSt);
                l.setIdSport(idSport);

                ligue.add(l);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ligue;
    }
}
