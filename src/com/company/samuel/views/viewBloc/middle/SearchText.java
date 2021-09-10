package com.company.samuel.views.viewBloc.middle;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JTextField permettant de deffinir l'objet de recherche
 */
public class SearchText extends JTextField implements KeyListener {
    /**
     * Variables definition de taille
     */
    private int widthSearch;
    private int heightSearch;
    private Dimension searchTextSize;

    public SearchText(Dimension searchSize) {
        /**
         * Definition de taille
         */
        this.widthSearch = (int)searchSize.getWidth()/3;
        this.heightSearch = (int)(3*searchSize.getHeight()/6);
        this.searchTextSize = new Dimension(widthSearch,heightSearch);

        /**
         * Si le dossier de recherche n'est pas nul, on recupere la variable de recherche
         */
        if (VariablesGlobals.getFolderSearch() != null) {
            this.setText(VariablesGlobals.getSearchText());
        }

        /**
         * Design
         */
        this.setOpaque(false);
        this.setPreferredSize(searchTextSize);
        this.setMaximumSize(searchTextSize);
        this.setMinimumSize(searchTextSize);
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(14);
        this.setFont(VariablesGlobals.getFont1());
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, VariablesGlobals.getColorFont1()));

        //Action
        this.addKeyListener(this);

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * Lors de l'appuie sur entrer:
     *  -On recupere le dossier courant
     *  -on definit un nouveau dossier de recherche
     *  -on definit le contenu du dossier avec le contenu du dossier courant dont le nom contient le texte de recherche
     *  -on definit les variables globales de recherche
     *  -on raffraichit la vue
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            Folder folderCurrent = VariablesGlobals.getFolderCurrent(); //recup dossier courant
            Folder folderSearch = new Folder(folderCurrent.getName(), folderCurrent.getLocation()); //nouveau dossier recherche

            folderSearch.clear(); //vide dossier recherche par securité

            for (SubItem item : folderCurrent.getContents()) {
                if (item.getName().contains(this.getText())) {
                    folderSearch.add(item); //contenu dont le nom comporte le texte de recherche
                }
            }
            VariablesGlobals.setSearchText(this.getText()); //definit texte de recherche globale
            VariablesGlobals.setFolderSearch(folderSearch); //definit le dossier de recherche globales
            VariablesGlobals.getViewCurrent().setChildView(); //raffraichit la vue
        }
    }
}
