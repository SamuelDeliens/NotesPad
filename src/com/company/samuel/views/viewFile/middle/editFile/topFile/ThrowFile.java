package com.company.samuel.views.viewFile.middle.editFile.topFile;

import com.company.samuel.Main;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton pour jeter le Fichier dans la poubelle / ou pour le redeplacer dans son dossier origine
 */
public class ThrowFile extends JButton {
    /**
     * Recupere le Fichier, Dossier et BlocNotes courants
     * Taille et variable _itemX pour y acceder dans setIcon()
     */
    private File currentFile = VariablesGlobals.getFileCurrent();
    private Folder currentFolder = VariablesGlobals.getFolderCurrent();
    private BlocNotes currentBlocNotes = VariablesGlobals.getBlocNoteCurrent();
    private int _widthScale;
    private int _heightScale;
    private int _widhtMore;

    public ThrowFile(int widthScale, int heightScale, int widhtMore) {
        _widthScale = widthScale;
        _heightScale = heightScale;
        _widhtMore = widhtMore;

        /**
         * Design du bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(_widthScale+_widhtMore,_heightScale));
        this.setIcon();

        /**
         * On change deplace le fichier et on change l'icon
         *  --> si le fichier est dans la poubelle on le deplace dans son fichier d'origine
         */
        this.addActionListener(e -> {
            if (!currentFolder.getTypeSubItem().equals("Trash")) {
                currentFolder.moveTrash(currentFile, currentBlocNotes.getTrash());
                VariablesGlobals.setFolderCurrent(currentBlocNotes.getTrash());
                VariablesGlobals.getViewCurrent().setChildView();
            }
            else if (currentFolder.getTypeSubItem().equals("Trash")) {
                currentFolder.move(currentFile, currentFile.getLocation());
                VariablesGlobals.setFolderCurrent(currentFile.getLocation());
                VariablesGlobals.getViewCurrent().setChildView();
            }
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     * On verifie que l'epingle est false (pour pouvoir le deplacer dans la poubelle, il est necessaire de desactiver l'epingle)
     * On verifie que le dossier courrant est la poubelle ou non --> soit on le deplace dans la poubelle, soit on le retire
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            if (!currentFile.getPin() && !currentFolder.getTypeSubItem().equals("Trash")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/Trash.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
            else if (currentFolder.getTypeSubItem().equals("Trash")){
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/restaure.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        } else {
            if (!currentFile.getPin() && !currentFolder.getTypeSubItem().equals("Trash")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/Trash.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
            else if (currentFolder.getTypeSubItem().equals("Trash")){
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/restaure.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        }
    }
}
