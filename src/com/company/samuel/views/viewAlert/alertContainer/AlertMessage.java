package com.company.samuel.views.viewAlert.alertContainer;

import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

public class AlertMessage extends JPanel {
    private int heightAlertMessage;
    private int widthAlertMessage;
    private Dimension alertMessageSize;

    public AlertMessage(Dimension alertContainerSize, SubItem elementSup) {
        /**
         * Definit la taille du Panel
         */
        this.widthAlertMessage = (int)(2*alertContainerSize.getWidth()/3);
        this.heightAlertMessage = (int)alertContainerSize.getHeight()/2;
        this.alertMessageSize = new Dimension(widthAlertMessage, heightAlertMessage);

        /**
         * Design du panel
         */
        this.setSize(alertContainerSize);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);


        /**
         * 2panels différents afin de pouvoir eviter les problemes pour les noms de fichiers trop long:
         * - premier panel intermediaire afin de centrer le text
         * - second panel intermediaire afin de centrer le nom du fichier
         */

        // 1er -------------------------
        JPanel inter = new JPanel();
        inter.setLayout(new FlowLayout(FlowLayout.CENTER));
        inter.setOpaque(false);

        JLabel alertMessage = new JLabel();
            //Affiche le message avec le type de l'element a supprimer
        alertMessage.setText("Voulez-vous supprimer le "+elementSup.getTypeSubItem()+": ");
        alertMessage.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(18);
        alertMessage.setFont(VariablesGlobals.getFont1());


        // 2nd -------------------------
        JPanel inter2 = new JPanel();
        inter2.setLayout(new FlowLayout(FlowLayout.CENTER));
        inter2.setOpaque(false);

        JLabel nomElementSup = new JLabel();
            //Affiche le nom de l'element a supprimer
        nomElementSup.setText(elementSup.getName());
        nomElementSup.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(18);
        nomElementSup.setFont(VariablesGlobals.getFont1());

        /**
         * Contents
         */
        inter.add(alertMessage);
        inter2.add(nomElementSup);

        this.add(inter);
        this.add(inter2);
    }
}
