package com.company.samuel.views.mainView.middle.areaNotes.areaNoteList;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.mainView.middle.areaNotes.itemX.*;

import javax.swing.*;
import java.awt.*;

/**
 * Definit le Panel d'un BlocNotes dans la liste
 */
public class ItemX extends JPanel {
    private int widthItemX;
    private int heightItemX;
    private Dimension itemXSize;

    public ItemX(BlocNotes itemX, Dimension listItemSize) {
        /**
         * Taille d'un item
         */
        this.widthItemX = (int)(95*listItemSize.getWidth()/100);
        this.heightItemX = VariablesGlobals.getNoteSize();
        this.itemXSize = new Dimension(widthItemX,heightItemX);

        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setOpaque(false);

        /**
         * Utiise un Panel intermediaire pour gerer les glue
         */
        JPanel test = new JPanel();
        test.setLayout(new BoxLayout(test, BoxLayout.X_AXIS));
        test.setOpaque(false);
        test.setPreferredSize(itemXSize);
        test.setMinimumSize(itemXSize);
        test.setMaximumSize(itemXSize);

        /**
         * Contents:
         *  -un bouton avec une icon d'un blocNotes pour ouvrir le blocNotes
         *  -Le nom du BlocNotes
         *  -un bouton avec icon pour supprimer le BlocNotes
         *  -la date du BlocNotes
         */
        test.add(Box.createRigidArea(new Dimension(30,0)));
        test.add(new IconButton(itemX,30,30, 20));
        test.add(new NameItemX(itemX));
        test.add(Box.createHorizontalGlue());
        test.add(new ThrowButton(itemX, 20,20,10));
        test.add(new DateItemX(itemX, 14));
        this.add(test);
    }
}
