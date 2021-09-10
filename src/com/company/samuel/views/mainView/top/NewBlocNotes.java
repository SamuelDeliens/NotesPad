package com.company.samuel.views.mainView.top;

import com.company.samuel.Main;
import com.company.samuel.views.viewAdder.ViewAdder;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton ajout nouveau BlocNotes
 */
public class NewBlocNotes extends JButton {

    public NewBlocNotes() {

        this.setIcon(); // definit l'icon

        /**
         * Style du bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());

        this.setText(" New BlocNote");

        this.addActionListener(e -> {
            /**
             * On crée une nouvelle vue --> vue d'ajout d'élement (parametre: type d'objet ajouté: blocNotes)
             */
            ViewAdder viewAdder = new ViewAdder("blocNotes");
            Main.addView(viewAdder);
            viewAdder.display();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/blocNotes+.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/blocNotes+.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
