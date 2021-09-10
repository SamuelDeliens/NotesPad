package com.company.samuel.views.viewFile;

import com.company.samuel.views.general.*;
import com.company.samuel.views.viewFile.middle.FileArea;

import javax.swing.*;
import java.awt.*;

/**
 * Container Milieu de la vue File
 */
public class MiddleContainer extends JPanel {
    private int heightMiddleContainer;
    private int widthMiddleContainer;
    private Dimension middleContainerSize;
    private Dimension borderSize;

    public MiddleContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        this.widthMiddleContainer = (int)screenSize.getWidth();
        this.heightMiddleContainer = (int)(95*(screenSize.getHeight()/100));
        this.middleContainerSize = new Dimension(widthMiddleContainer, heightMiddleContainer);
        this.borderSize = new Dimension(12*widthMiddleContainer/20, heightMiddleContainer);

        /**
         * Design du Container
         */
        this.setPreferredSize(middleContainerSize);
        this.setMaximumSize(middleContainerSize);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setBackground(VariablesGlobals.getColorBackground1());

        /**
         * On utilise un BorderPanel pour arrondir les coins du Panel
         */
        BorderPanel border = new BorderPanel(50, VariablesGlobals.getColorBackground2());
        border.setPreferredSize(borderSize);
        border.setOpaque(false);
        border.add(new FileArea(borderSize));

        this.add(border); // Ajoute le panel arrondit
    }
}
