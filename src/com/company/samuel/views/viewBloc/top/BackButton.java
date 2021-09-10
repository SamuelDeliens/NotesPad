package com.company.samuel.views.viewBloc.top;

import com.company.samuel.Main;
import com.company.samuel.controllers.Views;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.mainView.MainView;

import javax.swing.*;
import java.awt.*;

/**
 * Permet de revenir en arriere en affichant le dossier "maître"
 */
public class BackButton extends JButton{
    /**
     * Recupere le dossier courant
     */
    private Folder folderB = VariablesGlobals.getFolderCurrent();

    public BackButton() {
        /**
         * Design
         */
        setIcon();
        this.setMargin(new Insets(10,10,0,0));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());

        /**
         * On definit l'action du bouton en fonction du dossier courant
         *  -si celui ci a un autre dossier en "maître" alors on a une localisation non null
         *          -->On change simplement le dossier courant par le dossier localisation
         *  -si celui ci a un blocNotes en "maître" alors on a une localisation null
         *          -->On change de vue en passant a un mainView (vue de blocNotes)
         */
        if (folderB.getLocation() != null) {
            this.setText(" "+folderB.getLocation().getName());  //Definit le nom par le nom de la localisation
            //Action
            this.addActionListener(e -> {
                System.out.println("Be back soon Mr Negre");
                /**
                 * On change le dossier courant
                 * On raffraichit la vue
                 */
                VariablesGlobals.setFolderCurrent(folderB.getLocation());
                VariablesGlobals.getViewCurrent().setChildView();
            });
        } else {
            this.setText(" Notes"); //Definit le nom en "Notes"
            //Action
            this.addActionListener(e -> {
                System.out.println("Be back soon Mr Negre");

                /**
                 * On retire le blocNotes courant
                 * On crée un nouveau mainview
                 * On change de vue
                 */
                VariablesGlobals.setBlocNoteCurrent(null);
                Views viewBloc = VariablesGlobals.getViewCurrent(); //recupere la vue courante

                Views mainView = new MainView(); //crée nouvelle vue
                Main.removeView(0); //retire la vue courante de la liste
                Main.addView(mainView); //on ajoute la nouvelle vue
                mainView.display(); //on affiche la nouvelle vue

                viewBloc.close(); //on ferme la vue courante

                VariablesGlobals.setFolderCurrent(null); //on met dossier courant en null
                VariablesGlobals.getViewCurrent().setChildView(); //Raffraichit la vue
            });
        }
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
