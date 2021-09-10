package com.company.samuel.views.mainView.top;

import com.company.samuel.Main;
import com.company.samuel.views.viewSettings.ViewSettings;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton de definission des Settings
 */
public class SettingsButton extends JButton{

    public SettingsButton() {

        /**
         * Style du bouton
         */
        this.setIcon(); // definit l'icon
        this.setMargin(new Insets(10,0,0,10));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());

        this.setText(" Settings");

        //Action
        this.addActionListener(e -> {
            /**
             * On crée une nouvelle vue --> vue de definition des parametres
             */
            ViewSettings viewSettings;
            /**
             * On utilise la vue sur le dossier recherche si existant, sinon on utilise le dossier courrant
             */
            if (VariablesGlobals.getFolderSearch() == null) {
                viewSettings = new ViewSettings(VariablesGlobals.getFolderCurrent());
            } else {
                viewSettings = new ViewSettings(VariablesGlobals.getFolderSearch());
            }
            Main.addView(viewSettings);
            viewSettings.display();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/settings.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/settings.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
