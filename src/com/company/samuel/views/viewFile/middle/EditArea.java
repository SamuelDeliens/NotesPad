package com.company.samuel.views.viewFile.middle;

import com.company.samuel.models.File;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewFile.middle.editFile.*;
import com.company.samuel.views.viewFile.middle.editFile.topFile.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel permettant d'afficher le contenu du Fichier
 */
public class EditArea extends JPanel {
    /**
     * Recupere le fichier a modifier (tampon)
     */
    private File file = VariablesGlobals.getFileModified();

    public EditArea(Dimension scrollPaneSize, Dimension borderSize) {
        /**
         * met fond d'une couleur car SetOpacity fonctionne pas
         * --> La couleur est la couleur superposé de la couleur de fond (opaque) et la couleur des Panel (non opaque)
         */
        this.setBackground(VariablesGlobals.getColorBackgroundS());

        /**
         * Design du Panel
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        /**
         * Contents (ajoute des box sur les cotés exterieurs pour centrer un peu les elements)
         */
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(new Title(borderSize));
        this.add(new Separator(borderSize));
        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(new BoxText(file.getContent(), scrollPaneSize));
    }
}
