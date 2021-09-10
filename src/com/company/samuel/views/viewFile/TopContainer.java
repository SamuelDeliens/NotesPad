package com.company.samuel.views.viewFile;

import com.company.samuel.views.viewFile.top.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Supérieur de la vue File
 */
public class TopContainer extends JPanel {
    private int heightTopContainer;
    private int widthTopContainer;
    private Dimension topContainerSize;

    public TopContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        this.widthTopContainer = (int)screenSize.getWidth();
        this.heightTopContainer = (int)(5*(screenSize.getHeight())/100);
        this.topContainerSize = new Dimension(widthTopContainer,heightTopContainer);

        /**
         * Design du Container
         */
        this.setPreferredSize(new Dimension(widthTopContainer, heightTopContainer));
        this.setMinimumSize(new Dimension(widthTopContainer, heightTopContainer));
        this.setMaximumSize(new Dimension(widthTopContainer, heightTopContainer));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false);

        /**
         * Contents (ajoute des box sur les cotés exterieurs pour centrer un peu les elements)
         */
        this.add(Box.createRigidArea(new Dimension(10,40)));
        this.add(new BackButton());
        this.add(Box.createHorizontalGlue());
        this.add(new SaveButton());
        this.add(Box.createRigidArea(new Dimension(10,40)));
    }
}
