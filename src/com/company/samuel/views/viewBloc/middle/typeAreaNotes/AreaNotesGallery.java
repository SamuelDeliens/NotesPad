package com.company.samuel.views.viewBloc.middle.typeAreaNotes;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.middle.areaNotes.TitleArea;
import com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteGallery.GalleryItem;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * JPanel affichant le contenu du Dossier courant sous forms de list
 */
public class AreaNotesGallery extends JPanel{
    /**
     * Definit le contenu et la taille du Panel
     */
    private ArrayList<SubItem> contents = new ArrayList<>();
    private int heightAreaNotes;
    private int widthAreaNotes;
    private Dimension areaNotesSize;
    private Folder folderA;

    /**
     * Prend en compte le nombre d'element par colonne ainsi que le nombre de ligne pour definir la taille du Panel
     */
    private int numberColumn = VariablesGlobals.getNumberLineGallery();
    private int numberLine;

    public AreaNotesGallery(Boolean type, Dimension scrollPaneSize) {
        /**
         * On regarde si le dossier de recherche existe ou non pour savoir si l'on affiche le dossier courant ou le dossier de recherche
         */
        if (VariablesGlobals.getFolderSearch() == null) {
            folderA = VariablesGlobals.getFolderCurrent();
        } else {
            folderA = VariablesGlobals.getFolderSearch();
        }

        /**
         * On definit le contenu a afficher
         *  --> On prend les SubItems dont l'epingles correspond à la variable entré en parametre (true ou false)
         */
        for (SubItem item : folderA.getContents()) {
            if (item.getPin().equals(type)) {
                //pinned or not
                if (item.getClass().getSimpleName().equals("Folder")) contents.add(item);
                else if (item.getClass().getSimpleName().equals("File")) contents.add(item);
            }
        }

        /**
         * On calcul le nombre de ligne qu'il est necessaire pour le GridLayout
         */
        this.numberLine = (int)Math.ceil((double)contents.size()/this.numberColumn);

        /**
         * Definit la taille du JPanel en utilisant la variable passée en parametre
         */
        this.widthAreaNotes = (int)(scrollPaneSize.getWidth() - (0.023 * scrollPaneSize.getWidth()));
        this.heightAreaNotes = (int)(this.numberLine * ((VariablesGlobals.getNoteSize()*4)+10)+70);
        this.areaNotesSize = new Dimension(widthAreaNotes,heightAreaNotes);

        /**
         * Design / Contents
         * On affiche seulemement si la liste contient un element
         */
        if (contents.size() != 0) {
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setBackground(VariablesGlobals.getColorBackground1());
            this.setPreferredSize(areaNotesSize);
            this.setMinimumSize(areaNotesSize);
            this.setMaximumSize(areaNotesSize);

            this.add(new TitleArea(type, areaNotesSize));
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(new GalleryItem(contents, areaNotesSize));
            //this.add(new GalleryItem2(contents, areaNotesSize));
        }
        else {
            this.setVisible(false);
            this.setLayout(null);
        }
    }
}
