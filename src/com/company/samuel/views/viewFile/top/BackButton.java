package com.company.samuel.views.viewFile.top;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton revenir en arriere (dossier contenant le fichier)
 */
public class BackButton extends JButton{
    /**
     * Recupere le dossier courant
     */
    private Folder folderB = VariablesGlobals.getFolderCurrent();

    public BackButton() {

        setIcon(); //Definit l'icon

        /**
         * Style du bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setText(" "+folderB.getName()); //nom avec un espace devant pour decaller un peu de l'icone

        //Action
        this.addActionListener(e -> {

            /**
             * On ne sauvegarde pas lorsque l'on quitte:
             * pour changer: VariablesGlobals.getFileCurrent().setText(VariablesGlobals.getFileModified().getContent());
             */

            /**
             * Retire les variables tampons
             */
            VariablesGlobals.setFileModified(null);
            VariablesGlobals.setTextCurrent(null);

            /**
             * On recupere l'ancienne vue, on supprime la vue courrante afin d'annuler l'operation
             */
            Views viewFile = VariablesGlobals.getViewCurrent(); //recupere la vue
            VariablesGlobals.setViewCurrent(Main.getView(Main.listView.size() - 2)); //recupere l'ancienne vu --> met en vue courante

            /**
             * reaffiche l'ancienne vu
             */
            VariablesGlobals.setFolderCurrent(folderB);
            VariablesGlobals.getViewCurrent().setChildView();
            VariablesGlobals.getViewCurrent().display();

            Main.removeView(viewFile); //supprime la vue
            viewFile.close(); //ferme la vue
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/back.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/back.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(30,30, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
