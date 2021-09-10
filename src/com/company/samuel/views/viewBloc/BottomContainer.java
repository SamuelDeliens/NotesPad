package com.company.samuel.views.viewBloc;

import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.bottom.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Inferieur de la vue BlocNotes
 */
public class BottomContainer extends JPanel {

    /**
     * Variable definissant la taille du Panel
     */
    private int heightBottomContainer;
    private int widthBottomContainer;
    private Dimension bottomContainerSize;

    public BottomContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en fonction de la taille d'écran passé en parametre
         */
        this.widthBottomContainer = (int)screenSize.getWidth();
        this.heightBottomContainer = (int)(5*screenSize.getHeight()/100);
        this.bottomContainerSize = new Dimension(widthBottomContainer, heightBottomContainer);

        /**
         * Design
         */
        this.setPreferredSize(new Dimension(widthBottomContainer, heightBottomContainer));
        this.setMaximumSize(new Dimension(widthBottomContainer, heightBottomContainer));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false);

        /**
         * On verifie que l'on ne se situe pas dans la poubelle afin d'ajouter:
         *  -un bouton pour aller dans la poubelle
         *  -un bouton pour ajouter un nouveau Dossier au Dossier courant
         *  -un bouton pour ajouter un nouveau Fichier au Dossier courant
         */
        if (!VariablesGlobals.getFolderCurrent().getName().equals("Trash")) {
            this.add(Box.createRigidArea(new Dimension(10,35)));
            this.add(new TrashButton());
            this.add(Box.createHorizontalGlue());
            this.add(new NewFolderButton());
            this.add(Box.createRigidArea(new Dimension(15,35)));
            this.add(new NewFileButton());
            this.add(Box.createRigidArea(new Dimension(10,35)));
        }
    }
}
