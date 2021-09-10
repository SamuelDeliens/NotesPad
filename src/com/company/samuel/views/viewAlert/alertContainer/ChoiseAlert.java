package com.company.samuel.views.viewAlert.alertContainer;

import com.company.samuel.models.SubItem;

import javax.swing.*;
import java.awt.*;

/**
 * Panel intermediaire afin de mettre les boutons accept et refus sur la meme ligne
 */
public class ChoiseAlert extends JPanel {
    private int heightChoiseAlert;
    private int widthChoiseAlert;
    private Dimension choiseAlertSize;

    public ChoiseAlert(Dimension alertContainerSize, SubItem elementSup) {
        /**
         * Taille du Panel
         */
        this.widthChoiseAlert = (int)(2*alertContainerSize.getWidth()/2);
        this.heightChoiseAlert = (int)alertContainerSize.getHeight()/6;
        this.choiseAlertSize = new Dimension(widthChoiseAlert, heightChoiseAlert);

        /**
         * Design du Panel
         */
        this.setPreferredSize(choiseAlertSize);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setOpaque(false);

        /**
         * Contents
         */
        this.add(new QuitButton());
        this.add(Box.createRigidArea(new Dimension(30,10)));
        this.add(new AcceptButton(elementSup));
    }
}
