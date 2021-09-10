package com.company.samuel.views.viewFile.middle.editFile.topFile;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Title extends JPanel {

    /**
     * Variable definissant les tailles du Panel et le fichier a modifier
     */
    private int heightTitle;
    private int widthTitle;
    private Dimension TitleSize;
    private File file = VariablesGlobals.getFileModified();

    public Title(Dimension middleContainerSize) {
        /**
         * Definit les tailles du Panel
         */
        this.widthTitle = (int)middleContainerSize.getWidth()-20;
        this.heightTitle = (int)(middleContainerSize.getHeight()/20);
        this.TitleSize = new Dimension(widthTitle,heightTitle);

        /**
         * Design
         */
        this.setPreferredSize(TitleSize);
        this.setMaximumSize(TitleSize);
        this.setOpaque(false);
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        /**
         * JTextFiel permettant de modifier le nom du fichier a Modifier
         */
        JTextField titre2 = new JTextField();
        titre2.setText(file.getName()); //recupere le nom du fichier a modifier
        VariablesGlobals.setFont1(24);
        titre2.setFont(VariablesGlobals.getFont1());
        titre2.setForeground(VariablesGlobals.getColorFont1());
        titre2.setOpaque(false);
        titre2.setBorder(BorderFactory.createEmptyBorder());

        //Action
        titre2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             *  Lorsque l'on appuye sur entré, on modifie le nom du fichier a modifier
             *  On raffraichit la vue
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    VariablesGlobals.getFileModified().setName(titre2.getText());
                    VariablesGlobals.getViewCurrent().setChildView();
                }
            }
        });

        /**
         * Contents:
         *  -Bouton pour deplace le fichier à la poubelle ou inversement
         *  -le nom du fichier
         *  -l'epingle si le fichier ne se situe pas dans la poubelle
         *  -Sinon on ajoute une Box pour centrer les elements
         */
        this.add(new ThrowFile( 20, 20, 10));
        this.add(Box.createRigidArea(new Dimension(10,10)));
        this.add(titre2);
        this.add(Box.createRigidArea(new Dimension(10,10)));
        if(!VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
            this.add(new PinFile(20,20,10));
        } else {
            this.add(Box.createRigidArea(new Dimension(18,10)));
        }
    }
}
