package com.company.samuel.views.viewAdder.adderContainer;

import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel afin de changer le nom du SubItem a ajouter
 */
public class NameAdder extends JPanel {
    private int heightNameAdder;
    private int widthNameAdder;
    private Dimension nameAdderSize;

    public NameAdder(Dimension adderContainerSize, SubItem newItem) {
        /**
         * Taille du Panel
         */
        this.widthNameAdder = (int)(3*adderContainerSize.getWidth()/4);
        this.heightNameAdder = (int)adderContainerSize.getHeight()/8;
        this.nameAdderSize = new Dimension(widthNameAdder, heightNameAdder);

        /**
         * Style du Panel
         */
        this.setPreferredSize(nameAdderSize);
        this.setMaximumSize(nameAdderSize);
        this.setLayout(new BorderLayout());
        this.setOpaque(false);
        this.setBorder(BorderFactory.createLineBorder(VariablesGlobals.getColorBackground2()));

        /**
         * JTextField du nom du SubItem a ajouter
         */
        JTextField name = new JTextField();
        name.setText(newItem.getName());
        name.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(18);
        name.setFont(VariablesGlobals.getFont1());
        name.setOpaque(false);
        name.setBorder(BorderFactory.createEmptyBorder());

        name.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             * On change le nom du nouveau SubItem lorsqu'on le modifie
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                newItem.setName(name.getText());
            }
        });

        /**
         * Contents
         * La Box permet de centrer le JTextField correctement
         */
        this.add(Box.createRigidArea(new Dimension(10,10)), BorderLayout.WEST);
        this.add(name, BorderLayout.CENTER);
    }
}
