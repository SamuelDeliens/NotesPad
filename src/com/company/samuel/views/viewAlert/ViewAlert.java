package com.company.samuel.views.viewAlert;

import com.company.samuel.controllers.Views;
import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;

/**
 * Vue Alert --> Affiche si l'on veux reelement supprimer un element
 */
public class ViewAlert extends Views {
    private JDialog viewAlert;

    /**
     * Taille et position du JDialog
     */
    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int posX, posY;
    private int heightBorder;
    private int widthBorder;
    private Dimension borderSize;
    private BorderPanel border;

    public ViewAlert(SubItem elementSup) {
        /**
         * Definit la vue en vue courante
         */
        VariablesGlobals.setViewCurrent(this);

        /**
         * Taille et Position
         */
        posX = (int) (5 * screenSize.getWidth() / 16);
        posY = (int) screenSize.getHeight() / 10;
        widthBorder = (int) (6 * screenSize.getWidth() / 16);
        heightBorder = (int) (6 * screenSize.getHeight() / 20);
        borderSize = new Dimension(widthBorder, heightBorder);

        /**
         * Definit le style de la fenetre (style Apple)
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.textantialiasing", "true");
        System.setProperty("apple.awt.brushMetalLook", "true");

        /**
         * utilise un JDialog pour afficher la vue au dessus de l'autre
         */
        viewAlert = new JDialog();
        viewAlert.setUndecorated(true);
        viewAlert.setSize(screenSize);
        viewAlert.setPreferredSize(screenSize);
        viewAlert.setBackground(new Color(0xCB000000, true));
        viewAlert.setLayout(new FlowLayout(FlowLayout.CENTER));
        viewAlert.setModal(true);

        /**
         * On utilise un BorderPanel pour arrondir les coins du Panel
         */
        border = new BorderPanel(50, VariablesGlobals.getColorBackgroundDialog());
        border.setPreferredSize(borderSize);
        border.setMaximumSize(borderSize);
        border.setMinimumSize(borderSize);
        border.setOpaque(false);
        border.setVisible(true);

        /**
         * Ajoute le Container principal
         */
        border.add(new AlertContainer(borderSize, elementSup));

        /**
         * panel intermediaire pour gerer l'affichage correctement
         */
        JPanel inter = new JPanel();
        inter.setOpaque(false);
        inter.setLayout(new BoxLayout(inter, BoxLayout.Y_AXIS));
        inter.add(Box.createRigidArea(new Dimension(0, posY)));
        inter.add(border);

        viewAlert.add(inter);
        viewAlert.pack();
    }


    @Override
    public void display() {
        viewAlert.setVisible(true);
        viewAlert.pack();
    }

    @Override
    public void close() {
        viewAlert.dispose();
    }

    @Override
    public void setChildView() {
    }
}
