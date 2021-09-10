package com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteGallery;

import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel intemediaire afin d'arrondir les bords
 */
public class BorderItemX extends JPanel {
    /**
     * Variables definissant la taille du JPanel
     */
    private int widthBorderItemX;
    private int heightBorderItemX;
    private Dimension borderItemXSize;

    public BorderItemX(SubItem item, Dimension galleryItemSize) {
        /**
         * Definit la taille du JPanel
         */
        this.widthBorderItemX = (int)(15*galleryItemSize.getWidth()/100)+10;
        this.heightBorderItemX = (VariablesGlobals.getNoteSize()*4)+10;
        this.borderItemXSize = new Dimension(widthBorderItemX,heightBorderItemX);

        /**
         * Design
         */
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setOpaque(false);

        /**
         *  Border panel afin d'arrondir les bords
         */
        JPanel borderItem = new BorderPanel(25, VariablesGlobals.getColorBackground2());
        borderItem.setPreferredSize(borderItemXSize);
        borderItem.setMaximumSize(borderItemXSize);
        borderItem.setMinimumSize(borderItemXSize);
        borderItem.setOpaque(false);
        borderItem.add(new ItemX(item, borderItemXSize)); //JPanel pour afficher un item

        /**
         * Contents
         */
        this.add(borderItem);
    }
}
