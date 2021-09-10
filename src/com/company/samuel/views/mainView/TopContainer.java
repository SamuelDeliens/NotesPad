package com.company.samuel.views.mainView;

import com.company.samuel.views.mainView.top.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel Supérieur de la vue Principale --> affiche les boutons (ajouts de blocNotes et Settings)
 */
public class TopContainer extends JPanel {
    private int heightBottomContainer;
    private int widthBottomContainer;
    private Dimension bottomContainerSize;

    public TopContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        this.widthBottomContainer = (int)screenSize.getWidth();
        this.heightBottomContainer = (int)(5*screenSize.getHeight()/100);
        this.bottomContainerSize = new Dimension(widthBottomContainer, heightBottomContainer);

        this.setPreferredSize(new Dimension(widthBottomContainer, heightBottomContainer));
        this.setMaximumSize(new Dimension(widthBottomContainer, heightBottomContainer));

        /**
         * Met un layout en ligne (BoxLayout pour pouvoir ajouter une glue au milieu)
         */
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setOpaque(false); // met en transparent

        /**
         * Contents (ajoute des box sur les cotés exterieurs pour centrer un peu les elements)
         */
        this.add(Box.createRigidArea(new Dimension(10,10)));
        this.add(new NewBlocNotes());   //Bouton creation de blocNotes
        this.add(Box.createHorizontalGlue());
        this.add(new SettingsButton()); //Bouton des paramettres d'affichage
        this.add(Box.createRigidArea(new Dimension(10,10)));

    }
}
