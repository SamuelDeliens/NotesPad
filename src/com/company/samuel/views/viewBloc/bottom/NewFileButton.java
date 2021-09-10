package com.company.samuel.views.viewBloc.bottom;

import com.company.samuel.Main;
import com.company.samuel.models.*;
import com.company.samuel.views.viewAdder.ViewAdder;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton ajout nouveau Fichier
 */
public class NewFileButton extends JButton {
    /**
     * Récupere le dossier courant
     */
    private Folder folderN = VariablesGlobals.getFolderCurrent();

    public NewFileButton() {

        /**
         * Design
         */
        setIcon();
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setText(" New File");

        //Action
        this.addActionListener(e -> {
            /**
             * On definit le dossier recherche en null (au cas ou on effectuait une recherche)
             * On ouvre ensuite une nouvelle vue Adder afin de poursuivre l'ajout du Fichier
             */
            VariablesGlobals.setFolderSearch(null);
            //Nouvelle vue avec "file" en parametre comme type d'ajout
            ViewAdder viewAdder = new ViewAdder("file");
            Main.addView(viewAdder);
            viewAdder.display();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/notepad+.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/notepad+.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
