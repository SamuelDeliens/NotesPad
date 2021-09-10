package com.company.samuel.views.viewAdder;

import com.company.samuel.controllers.Views;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;

/**
 * Vue Ajout --> Affiche la possibilité d'ajouter un SubItem
 */
public class ViewAdder extends Views {
    private JDialog viewAdder;

    /**
     * Variables definissant taille, position
     */
    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize(); //taille ecran
    private int posX, posY;
    private int heightBorder;
    private int widthBorder;
    private Dimension borderSize;
    private BorderPanel border;
    private String _type;

    public ViewAdder(String type) {
        /**
         * Definit la vue en vue courrante
         */
        VariablesGlobals.setViewCurrent(this);

        /**
         * Taille et Position
         */
        posX = (int) (5 * screenSize.getWidth() / 16);
        posY = (int) screenSize.getHeight() / 8;
        widthBorder = (int) (6 * screenSize.getWidth() / 16);
        heightBorder = (int) (6 * screenSize.getHeight() / 16);
        borderSize = new Dimension(widthBorder, heightBorder);
        _type = type;

        /**
         * Definit le style de la fenetre (style Apple)
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.textantialiasing", "true");
        System.setProperty("apple.awt.brushMetalLook", "true");

        /**
         * utilise un JDialog pour afficher la vue au dessus de l'autre
         */
        viewAdder = new JDialog();
        viewAdder.setUndecorated(true);
        viewAdder.setSize(screenSize);
        viewAdder.setPreferredSize(screenSize);
        viewAdder.setBackground(new Color(0xCB000000, true));
        viewAdder.setLayout(new FlowLayout(FlowLayout.CENTER));
        //force la position de la fenetre au dessus
        viewAdder.setModal(true);

        /**
         * On utilise un BorderPanel pour arrondir les coins du Panel
         */
        border = new BorderPanel(50, VariablesGlobals.getColorBackgroundDialog());
        //border.setBounds(posX,posY,widthBorder,heightBorder);
        border.setPreferredSize(borderSize);
        border.setMaximumSize(borderSize);
        border.setMinimumSize(borderSize);
        border.setOpaque(false);
        border.setVisible(true);

        /**
         * Ajoute le Container principal
         */
        border.add(new AdderContainer(borderSize, type));

        /**
         * panel intermediaire pour gerer l'affichage correctement
         */
        JPanel inter = new JPanel();
        inter.setOpaque(false);
        inter.setLayout(new BoxLayout(inter, BoxLayout.Y_AXIS));
        inter.add(Box.createRigidArea(new Dimension(0, posY)));
        inter.add(border); // Ajoute le panel arrondit

        viewAdder.add(inter); // Ajoute le panel intermediaire
        viewAdder.pack();
    }

    @Override
    public void display() {
        viewAdder.setVisible(true);
        viewAdder.pack();
    }

    @Override
    public void close() {
        viewAdder.dispose();
    }

    @Override
    public void setChildView() {
        border.removeAll();
        border.add(new AdderContainer(borderSize, _type));
        border.revalidate();
    }
}
