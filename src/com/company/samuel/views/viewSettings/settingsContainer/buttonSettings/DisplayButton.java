package com.company.samuel.views.viewSettings.settingsContainer.buttonSettings;

import com.company.samuel.models.Folder;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton definissant le type d'affichage de la liste des SubItems
 *  (list ou gallery)
 */
public class DisplayButton extends JButton {

    /**
     * Recupere le dossier courant
     */
    private Folder folderS = VariablesGlobals.getFolderCurrent();

    public DisplayButton() {
        /**
         * Design du Bouton
         */
        this.setLayout(null);
        this.setText(folderS.getDisplayType());
        this.setPreferredSize(new Dimension(100,30));

        //Action
        this.addActionListener(e -> {
            /**
             * Si on est en affichage gallery, on passe en affichage list et inversement
             *  -on change le display du dossier courant
             *  -on raffraichit le dossier courrant
             *  -on raffraichit l'affichage du bouton
             *  -on raffraichit l'affichage de la liste
             */
            if (folderS.getDisplayType().equals("list")) {
                folderS.setDisplayType("gallery");
                VariablesGlobals.setFolderCurrent(folderS);

                //Display change
                this.setText(folderS.getDisplayType());
                VariablesGlobals.getDisplayTypeAreaNotes().setChildGallery();
            }
            else if (folderS.getDisplayType().equals("gallery")) {
                folderS.setDisplayType("list");
                VariablesGlobals.setFolderCurrent(folderS);

                //Display change
                this.setText(folderS.getDisplayType());
                VariablesGlobals.getDisplayTypeAreaNotes().setChildList();
            }
        });
    }
}
