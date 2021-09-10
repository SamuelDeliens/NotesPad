package com.company.samuel.views.viewAlert.alertContainer;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;

/**
 * Bouton refus de suppression du SubItem
 */
public class QuitButton extends JButton {

    public QuitButton() {

        /**
         * Design du panel
         */
        this.setOpaque(false);
        this.setText("Annuler");

        //Action
        this.addActionListener(e -> {
            /**
             * On recupere l'ancienne vue, on supprime la vue courrante afin d'annuler l'operation
             */
            Views viewAdder =  Main.getView(Main.listView.size()-1); //recupere la vue
            Main.removeView(Main.listView.size()-1); //supprime la vue de la liste
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size()-1)); //recupere l'ancienne vu
            viewAdder.close(); //ferme la vue
        });
    }
}
