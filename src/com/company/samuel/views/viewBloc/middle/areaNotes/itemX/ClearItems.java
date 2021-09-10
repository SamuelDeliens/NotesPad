package com.company.samuel.views.viewBloc.middle.areaNotes.itemX;

import com.company.samuel.Main;
import com.company.samuel.models.Trash;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton de suppresion des elements de la corbeille
 */
public class ClearItems extends JButton {
    private Trash _trash;
    private int _widthScale;
    private int _heightScale;
    private int _widhtMore;

    public ClearItems(int widthScale, int heightScale, int widhtMore) {
        /**
         * Taille du Panel
         */
        _trash = VariablesGlobals.getBlocNoteCurrent().getTrash();
        _widthScale = widthScale;
        _heightScale = heightScale;
        _widhtMore = widhtMore;

        /**
         * Design
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(_widthScale+_widhtMore,_heightScale));
        this.setIcon();

        //Action
        this.addActionListener(e -> {
            /**
             * Si le contenu n'est pas vide, on supprime tous les elements de la poubelle
             * Raffraichit la vue
             */
            if (_trash.getContents().size() != 0) {
                _trash.clear();
                this.setIcon();
            }
            VariablesGlobals.getViewCurrent().setChildView();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light) et si l'on est dans la poubelle
     */
    private void setIcon() {
        if (VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash") && _trash.getContents().size() != 0) {
            if (VariablesGlobals.getStyle().equals("dark")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/trash.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/trash.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        }
    }
}
