package com.company.samuel.views.viewBloc;

import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.top.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Supérieur de la vue BlocNotes
 */
public class TopContainer extends JPanel {
    /**
     * Variable definissant la taille du Panel
     */
    private int heightTopContainer;
    private int widthTopContainer;
    private Dimension topContainerSize;

    public TopContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en fonction de la taille d'écran passé en parametre
         */
        this.widthTopContainer = (int)screenSize.getWidth();
        this.heightTopContainer = (int)(5*(screenSize.getHeight())/100);
        this.topContainerSize = new Dimension(widthTopContainer,heightTopContainer);

        /**
         * Design
         */
        this.setPreferredSize(new Dimension(widthTopContainer, heightTopContainer));
        this.setMaximumSize(new Dimension(widthTopContainer, heightTopContainer));
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false);

        /**
         * Contents:
         *  -Si on effectue une recherche (dossier recherche non null) on ajoute un bouton stopSearch
         *  -Sinon on ajoute un bouton de retour au dossier maitre et un bouton de sauvegarde
         *  -On ajoute une glue au milieu
         *  -On ajoute un bouton Settings
         */
        this.add(Box.createRigidArea(new Dimension(10,40)));
        if (VariablesGlobals.getFolderSearch() != null) {
            this.add(new StopSearch(), BorderLayout.WEST);
        } else {
            this.add(new BackButton(), BorderLayout.WEST);
            this.add(Box.createRigidArea(new Dimension(10,40)));
            this.add(new SaveButton(), BorderLayout.WEST);
        }
        this.add(Box.createHorizontalGlue());
        this.add(new SettingsButton(), BorderLayout.EAST);
        this.add(Box.createRigidArea(new Dimension(10,40)));
    }
}
