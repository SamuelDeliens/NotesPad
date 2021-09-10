package com.company.samuel.views.mainView.middle.areaNotes.itemX;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Definit le nom du BlocNote
 */
public class NameItemX extends JTextField {

    public NameItemX(BlocNotes itemX) {

        /**
         * Style du JTextField
         */
        this.setText(itemX.getName());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setEditable(false);

        /**
         * Recupere la largeur du message pour gerer la taille du JTextField
         */
        FontMetrics metrics = this.getFontMetrics(this.getFont());
        int messageWidth = metrics.stringWidth(this.getText());

        this.setMaximumSize(new Dimension(messageWidth,50));
    }
}
