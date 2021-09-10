package com.company.samuel.views.viewBloc.middle;

import com.company.samuel.models.Folder;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.middle.typeAreaNotes.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel affichant la list des SubItems du Dossier courant en fonction du type de display
 */
public class ChooseTypeAreaNotes extends JPanel {
    /**
     * Variables definissant la taille du JPanel et un Folder pour pouvoir y acceder dans les setChild
     */
    private int heightChooseType;
    private int widthChooseType;
    private Dimension chooseTypeSize;
    private Folder folder;

    public ChooseTypeAreaNotes(Dimension scrollPaneSize) {
        /**
         * Definition de taille avec la variable en parametre
         */
        this.widthChooseType = (int)scrollPaneSize.getWidth();
        this.heightChooseType = (int)scrollPaneSize.getHeight();
        this.chooseTypeSize = new Dimension(widthChooseType, heightChooseType);

        /**
         * On regarde si le dossier de recherche existe ou non pour savoir si l'on affiche le dossier courant ou le dossier de recherche
         */
        if (VariablesGlobals.getFolderSearch() == null) {
            folder = VariablesGlobals.getFolderCurrent();
        } else {
            folder = VariablesGlobals.getFolderSearch();
        }

        /**
         * Design
         */
        this.setLayout(new BoxLayout(this,BoxLayout.Y_AXIS));

        /**
         * Contents
         * On regarde le type de display du folder pour savoir le type de contenu (list ou gallery)
         * --> deux AreaNotes (1 pour les SubItem epinglés et 1 pour ceux non épinglés)
         */
        switch (folder.getDisplayType()) {
            case "list":
                this.add(new AreaNotesList(true, chooseTypeSize));
                this.add(new AreaNotesList(false, chooseTypeSize));
                break;
            case "gallery":
                this.add(new AreaNotesGallery(true, chooseTypeSize));
                this.add(new AreaNotesGallery(false, chooseTypeSize));
                break;
        }
    }

    /**
     * Permet d'afficher les elements du dossier sour forme de list
     */
    public void setChildList() {
        this.removeAll();
        this.add(new AreaNotesList(true, chooseTypeSize));
        this.add(new AreaNotesList(false, chooseTypeSize));
        this.revalidate();
    }

    /**
     * Permet d'afficher les elements du dossier sous forme de gallery
     */
    public void setChildGallery() {
        this.removeAll();
        this.add(new AreaNotesGallery(true, chooseTypeSize));
        this.add(new AreaNotesGallery(false, chooseTypeSize));
        this.revalidate();
    }
}
