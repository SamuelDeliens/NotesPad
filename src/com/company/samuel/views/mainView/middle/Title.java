package com.company.samuel.views.mainView.middle;

import com.company.samuel.Main;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel Contenant le Titre de la vue
 */
public class Title extends JPanel {
    private JLabel iconL, iconR;

    public Title() {

        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel titre = new JLabel("Notes");
        VariablesGlobals.setFont1(48);
        titre.setFont(VariablesGlobals.getFont1());
        titre.setForeground(VariablesGlobals.getColorFont1());

        setIcon(); //definit l'icon

        /**
         * Contents
         */
        this.add(iconL);
        this.add(Box.createRigidArea(new Dimension(10,10)));
        this.add(titre);
        this.add(Box.createRigidArea(new Dimension(10,10)));
        this.add(iconR);
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     * Icon Gauche et Icon Droit
     */
    private void setIcon() {
        if (VariablesGlobals.getStyle().equals("dark")) {
            iconL = new JLabel();
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/StickMan2.png"));
            ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            iconL.setIcon(icon2);

            iconR = new JLabel();
            ImageIcon icon3 = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/StickMan3.png"));
            ImageIcon icon4 = new ImageIcon(icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            iconR.setIcon(icon4);
        } else {
            iconL = new JLabel();
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/StickMan2.png"));
            ImageIcon icon2 = new ImageIcon(icon.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            iconL.setIcon(icon2);

            iconR = new JLabel();
            ImageIcon icon3 = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/StickMan3.png"));
            ImageIcon icon4 = new ImageIcon(icon3.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
            iconR.setIcon(icon4);
        }
    }
}
