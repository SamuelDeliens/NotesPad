package com.company.samuel.views.viewFile.middle.editFile.topFile;

import com.company.samuel.Main;
import com.company.samuel.models.File;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton pour definir si le Fichier est epinglé ou non
 */
public class PinFile extends JButton {
    /**
     * Recupere le Fichier courant
     * Taille et variable _itemX pour y acceder dans changeIcon()
     */
    private File currentFile = VariablesGlobals.getFileCurrent();
    private int _widthScale;
    private int _heightScale;
    private int _widthMore;

    public PinFile(int widthScale, int heightScale, int widthMore) {
        _widthScale = widthScale;
        _heightScale = heightScale;
        _widthMore = widthMore;

        /**
         * Design du bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(_widthScale+ _widthMore,_heightScale));
        this.changeIcon();

        /**
         * On change l'icon et la variable du Fichier
         */
        this.addActionListener(e -> {
            currentFile.changePin();
            changeIcon();
            if (VariablesGlobals.getFolderCurrent().getContents().contains(currentFile)) {
                VariablesGlobals.getViewCurrent().setChildView();
            }
        });
    }

    /**
     * On verifie que l'on ne se situe pas dans la poubelle et l'état de l'epingle
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void changeIcon() {
        if (VariablesGlobals.getFolderCurrent().getTypeSubItem() != "Trash") {
            if (currentFile.getPin()) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/Pin.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/noPin2.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        }
    }
}
