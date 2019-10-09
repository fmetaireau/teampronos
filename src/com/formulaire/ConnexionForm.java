package com.formulaire;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.dao.UserDao;


public final class ConnexionForm {
    private static final String CHAMP_EMAIL  = "email";
    private static final String CHAMP_PASS   = "motdepasse";
    private static final String COMPTE   = "compte";

    private String              resultat;
    private Map<String, String> erreurs      = new HashMap<String, String>();
    
    private UserDao utilisateurDao;
    
    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }

    public User connecterUtilisateur( HttpServletRequest request, List<User> listUser ) {
        /* R�cup�ration des champs du formulaire */
        String email = getValeurChamp( request, CHAMP_EMAIL );
        String motDePasse = getValeurChamp( request, CHAMP_PASS );

        User utilisateur = new User();

        /* Validation du champ email. */
        try {
            validationEmail( email );
        } catch ( Exception e ) {
            setErreur( CHAMP_EMAIL, e.getMessage() );
        }
        utilisateur.setEmail( email );

        /* Validation du champ mot de passe. */
        try {
            validationMotDePasse( motDePasse );
        } catch ( Exception e ) {
            setErreur( CHAMP_PASS, e.getMessage() );
        }
        utilisateur.setPassword( motDePasse );
        
        /* Validation du champ mot de passe. */
        try {
        	validationUser( email, motDePasse, listUser);
        } catch ( Exception e ) {
            setErreur( COMPTE, e.getMessage() );
        }
        /* Initialisation du r�sultat global de la validation. */
        if ( erreurs.isEmpty() ) {
            resultat = "Succ�s de la connexion.";
        } else {
            resultat = "�chec de la connexion.";
        }
        
        for (User user : listUser) {
    		if (user.getEmail().equals(email) && user.getPassword().equals(motDePasse)) {
    			utilisateur.setId(user.getId());
    			utilisateur.setLogin(user.getLogin());
    		}
    	}
        
        return utilisateur;
    }

    /**
     * Valide l'adresse email saisie.
     */
    private void validationEmail( String email ) throws Exception {
        if ( email != null && !email.matches( "([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)" ) ) {
            throw new Exception( "Merci de saisir une adresse mail valide." );
        }
    }

    /**
     * Valide le mot de passe saisi.
     */
    private void validationMotDePasse( String motDePasse ) throws Exception {
        if ( motDePasse != null ) {
            if ( motDePasse.length() < 3 ) {
                throw new Exception( "Le mot de passe doit contenir au moins 3 caract�res." );
            }
        } else {
            throw new Exception( "Merci de saisir votre mot de passe." );
        }
    }
    
    /**
     * Valide si l'utilisateur existe.
     */
    private void validationUser( String email, String motDePasse, List<User> listUser ) throws Exception {
    	boolean mail = false;
		boolean pass = false;
    	for (User user : listUser) {
    		if (user.getEmail().equals(email)) {
    			mail = true;
    			if (user.getPassword().equals(motDePasse)) {
    				pass = true;
    			} else {
    				mail = false;
    			}
    		}
    	}
    	if (!mail) {
    		throw new Exception( "Le mail ne correspond � aucun compte." );
    	}
    	if (!pass) {
    		throw new Exception( "Le mot de passe est invalise pour cette adrese mail." );
    	}
    }

    /*
     * Ajoute un message correspondant au champ sp�cifi� � la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * M�thode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur;
        }
    }
}
