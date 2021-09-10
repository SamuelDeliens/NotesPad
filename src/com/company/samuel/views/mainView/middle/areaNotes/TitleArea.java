package com.company.samuel.views.mainView.middle.areaNotes;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel Contenant le Titre de la liste
 */
public class TitleArea extends JPanel {
    private int widthTitleArea;
    private int heightTitleArea;
    private Dimension titleAreaSize;

    public TitleArea(Dimension areaNotesSize) {
        /**
         * Definit la taille
         */
        this.widthTitleArea = (int)areaNotesSize.getWidth();
        this.heightTitleArea = VariablesGlobals.getNoteSize();
        this.titleAreaSize = new Dimension(widthTitleArea,heightTitleArea);

        this.setLayout(new FlowLayout(FlowLayout.LEFT));
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setPreferredSize(titleAreaSize);

        /**
         * Titre de la liste
         */
        JLabel title = new JLabel();
        VariablesGlobals.setFont1(22);
        title.setFont(VariablesGlobals.getFont1());
        title.setForeground(VariablesGlobals.getColorFont2());
        title.setText("BlocNotes");

        this.add(Box.createRigidArea(new Dimension((int)areaNotesSize.getWidth()/5,0)));
        this.add(title);
    }
}
