package com.company.samuel.views.viewAdder.adderContainer;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton refus d'ajout du SubItem
 */
public class QuitButton extends JPanel {
    private int widthButton;
    private int heightButton;
    private Dimension buttonSize;

    public QuitButton(Dimension settingsContainerSize, SubItem newItem) {
        /**
         * Taille du Panel
         */
        this.widthButton = (int)(2*settingsContainerSize.getWidth()/2);
        this.heightButton = (int)settingsContainerSize.getHeight()/8;
        this.buttonSize = new Dimension(widthButton, heightButton);

        /**
         * Design du panel
         */
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setOpaque(false);
        this.setPreferredSize(buttonSize);
        this.setMaximumSize(buttonSize);
        this.setMinimumSize(buttonSize);

        /**
         * Bouton quitter de la vue
         */
        JButton quitAdder = new JButton();
        quitAdder.setText("Annuler");

        //Action
        quitAdder.addActionListener(e -> {
            /**
             * On recupere l'ancienne vue, on supprime la vue courante afin d'annuler l'operation
             */
            Views viewAdder =  Main.getView(Main.listView.size()-1); //recupere la vue
            Main.removeView(Main.listView.size()-1); //supprime la vue de la liste
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size()-1)); //recupere l'ancienne vu
            viewAdder.close(); //ferme la vue
        });

        /**
         * Contents
         */
        this.add(quitAdder);
    }
}
