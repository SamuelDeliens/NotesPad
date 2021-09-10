package com.company.samuel.views.viewFile.top;

import com.company.samuel.Main;
import com.company.samuel.models.File;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Permet de sauvegarder les modifications du fichier a modifier dans le fichier courant
 */
public class SaveButton extends JButton {
    /**
     * Recupere le fichier courrant
     * Recupere le fichier modifié (fichier tampon)
     */
    private File file = VariablesGlobals.getFileCurrent();
    private File fileModif = VariablesGlobals.getFileModified();
    private ImageIcon icon, iconR;

    public SaveButton() {
        setIcon("save");

        /**
         * Design du bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setText(" Save");

        //Action
        this.addActionListener(e -> {
            /**
             * Definit le contenu du fichier courant avec le contenu du fichier tampon
             * On change l'affichage
             */

            file.setName(fileModif.getName());
            file.setText(fileModif.getContent());
            this.setText(" Already Save");
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
        //selon style
        } else {
            //si souvegardé ou non
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
