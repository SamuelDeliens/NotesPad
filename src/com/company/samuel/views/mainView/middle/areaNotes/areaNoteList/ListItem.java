package com.company.samuel.views.mainView.middle.areaNotes.areaNoteList;

import com.company.samuel.models.*;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * Definit le Panel pour la liste du BlocNotes --> definir un panel avec coins arrondits
 */
public class ListItem extends JPanel {
    private int heightListItem;
    private int widthListItem;
    private Dimension listItemSize;
    private Dimension listItemSizeBorder; //taille pour le panel

    public ListItem(List<BlocNotes> contents, Dimension areaNotesSize) {
        /**
         * Taille du panel
         */
        this.widthListItem = (int)(90*areaNotesSize.getWidth()/100);
        this.heightListItem = (int)(contents.size() * (VariablesGlobals.getNoteSize()+10)+30);
        this.listItemSize = new Dimension(widthListItem,heightListItem);
        this.listItemSizeBorder = new Dimension(widthListItem,heightListItem-20);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setPreferredSize(listItemSize);
        this.setMaximumSize(listItemSize);

        /**
         * Border Panel --> pour les coins arrondits
         */
        JPanel borderList = new BorderPanel(50, VariablesGlobals.getColorBackground2());
        borderList.setPreferredSize(listItemSize);
        borderList.setMaximumSize(listItemSize);
        borderList.setMinimumSize(listItemSize);
        borderList.setOpaque(false);

        /**
         * Composant intermediaire pour gerer la taille correctement
         */
        JPanel test = new JPanel();
        test.setLayout(new BoxLayout(test, BoxLayout.Y_AXIS));
        test.setOpaque(false);
        test.setPreferredSize(listItemSizeBorder);
        test.setMaximumSize(listItemSizeBorder);

        /**
         * Composant Principal
         *  On ajoute pour chaques elements de la list (contents)
         *      -une separation (Separation()) --> seulement apres avoir ajouter un premier element
         *      -un blocNotes (ItemX)
         */
        for (BlocNotes item : contents) {
            if (item.getId() != contents.get(0).getId()) {
                test.add(new Separation());
            }
            test.add(new ItemX(item, listItemSizeBorder));
        }

        borderList.add(test);
        this.add(borderList);
    }
}
