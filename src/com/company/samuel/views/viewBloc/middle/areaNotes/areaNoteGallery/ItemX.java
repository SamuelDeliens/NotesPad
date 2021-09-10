package com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteGallery;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.middle.areaNotes.itemX.*;

import javax.swing.*;
import java.awt.*;

/**
 *Panel affichant une seul SubItem du Dossier Courant
 */
public class ItemX extends JPanel {
    /**
     * Variables definissant la taille du panel
     */
    private int widthItemX;
    private int heightItemX;
    private Dimension itemXSize;

    public ItemX(SubItem itemX, Dimension borderItemXSize) {
        /**
         * Difinition de la taille du Panel
         */
        this.widthItemX = (int)borderItemXSize.getWidth()-25;
        this.heightItemX = (int)(VariablesGlobals.getNoteSize()*4)-20;
        this.itemXSize = new Dimension(widthItemX,heightItemX);

        /**
         * Design
         */
        this.setOpaque(false);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setPreferredSize(itemXSize);
        this.setMinimumSize(itemXSize);
        this.setMaximumSize(itemXSize);

        /**
         * Contents
         */

        /**
         * Panel definissant le haut de l'itemX (icon ouverture et nom)
         */
        JPanel topItemX = new JPanel();
        topItemX.setLayout(new FlowLayout(FlowLayout.CENTER));
        topItemX.setOpaque(false);

        topItemX.add(new IconButton(itemX, 25,25,10));
        topItemX.add(new NameItemX(itemX));

        /**
         * Ajout du nom et Box
         */
        this.add(topItemX);
        this.add(new DateItemX(itemX, 12));
        this.add(Box.createRigidArea(new Dimension(10,100)));

        /**
         * Panel definissant le bas de l'itemX (icon pour jeter et icon d'epingle)
         */
        JPanel bottomItemX = new JPanel(new BorderLayout());
        bottomItemX.setOpaque(false);
        bottomItemX.add(new ThrowButton(itemX, 20,20,10), BorderLayout.WEST);
        bottomItemX.add(new PinItemX(itemX,20,20,10, "name"), BorderLayout.EAST);
        this.add(bottomItemX);

    }
}
