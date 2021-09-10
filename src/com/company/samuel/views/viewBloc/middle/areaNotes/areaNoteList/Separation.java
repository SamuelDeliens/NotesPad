package com.company.samuel.views.viewBloc.middle.areaNotes.areaNoteList;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel separant les SubItem de la listItem
 */
public class Separation extends JPanel {
    public Separation() {
        this.setPreferredSize(new Dimension(1000,1));
        this.setMaximumSize(new Dimension(1000,1));
        this.setMinimumSize(new Dimension(1000,1));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createMatteBorder(1,0,0,0, VariablesGlobals.getColorFont1()));
    }
}
