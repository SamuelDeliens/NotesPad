package com.company.samuel.views.viewSettings;

import com.company.samuel.controllers.Views;
import com.company.samuel.models.Folder;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;

/**
 * Vue Settings --> Affiche la possibilité de changer l'affichage général de l'application ou de certain dossier
 *  (sa couleur de fond ou l'affichage en list ou gallery d'un dossier
 */
public class ViewSettings extends Views {
    private JDialog viewSettings;

    /**
     * Variables definissant taille, position
     */
    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
    private int posX, posY;
    private int heightBorder;
    private int widthBorder;
    private Dimension borderSize;
    private JPanel inter;
    private BorderPanel border;

    public ViewSettings(Folder currentFolder) {
        /**
         * Definit la vue en vue courrante
         */
        VariablesGlobals.setViewCurrent(this);

        /**
         * Taille et Position
         */
        posX = (int)(5*screenSize.getWidth()/16);
        posY = (int)screenSize.getHeight()/8;
        widthBorder = (int)(6*screenSize.getWidth()/16);
        heightBorder = (int)(2*screenSize.getHeight()/3);
        borderSize = new Dimension(widthBorder,heightBorder);

        /**
         * Definit le style de la fenetre (style Apple)
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.textantialiasing", "true");
        System.setProperty("apple.awt.brushMetalLook", "true");

        /**
         * utilise un JDialog pour afficher la vue au dessus de l'autre
         */
        viewSettings = new JDialog();
        viewSettings.setUndecorated(true);
        viewSettings.setSize(screenSize);
        viewSettings.setPreferredSize(screenSize);
        viewSettings.setBackground(new Color(0xCD000000, true));
        viewSettings.setLayout(new FlowLayout(FlowLayout.CENTER));
        //force la position de la fenetre au dessus
        viewSettings.setModal(true);

        /**
         * On utilise un BorderPanel pour arrondir les coins du Panel
         */
        border = new BorderPanel( 50, VariablesGlobals.getColorBackgroundDialog());
        border.setPreferredSize(borderSize);
        border.setMaximumSize(borderSize);
        border.setMinimumSize(borderSize);
        border.setOpaque(false);
        border.setVisible(true);

        /**
         * Ajoute le Container principal
         */
        border.add(new SettingsContainer(borderSize));

        /**
         * panel intermediaire pour gerer l'affichage correctement
         */
        inter = new JPanel();
        inter.setOpaque(false);
        inter.setLayout(new BoxLayout(inter, BoxLayout.Y_AXIS));
        inter.add(Box.createRigidArea(new Dimension(0,posY)));
        inter.add(border);  // Ajoute le panel arrondit

        viewSettings.add(inter); // Ajoute le panel intermediaire
        viewSettings.pack();
    }

    @Override
    public void display() {
        viewSettings.setVisible(true);
        viewSettings.pack();
    }

    @Override
    public void close() {
        viewSettings.dispose();
    }

    @Override
    public void setChildView() {
    }
}
