package com.company.samuel.views.viewFile;

import com.company.samuel.controllers.Views;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Vue File --> Affiche l'édition d'un fichier
 */
public class ViewFile extends Views {
    private JFrame viewFile;
    private Container cf;

    private Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();

    public ViewFile(File file) {
        /**
         * Definit la vue en vue courante
         * Definit le fichier en fichier courant
         */
        VariablesGlobals.setViewCurrent(this);
        VariablesGlobals.setFileCurrent(file);

        /**
         * Definit le style de la fenetre (style Apple)
         */
        System.setProperty("apple.laf.useScreenMenuBar", "true");
        System.setProperty("apple.awt.textantialiasing", "true");
        System.setProperty("apple.awt.brushMetalLook", "true");

        /**
         * GARDE FICHIER COURRANTE MAIS ON MODIFIE UN FICHIER TAMPON
         *  -recupere le nom
         *  -recupere la localisation
         *  -recupere le contenu
         */
        File fileModified = new File(file.getName(), file.getLocation());
        Text textModified = new Text();
        textModified.setText(file.getContent().getText());
        fileModified.setText(textModified);
        VariablesGlobals.setFileModified(fileModified);

        /**
         * utilise une nouvelle fenetre
         */
        viewFile = new JFrame();

        /**
         * Design de la fenetre
         */
        viewFile.setSize(screenSize);
        viewFile.setTitle("Memo");

        /**
         * Contents --> Container principal
         */
        cf = viewFile.getContentPane();
        cf.setVisible(true);
        cf.setLayout(new BoxLayout(cf,BoxLayout.Y_AXIS));
        cf.setBackground(VariablesGlobals.getColorBackground1());

        cf.add(new TopContainer(screenSize));
        cf.add(new MiddleContainer(screenSize));

        viewFile.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        viewFile.pack();
    }


    @Override
    public void display() {
        viewFile.setVisible(true);
    }

    @Override
    public void close() {
        viewFile.dispose();
    }

    @Override
    public void setChildView() {
        cf.removeAll();
        cf.add(new TopContainer(screenSize));
        cf.add(new MiddleContainer(screenSize));
        cf.revalidate();
    }
}
