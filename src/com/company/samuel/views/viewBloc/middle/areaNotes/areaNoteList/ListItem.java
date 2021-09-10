package com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteList;

import com.company.samuel.models.*;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *  Panel affichant la list de SubItem sous forme de list
 */
public class ListItem extends JPanel {
    /**
     * Variables definissant la taille du panel
     */
    private int heightListItem;
    private int widthListItem;
    private Dimension listItemSize;
    private Dimension listItemSizeBorder;

    public ListItem(List<SubItem> contents, Dimension areaNotesSize) {
        /**
         * Definition de la taille du Panel
         */
        this.widthListItem = (int)(90*areaNotesSize.getWidth()/100);
        this.heightListItem = (int)(contents.size() * (VariablesGlobals.getNoteSize()+10)+30);
        this.listItemSize = new Dimension(widthListItem,heightListItem);
        this.listItemSizeBorder = new Dimension(widthListItem,heightListItem-20);

        /**
         * Design
         */
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setPreferredSize(listItemSize);
        this.setMaximumSize(listItemSize);

        /**
         * Panel Intermediaire afin d'obtenir des bords arrondits
         */
        JPanel borderList = new BorderPanel(50, VariablesGlobals.getColorBackground2());
        borderList.setPreferredSize(listItemSize);
        borderList.setMaximumSize(listItemSize);
        borderList.setMinimumSize(listItemSize);
        borderList.setOpaque(false);

        /**
         * Panel intermediaire afin de gerer correctement l'affichage du panel
         */
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setOpaque(false);
        listPanel.setPreferredSize(listItemSizeBorder);
        listPanel.setMaximumSize(listItemSizeBorder);

        /**
         * Contents
         * On ajoute chacuns des elements dans le Panel (listPanel)
         * On ajoute une separation apres l'ajout d'un premier element
         */
        for (SubItem item : contents) {
            listPanel.add(new ItemX(item, listItemSizeBorder));
            if (item != contents.get(contents.size()-1)) {
                listPanel.add(new Separation());
            }
        }

        borderList.add(listPanel);
        this.add(borderList);
    }
}
