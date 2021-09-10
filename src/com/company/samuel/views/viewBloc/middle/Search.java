package com.company.samuel.views.viewBloc.middle;

import com.company.samuel.views.general.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel contenant le JtextArea pour les recherches
 */
public class Search extends JPanel {
    /**
     * Variable des tailles du JPanel
     */
    private int heightSearch;
    private int widthSearch;
    private Dimension searchSize;

    public Search(Dimension middleContainerSize) {
        /**
         * Definit la taille du JPanel
         */
        this.widthSearch = (int)middleContainerSize.getWidth();
        this.heightSearch = (int)(middleContainerSize.getHeight()/15);
        this.searchSize = new Dimension(widthSearch,heightSearch);

        /**
         * Design
         */
        this.setVisible(true);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setPreferredSize(searchSize);
        this.setMaximumSize(searchSize);

        /**
         * Definit un BorderPanel (package général) pour arrondir les coins
         */
        JPanel borderSearch = new BorderPanel(10,VariablesGlobals.getColorBackground2());
        borderSearch.setPreferredSize(new Dimension(widthSearch/2, heightSearch));
        borderSearch.setMinimumSize(new Dimension(widthSearch/2, heightSearch));
        borderSearch.setMaximumSize(new Dimension(widthSearch/2, heightSearch));
        borderSearch.setOpaque(false);

        SearchText searchText = new SearchText(searchSize);
        borderSearch.add(searchText);

        /**
         * Contents
         */
        this.add(borderSearch);
    }
}
