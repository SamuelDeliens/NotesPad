package com.company.samuel.views.viewAdder.adderContainer;

import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel affichant le titre de la vue Adder
 */
public class TitleAdder extends JPanel {
    private int widthTitleAdder;
    private int heightTitleAdder;
    private Dimension titleAdderSize;

    public TitleAdder(Dimension adderContainerSize, String type, SubItem newItem) {
        /**
         * Taille du Panel
         */
        this.widthTitleAdder = (int)(2*adderContainerSize.getWidth()/3);
        this.heightTitleAdder = (int)adderContainerSize.getHeight()/6;
        this.titleAdderSize = new Dimension(widthTitleAdder, heightTitleAdder);

        /**
         * Design du Panel
         */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createMatteBorder(0, 0,1,0, VariablesGlobals.getColorFont1()));
        this.setPreferredSize(titleAdderSize);
        this.setMaximumSize(titleAdderSize);
        this.setMinimumSize(titleAdderSize);

        /**
         * Titre de la Vue --> on affiche ce que l'on veux ajouter
         *  --> "new File" / "new Folder" / "new BlocNotes"
         */
        JLabel title = new JLabel();
        title.setText("new "+newItem.getTypeSubItem());
        title.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(22);
        title.setFont(VariablesGlobals.getFont1());

        //Dans le cas d'ajout de BlocNotes on ne met pas de bouton pour changer l'épingle
        if (newItem.getTypeSubItem() != "BlocNotes") {
            this.add(new PinItemX(newItem, 20,20,10));
        }
        this.add(title);
    }
}
