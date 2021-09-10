package com.company.samuel.views.viewSettings.settingsContainer.buttonSettings;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton definissant le style de l'application
 *  (dark ou light)
 */
public class StyleButton extends JButton {

    public StyleButton() {
        /**
         * Design du Bouton
         */
        this.setLayout(null);
        this.setText(VariablesGlobals.getStyle());
        this.setPreferredSize(new Dimension(100,30));

        //Action
        this.addActionListener(e -> {
            /**
             * Si on est en affichage darj, on passe en affichage light et inversement
             *  -on switch de style global
             *  -on raffraichit l'ancienne vue
             *  -on supprime la vue courante
             */
            VariablesGlobals.switchStyle();
            Main.getView(Main.listView.size()-2).setChildView();

            Views viewSettings =  Main.getView(Main.listView.size()-1); //recupere la vue
            Main.removeView(Main.listView.size()-1); //supprime la vue de la liste
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size()-1)); //recupere l'ancienne vu
            viewSettings.close(); //on ferme la vue courrante
        });
    }
}
