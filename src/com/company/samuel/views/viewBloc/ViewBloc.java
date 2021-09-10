package com.company.samuel.views.viewBloc;

import com.company.samuel.controllers.Views;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Vue BlocNotes --> Affiche le contenu d'un blocNotes
 */
public class ViewBloc extends Views {
    /**
     * Variables de nouvelle fenetre et Container principale
     * variable pour la taille de l'écran
     */
    private JFrame viewBloc;
    private Container cf;
    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public ViewBloc(Folder folder) {
        /**
         * Definit la vue en vue courante
         * Definit le dossier passé en parametre en dossier courant
         */
        VariablesGlobals.setViewCurrent(this);
        VariablesGlobals.setFolderCurrent(folder);

        /**
         * Definit le style de la fenetre (style Apple)
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.textantialiasing", "true");
        System.setProperty("apple.awt.brushMetalLook", "true");

        /**
         * Definis une nouvelle fenetre viewBloc
         */
        viewBloc = new JFrame();

        /**
         * Design
         */
        viewBloc.setSize(screenSize);
        viewBloc.setTitle("Memo");

        /**
         * Container principal
         */
        cf = viewBloc.getContentPane();
        cf.setVisible(true);
        cf.setLayout(new BoxLayout(cf,BoxLayout.Y_AXIS));
        cf.setBackground(VariablesGlobals.getColorBackground1());

        /**
         * Contents
         */
        cf.add(new TopContainer(screenSize));
        cf.add(new MiddleContainer(screenSize));
        cf.add(new BottomContainer(screenSize));


        viewBloc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewBloc.pack();
    }

    @Override
    public void display() {
        viewBloc.setVisible(true);
    }

    @Override
    public void close() {
        viewBloc.dispose();
    }

    @Override
    public void setChildView() {
        cf.removeAll();
        cf.setBackground(VariablesGlobals.getColorBackground1());
        cf.add(new TopContainer(screenSize));
        cf.add(new MiddleContainer(screenSize));
        cf.add(new BottomContainer(screenSize));
        cf.revalidate();
    }
}
