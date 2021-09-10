package com.company.samuel.views.viewAlert.alertContainer;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * Bouton acceptation de suppressions du SubItem
 */
public class AcceptButton extends JButton {

    public AcceptButton(SubItem elementSup) {

        /**
         * Design du Bouton
         */
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setOpaque(false);

        this.setText("Valider");

        //Action
        this.addActionListener(e -> {
            /**
             * Supprime definitivement un element (soit BlocNote: location null / soit Dossier: location non null)
             * recupere la vue pour la supprimer ensuite
             * supprime la vue de la liste
             * recupere l'ancienne vu
             */

                //supprime les espaces du nom afin de retrouver le path du fichier
            java.io.File file = new File("./data/"+elementSup.getName().replaceAll("\\s", "")+".ser");
            file.delete(); //supprimer le fichier
            Main.setListBloc(); //redefinit la liste de BlocNotes du Main

            Views viewAlert =  Main.getView(Main.listView.size()-1); //recupere la vue
            Main.removeView(Main.listView.size()-1); //supprime la vue de la liste
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size()-1)); //recupere l'ancienne vu

            VariablesGlobals.getViewCurrent().setChildView(); //rafraichit l'ancienne vue
            viewAlert.close(); //ferme la vue
        });
    }
}
