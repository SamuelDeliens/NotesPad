package com.company.samuel.views.viewAdder.adderContainer;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton acceptation d'ajout du SubItem
 */
public class AcceptButton extends JPanel {
    private int widthButton;
    private int heightButton;
    private Dimension buttonSize;

    public AcceptButton(Dimension settingsContainerSize, SubItem newItem, BlocNotes blocNotes) {
        /**
         * Taille du Panel
         */
        this.widthButton = (int)(2*settingsContainerSize.getWidth()/2);
        this.heightButton = (int)settingsContainerSize.getHeight()/8;
        this.buttonSize = new Dimension(widthButton, heightButton);

        /**
         * Style du Panel
         */
        this.setLayout(new FlowLayout(FlowLayout.RIGHT));
        this.setOpaque(false);
        this.setPreferredSize(buttonSize);
        this.setMaximumSize(buttonSize);
        this.setMinimumSize(buttonSize);

        JButton accept = new JButton();
        accept.setText("Valider");

        //Action
        accept.addActionListener(e -> {
            /**
             * Ajout d'un nouveau SubItem
             *  --> si newItem est null, on ajoute un nouveau BlocNotes (que l'on sauvegarde pour créer un nouveau fichier)
             *  --> si newItem est non null, on ajoute un nouveau SubItem au dossier courant
             */
            if (!newItem.getTypeSubItem().equals("BlocNotes")) {
                VariablesGlobals.getFolderCurrent().add(newItem);
            } else {
                blocNotes.setName(newItem.getName());
                blocNotes.save(blocNotes);
            }

            Views viewAdder =  Main.getView(Main.listView.size()-1); //recupere la vue courrante
            Main.removeView(Main.listView.size()-1); //supprime la vue de la liste
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size()-1)); //recupere l'ancienne vu

            /**
             * Si on ajoute un nouveau SubItem on refait le tri du dossier courant, sinon on refait la liste de BlocNotes
             */
            if (!newItem.getTypeSubItem().equals("BlocNotes")) {
                VariablesGlobals.getFolderCurrent().sortContents();
            } else {
                Main.setListBloc();
            }
            VariablesGlobals.getViewCurrent().setChildView(); //On raffraichit la vue courrante
            viewAdder.close(); //ferme l'ancienne vue
        });

        /**
         * Contents
         */
        this.add(accept);
    }
}
