package com.company.samuel.controllers;

import com.company.samuel.views.general.VariablesGlobals;


/**
 *      Classe abstraire permettant de gerer la liste de vue presente dans le Main
 */

public abstract class Views {

    public Views() {
        super();
        VariablesGlobals.setViewCurrent(this);
    }

    /**
     *     Presente 3methodes qui permettent de gerer les vues
     */
    public abstract void display();
    public abstract void close();
    public abstract void setChildView();
}
