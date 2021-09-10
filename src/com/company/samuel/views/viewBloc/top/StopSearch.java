package com.company.samuel.views.viewBloc.top;

import com.company.samuel.Main;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton permettant de stoper la recherche en cours
 */
public class StopSearch extends JButton{
    /**
     * Recupere le dossier courant
     */
    private Folder folderB = VariablesGlobals.getFolderCurrent();

    public StopSearch() {

        /**
         * Design
         */
        setIcon();
        this.setMargin(new Insets(10,10,0,0));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());

        this.setText(" "+folderB.getName());

        //Action
        this.addActionListener(e -> {
            /**
             * On supprime le dossier de recherche
             * On supprime la variable de recherche
             * On raffraichit la vue
             */
                VariablesGlobals.setFolderSearch(null);
                VariablesGlobals.setSearchText(null);
                VariablesGlobals.getViewCurrent().setChildView();
            });
    }

    /**
     * Definit l'icon en fonction du style (dark ou light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/back.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/back.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
