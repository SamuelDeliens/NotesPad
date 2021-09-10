package com.company.samuel.views.mainView.middle.areaNotes.itemX;

import com.company.samuel.Main;

import com.company.samuel.controllers.Views;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.ViewBloc;

import javax.swing.*;
import java.awt.*;

/**
 * Definit le bouton pour ouvrir le BlocNotes
 */
public class IconButton extends JButton {

    public IconButton(BlocNotes itemX, int widthScale, int heightScale, int widhtMore) {
        /**
         * Style du Bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(Color.BLACK);
        this.setPreferredSize(new Dimension(widthScale + widhtMore, heightScale));

        /**
         * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
         */
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/StickMan.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(widthScale, heightScale, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/StickMan.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(widthScale, heightScale, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }


        /**
         * Ouverture du BlocNotes
         */
        this.addActionListener(e -> {
            VariablesGlobals.setBlocNoteCurrent(itemX); //Definit blocNote ouvert --> BlocNoteCurrent

            Views mainView = VariablesGlobals.getViewCurrent(); //Recupere la vue courrante

            /**
             * Crée une nouvelle vue en supprimant l'ancienne
             */
            ViewBloc viewBloc = new ViewBloc(itemX);
            Main.removeView(0);
            Main.addView(viewBloc);
            viewBloc.display();

            mainView.close();
        });
    }
}
