package com.company.samuel.views.mainView.middle;

import com.company.samuel.Main;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.mainView.middle.areaNotes.TitleArea;
import com.company.samuel.views.mainView.middle.areaNotes.areaNoteList.ListItem;

import javax.swing.*;
import java.awt.*;
import java.util.*;

/**
 * AreaNotesList definit le panel affichant la liste des BlocNotes
 */
public class AreaNotesList extends JPanel {

    /**
     * Utilise une listeLocal récupérant la liste de blocNotes du Main
     */
    private ArrayList<BlocNotes> contents;
    private int heightAreaNotes;
    private int widthAreaNotes;
    private Dimension areaNotesSize;

    public AreaNotesList(Dimension scrollPaneSize) {
        /**
         * redefinit la liste de BlocNote du Main
         * recupere la liste
         */
        Main.setListBloc();
        contents = Main.getListBloc();

        this.widthAreaNotes = (int)(scrollPaneSize.getWidth() - (0.023 * scrollPaneSize.getWidth()));
        this.heightAreaNotes = ((contents.size()) * (VariablesGlobals.getNoteSize()+10))+70;
        this.areaNotesSize = new Dimension(widthAreaNotes,heightAreaNotes);

        /**
         * On affiche le panel seulement si la liste contient un element
         */
        if (contents.size() != 0) {
            /**
             * Style du Panel
             */
            this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
            this.setBackground(VariablesGlobals.getColorBackground1());
            this.setPreferredSize(areaNotesSize);

            /**
             *  Ajoute le titre de la zone: "BlocNotes"
             *  Ajoute La liste
             */
            this.add(new TitleArea(areaNotesSize));
            this.add(Box.createRigidArea(new Dimension(0,5)));
            this.add(new ListItem(contents, areaNotesSize));

        }
        else {
            this.setVisible(false);
            this.setLayout(null);
        }
    }
}
