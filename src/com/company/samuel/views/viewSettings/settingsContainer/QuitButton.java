package com.company.samuel.views.viewSettings.settingsContainer;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton quitter vue
 */
public class QuitButton extends JPanel {
    private int widthTitleSettings;
    private int heightTitleSettings;
    private Dimension titleSettingsSize;

    public QuitButton(Dimension settingsContainerSize) {
        /**
         * Taille du Panel
         */
        this.widthTitleSettings = (int)(2*settingsContainerSize.getWidth()/2);
        this.heightTitleSettings = (int)settingsContainerSize.getHeight()/15;
        this.titleSettingsSize = new Dimension(widthTitleSettings, heightTitleSettings);

        /**
         * Design du panel
         */
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setOpaque(false);
        this.setPreferredSize(titleSettingsSize);
        this.setMaximumSize(titleSettingsSize);
        this.setMinimumSize(titleSettingsSize);

        /**
         * Bouton quitter de la vue
         */
        JButton quitSettings = new JButton();
        quitSettings.setText("quitter");

        //Action
        quitSettings.addActionListener(e -> {
            /**
             * On recupere l'ancienne vue, on supprime la vue courante afin d'annuler l'operation
             */
            Views viewSettings =  Main.getView(Main.listView.size()-1); //recupere la vue
            Main.removeView(Main.listView.size()-1); //supprime la vue de la liste
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size()-1)); //recupere l'ancienne vu
            viewSettings.close(); //ferme la vue
        });

        /**
         * Contents
         */
        this.add(quitSettings);
    }
}
