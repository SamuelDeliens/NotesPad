package com.company.samuel.views.viewAlert;

import com.company.samuel.models.*;
import com.company.samuel.views.viewAlert.alertContainer.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Principal de la vue Alert
 */
public class AlertContainer extends JPanel {
    private int heightAlertContainer;
    private int widthAlertContainer;
    private Dimension alertContainerSize;

    public AlertContainer(Dimension borderSize, SubItem elementSup) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        widthAlertContainer = (int)borderSize.getWidth()-30;
        heightAlertContainer = (int)borderSize.getHeight()-30;
        alertContainerSize = new Dimension(widthAlertContainer,heightAlertContainer);

        /**
         * Design du Panel
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);
        this.setVisible(true);

        /**
         * Contents
         *  - Ajoute le message d'alerte
         *  - Ajoute les boutons de choix
         */
        this.add(Box.createRigidArea(new Dimension(10,30)));
        this.add(new AlertMessage(alertContainerSize, elementSup));
        this.add(Box.createRigidArea(new Dimension(10,50)));
        this.add(new ChoiseAlert(alertContainerSize, elementSup));
    }
}
