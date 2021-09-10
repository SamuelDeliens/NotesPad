package com.company.samuel.views.viewBloc.middle;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * ScrollPanel definit un panel intermediaire afin de gerer l'affichage correctement
 */
public class ScrollPanel extends JPanel{
    /**
     * Variable definissant la taille du JPanel
     */
    private int heightScrollPaneList;
    private int widthScrollPaneList;
    private Dimension scrollPaneSize;

    public ScrollPanel(Dimension middleContainerSize) {
        /**
         * Definition de taille avec la variable en parametre
         */
        this.widthScrollPaneList = (int)middleContainerSize.getWidth();
        this.heightScrollPaneList = (int)middleContainerSize.getHeight();
        this.scrollPaneSize = new Dimension(widthScrollPaneList, heightScrollPaneList);

        /**
         * Design
         */
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        VariablesGlobals.setDisplayAreaNotes(this);

        ChooseTypeAreaNotes chooseType = new ChooseTypeAreaNotes(scrollPaneSize);
        VariablesGlobals.setDisplayTypeAreaNotes(chooseType); //definit la variable globale pour raffraichir au besoin

        /**
         * Contents
         */
        this.add(chooseType);
    }

    /**
     * Permet de raffraichir la zone de notes
     */
    public void setChildDisplay() {
        this.removeAll();
        VariablesGlobals.setDisplayAreaNotes(this); //on definit la variable globale
        ChooseTypeAreaNotes chooseType = new ChooseTypeAreaNotes(scrollPaneSize);
        VariablesGlobals.setDisplayTypeAreaNotes(chooseType); //on definit la variable globale
        this.add(chooseType);
        this.revalidate();
    }
}
