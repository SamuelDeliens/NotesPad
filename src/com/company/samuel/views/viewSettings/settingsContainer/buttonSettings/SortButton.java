package com.company.samuel.views.viewSettings.settingsContainer.buttonSettings;

import com.company.samuel.models.Folder;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton definissant le type de tri de la liste des SubItems
 *  (nom ou type)
 */
public class SortButton extends JButton {
    /**
     * Recupere le dossier courant
     */
    private Folder folderS = VariablesGlobals.getFolderCurrent();

    public SortButton() {
        /**
         * Design du Bouton
         */
        this.setLayout(null);
        this.setText(folderS.getTypeSort());
        this.setPreferredSize(new Dimension(100,30));

        //Action
        this.addActionListener(e -> {
            /**
             * Si on est en tri name, on passe en tri type et inversement
             *  -on change le type de tri du dossier courant
             *  -on raffraichit le dossier courant
             *  -on raffraichit l'affichage du bouton
             *  -on raffraichit l'affichage de la liste
             */
            if (folderS.getTypeSort().equals("name")) {
                folderS.setTypeSort("type");
                VariablesGlobals.setFolderCurrent(folderS);

                this.setText(folderS.getTypeSort());
                VariablesGlobals.getDisplayAreaNotes().setChildDisplay();
            }
            else if(folderS.getTypeSort().equals("type")) {
                folderS.setTypeSort("name");
                VariablesGlobals.setFolderCurrent(folderS);

                this.setText(folderS.getTypeSort());
                VariablesGlobals.getDisplayAreaNotes().setChildDisplay();
            }
        });
    }
}
