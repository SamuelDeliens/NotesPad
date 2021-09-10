package com.company.samuel.views.mainView.middle.areaNotes.itemX;

import com.company.samuel.Main;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewAlert.ViewAlert;

import javax.swing.*;
import java.awt.*;

/**
 * Definit le bouton pour supprimer le BlocNotes
 */
public class ThrowButton extends JButton {
    private SubItem _itemX;
    private int _widthScale;
    private int _heightScale;
    private int _widhtMore;

    public ThrowButton(BlocNotes itemX, int widthScale, int heightScale, int widhtMore) {
        _itemX = itemX;
        _widthScale = widthScale;
        _heightScale = heightScale;
        _widhtMore = widhtMore;

        /**
         * Style du Bouton et icon
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(_widthScale+_widhtMore,_heightScale));
        this.setIcon();

        //Action
        this.addActionListener(e -> {
            /**
             * On affiche une nouvelle vue afin de supprimer le BlocNotes (AlerMessage --> Sécurité)
             * on utilise le blocNotes en parametre
             */
            ViewAlert viewAlert = new ViewAlert(_itemX);
            Main.addView(viewAlert);
            viewAlert.display();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/Trash.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/Trash.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }

    }
}
