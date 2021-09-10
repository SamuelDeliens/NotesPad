package com.company.samuel.views.mainView;

import com.company.samuel.controllers.Views;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Vue Principale --> Affiche la liste des blocs notes trouvés dans le dossier data
 */
public class MainView extends Views {
    /**
     * JFrame et Container de la vue
     * Dimension de la fenetre (taille totale de l'ecran)
     */
    private JFrame mainView;
    private Container mainContainer;

    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public MainView() {
        VariablesGlobals.setViewCurrent(this); //Definit la vue en vue courrante --> Variable Globale

        /**
         * Definit le style de la fenetre (style Apple)
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.textantialiasing", "true");
        System.setProperty("apple.awt.brushMetalLook", "true");

        mainView = new JFrame();

        /**
         * Design
         */
        mainView.setSize(screenSize);
        mainView.setTitle("Memo");

        /**
         * Contents
         */
        mainContainer = mainView.getContentPane();
        mainContainer.setVisible(true);
        mainContainer.setLayout(new BoxLayout(mainContainer,BoxLayout.Y_AXIS));
        mainContainer.setBackground(VariablesGlobals.getColorBackground1());

        mainContainer.add(new TopContainer(screenSize));
        mainContainer.add(new MiddleContainer(screenSize));


        mainView.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainView.pack();
    }

    /**
     * Methodes de Views
     */
    @Override
    public void display() {
        mainView.setVisible(true);
    }

    @Override
    public void close() {
        mainView.dispose();
    }

    /**
     * redefinit le contenu de la fenetre (+ la couleur de fond si changement)
     */
    @Override
    public void setChildView() {
        mainContainer.removeAll();
        mainContainer.setBackground(VariablesGlobals.getColorBackground1());
        mainContainer.add(new TopContainer(screenSize));
        mainContainer.add(new MiddleContainer(screenSize));
        mainContainer.revalidate();
    }
}
