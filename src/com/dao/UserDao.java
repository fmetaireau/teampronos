package com.dao;

import java.util.List;

import com.formulaire.User;

public interface UserDao {
    void ajouter( User utilisateur );
    List<User> lister();
}