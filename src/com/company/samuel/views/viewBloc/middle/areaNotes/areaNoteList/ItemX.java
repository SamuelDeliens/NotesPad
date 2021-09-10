package com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteList;

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

    public ItemX(SubItem itemX, Dimension listItemSize) {
        /**
         * Difinition de la taille du Panel
         */
        this.widthItemX = (int)(95*listItemSize.getWidth()/100);
        this.heightItemX = VariablesGlobals.getNoteSize();
        this.itemXSize = new Dimension(widthItemX,heightItemX);

        /**
         * Design
         */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setOpaque(false);


        /**
         * Contents
         */

        /**
         * Panel intermediaire afin de gerer correctement l'affichage
         */
        JPanel interPane = new JPanel();
        interPane.setLayout(new BoxLayout(interPane, BoxLayout.X_AXIS));
        interPane.setOpaque(false);
        interPane.setPreferredSize(itemXSize);
        interPane.setMinimumSize(itemXSize);
        interPane.setMaximumSize(itemXSize);


        /**
         * Contents:
         *  Icon d'ouverture du SubItem
         *  Le nom du SubItem
         *  L'épingle du SubItem
         *  Le bouton afin de jeter le SubItem
         *  La date du SubItem
         */
        interPane.add(Box.createRigidArea(new Dimension(30,0)));

        interPane.add(new IconButton(itemX,30,30, 20));
        interPane.add(new NameItemX(itemX));

        interPane.add(Box.createHorizontalGlue());

        interPane.add(new PinItemX(itemX,25,25,15, "name"));
        interPane.add(Box.createRigidArea(new Dimension(10,10)));
        interPane.add(new ThrowButton(itemX, 20,20,10));
        interPane.add(Box.createRigidArea(new Dimension(20,10)));

        interPane.add(new DateItemX(itemX, 14));
        this.add(interPane);
    }
}
