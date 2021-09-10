package com.company.samuel.views.mainView.middle;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * ScrollPanel definit un panel intermediaire afin de gerer l'affichage correctement
 */
public class ScrollPanel extends JPanel{
    private int heightScrollPaneList;
    private int widthScrollPaneList;
    private Dimension scrollPaneSize;

    public ScrollPanel(Dimension middleContainerSize) {
        /**
         * Definition de taille
         */
        this.widthScrollPaneList = (int)middleContainerSize.getWidth();
        this.heightScrollPaneList = (int)middleContainerSize.getHeight();
        this.scrollPaneSize = new Dimension(widthScrollPaneList, heightScrollPaneList);

        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setLayout(new FlowLayout(FlowLayout.LEFT));

        /**
         * Definit le panel sous forme de list
         */
        this.add(new AreaNotesList(scrollPaneSize));
    }
}
