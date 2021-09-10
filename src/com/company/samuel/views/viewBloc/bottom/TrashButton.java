package com.company.samuel.views.viewBloc.bottom;

import com.company.samuel.Main;
import com.company.samuel.models.Folder;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton pour se diriger dans la poubelle du BlocNotes
 */
public class TrashButton extends JButton {
    /**
     * Récupere la poubelle du BlocNotes
     */
    private Folder trash;

    public TrashButton() {

        /**
         * Design
         */
        setIcon();
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setText(" Trash");

        //Action
        this.addActionListener(e -> {
            /**
             * On definit le dossier recherche en null (au cas ou on effectuait une recherche)
             * On change ensuite le dossier courant par la poubelle du BlocNotes
             * Raffraichit la vue courante
             */
            VariablesGlobals.setFolderSearch(null);
            trash = VariablesGlobals.getBlocNoteCurrent().getTrash();
            VariablesGlobals.setFolderCurrent((Folder) trash);
            VariablesGlobals.getViewCurrent().setChildView();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/trash.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/trash.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
