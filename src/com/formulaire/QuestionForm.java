package com.formulaire;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.betforum.Question;

public class QuestionForm {
	
	private static final String CHAMP_SUJET  = "sujet";
	
    private String resultat;
    private Map<String, String> erreurs = new HashMap<String, String>();

    public String getResultat() {
        return resultat;
    }

    public Map<String, String> getErreurs() {
        return erreurs;
    }
    
    public Question doQuestion( HttpServletRequest request ) {
        String sujet = getValeurChamp( request, CHAMP_SUJET );

        Question question = new Question();
        
        try {
            validationSujet( sujet );
        } catch ( Exception e ) {
            setErreur( CHAMP_SUJET, e.getMessage() );
        }
        question.setQuestion( sujet );

        if ( erreurs.isEmpty() ) {
            resultat = "Question posée.";
        } else {
            resultat = "Échec question posée.";
        }

        return question;
    }
    
    private void validationSujet( String sujet ) throws Exception {
        if ( sujet == null ) {
            throw new Exception( "Merci de saisir une question." );
        }
    }

    /*
     * Ajoute un message correspondant au champ spécifié à la map des erreurs.
     */
    private void setErreur( String champ, String message ) {
        erreurs.put( champ, message );
    }

    /*
     * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
     * sinon.
     */
    private static String getValeurChamp( HttpServletRequest request, String nomChamp ) {
        String valeur = request.getParameter( nomChamp );
        if ( valeur == null || valeur.trim().length() == 0 ) {
            return null;
        } else {
            return valeur.trim();
        }
    }
    
}
