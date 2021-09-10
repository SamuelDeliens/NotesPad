package com.company.samuel.views.viewBloc.middle.areaNotes;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel afficher le titre des deux listes ("Epinglé", "non Epinglé")
 */
public class TitleArea extends JPanel {
    /**
     * Variables definissant taille du panel
     */
    private int widthTitleArea;
    private int heightTitleArea;
    private Dimension titleAreaSize;

    public TitleArea(Boolean type, Dimension areaNotesSize) {
        /**
         * Definit la taille du Panel en utilisant la variable entrée en parametre
         */
        this.widthTitleArea = (int)areaNotesSize.getWidth();
        this.heightTitleArea = (int)areaNotesSize.getHeight();
        this.titleAreaSize = new Dimension(widthTitleArea,heightTitleArea);

        /**
         * Design
         */
        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setPreferredSize(new Dimension((int)areaNotesSize.getWidth(), 30));
        this.setMinimumSize(new Dimension((int)areaNotesSize.getWidth(), 30));
        this.setMaximumSize(new Dimension((int)areaNotesSize.getWidth(), 30));

        /**
         * Label contenant le titre de la zone
         */
        JLabel title = new JLabel();
        VariablesGlobals.setFont1(22);
        title.setFont(VariablesGlobals.getFont1());
        title.setForeground(VariablesGlobals.getColorFont2());

        /**
         * On regarde le type entré en parametre, (epingle ou non epinglé)
         */
        if (type) {
            title.setText("Épinglées");
        }
        else {
            title.setText("Notes");
        }

        /**
         * Contents
         */
        this.add(Box.createRigidArea(new Dimension((int)areaNotesSize.getWidth()/5,0)));
        this.add(title);
    }
}
