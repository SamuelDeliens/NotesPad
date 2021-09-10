package com.company.samuel.views.viewBloc.middle.areaNotes.itemX;

import com.company.samuel.Main;
import com.company.samuel.controllers.*;
import com.company.samuel.models.*;
import com.company.samuel.views.viewFile.ViewFile;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Definit le bouton pour ouvrir le SubItem
 */
public class IconButton extends JButton {
    public IconButton(SubItem itemX, int widthScale, int heightScale, int widhtMore) {
        /**
         * Design
         * taille en fonction des variables passées en parametre
         *      widthScale et heightScale --> redefinition de la taille de l'icon
         *      widthMore --> definition en plus du Button
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(Color.BLACK);
        this.setPreferredSize(new Dimension(widthScale+widhtMore,heightScale));

        /**
         * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
         * Definit aussi en fonction du type (folder ou file)
         */
        //Si dossier
        if (itemX.getTypeSubItem().equals("Folder")) {
            if (VariablesGlobals.getStyle().equals("dark")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/folder.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(widthScale,heightScale,Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/folder.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(widthScale,heightScale,Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }

            /**
             * Ouverture du dossier
             * On change le dossier courant et on raffraichit la vue
             */
            //Si on est pas dans la poubelle
            if (!VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
                this.addActionListener(e -> {
                    VariablesGlobals.setFolderCurrent((Folder) itemX);
                    VariablesGlobals.getViewCurrent().setChildView();
                });
            }
        }
        //Si fichier
        else if (itemX.getTypeSubItem().equals("File")) {
            if (VariablesGlobals.getStyle().equals("dark")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/notepad.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(widthScale,heightScale,Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else{
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/notepad.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(widthScale,heightScale,Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }

            /**
             * Edition du fichier
             * On recupere la vue courante
             * On affiche une nouvelle vue (viewFile)
             * On ferme l'ancienne vue
             */
            //Si on est pas dans la poubelle
            if (!VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
                this.addActionListener(e -> {
                    Views viewBloc = VariablesGlobals.getViewCurrent();

                    Views viewFile = new ViewFile((File) itemX);
                    Main.addView(viewFile);
                    viewFile.display();

                    viewBloc.close();
                });
            }
        }
    }
}
