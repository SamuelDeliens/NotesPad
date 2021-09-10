package com.company.samuel.views.viewBloc.top;

import com.company.samuel.Main;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Permet de sauvegarder les modificatiosn du dossier courant
 */
public class SaveButton extends JButton{
    /**
     * Recupere le dossier courant
     * variable icon afin d'y acceder dans setIcon()
     */
    private Folder folderB = VariablesGlobals.getFolderCurrent();
    private ImageIcon icon, iconR;

    public SaveButton() {
        /**
         * Design
         */
        this.setMargin(new Insets(10,10,0,0));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());

        this.setText(" Save");
        setIcon("save");

        //Action
        this.addActionListener(e -> {
            /**
             * On sauvegarde le blocNote courant dans son fichier
             * On change l'affichage
             */
            System.out.println("Good Job Mr. Negre");
            VariablesGlobals.getBlocNoteCurrent().save(VariablesGlobals.getBlocNoteCurrent());
            this.setText(" Already save");
            setIcon("saved");
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     * Definit aussi en fonction de si on a sauvegarder à l'instant ou non
     * @param save
     */
    private void setIcon(String save) {
        //selon style
        if (VariablesGlobals.getStyle().equals("dark")) {
            //si souvegardé ou non
            if (save.equals("save")) {
                icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/save.png"));
                iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/saved.png"));
                iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        } else {
            if (save.equals("save")) {
                icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/save.png"));
                iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/saved.png"));
                iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        }
    }
}
