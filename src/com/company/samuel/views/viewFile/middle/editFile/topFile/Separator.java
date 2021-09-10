package com.company.samuel.views.viewFile.middle.editFile.topFile;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Separation entre le haut et le contenu du Fichier
 */
public class Separator extends JPanel {
    public Separator(Dimension middleContainerSize) {

        /**
         * Design
         */
        this.setMaximumSize(new Dimension((int)(2*middleContainerSize.getWidth()/3), 20));
        this.add(Box.createRigidArea(new Dimension((int) middleContainerSize.getWidth()/2, 10)));
        this.setBorder(BorderFactory.createMatteBorder(0,0,1,0, VariablesGlobals.getColorFont1()));
        this.setOpaque(false);
    }
}
