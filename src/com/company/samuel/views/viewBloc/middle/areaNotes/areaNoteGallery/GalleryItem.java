package com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteGallery;

import com.company.samuel.models.*;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 *  Panel affichant la list de SubItem sous forme de gallery
 */
public class GalleryItem extends JPanel {
    /**
     * Variables definissant la taille du panel
     * Variables definissant le nombre de ligne et colonne du panel
     */
    private int heightListItem;
    private int widthListItem;
    private Dimension listItemSize;
    private Dimension listItemSizeBorder;
    private int numberColumn = VariablesGlobals.getNumberLineGallery();
    private int numberLine;

    public GalleryItem(List<SubItem> contents, Dimension areaNotesSize) {
        /**
         * Definition du nombre de ligne du panel
         * Definition de la taille du Panel
         */
        this.numberLine = (int)Math.ceil((double)contents.size()/this.numberColumn);
        this.widthListItem = (int)(90*areaNotesSize.getWidth()/100);
        this.heightListItem = (int)(this.numberLine * ((VariablesGlobals.getNoteSize()*4)+10)+30);
        this.listItemSize = new Dimension(widthListItem,heightListItem);
        this.listItemSizeBorder = new Dimension(widthListItem-50,heightListItem-20);

        /**
         * Design
         */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setPreferredSize(listItemSize);
        this.setMaximumSize(listItemSize);

        /**
         * Panel Intermediaire afin d'obtenir des bords arrondits
         */
        JPanel borderItem = new BorderPanel(50, VariablesGlobals.getColorBackground2());
        borderItem.setPreferredSize(listItemSize);
        borderItem.setMaximumSize(listItemSize);
        borderItem.setMinimumSize(listItemSize);
        borderItem.setOpaque(false);

        /**
         * Panel intermediaire afin de gerer correctement l'affichage du panel
         */
        JPanel interPane = new JPanel();
        interPane.setPreferredSize(listItemSizeBorder);
        interPane.setMinimumSize(listItemSizeBorder);
        interPane.setMaximumSize(listItemSizeBorder);
        interPane.setOpaque(false);

        /**
         * Composant intermediaire afin d'afficher les elements sous forme de gallery
         */
        JPanel galleryPanel = new JPanel();
        galleryPanel.setLayout(new GridLayout(this.numberLine, this.numberColumn));
        galleryPanel.setOpaque(false);
        galleryPanel.setPreferredSize(listItemSizeBorder);
        galleryPanel.setMaximumSize(listItemSizeBorder);

        /**
         * Contents
         * On ajoute chacuns des elements dans le Panel (galleryPanel)
         * On ajoute des Box afin de completer les vides en fin de Panel (galleyPanel)
         */
        for (SubItem item : contents) {
            galleryPanel.add(new BorderItemX(item, listItemSizeBorder));
        }
        if (contents.size() < (this.numberColumn*this.numberLine)) {
            for (int i=0; i<(this.numberColumn*this.numberLine)-contents.size(); i++) {
                galleryPanel.add(Box.createHorizontalBox());
            }
        }

        interPane.add(galleryPanel);
        borderItem.add(interPane);
        this.add(borderItem);
    }
}
