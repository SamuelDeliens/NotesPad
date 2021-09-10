package com.company.samuel.views.viewBloc.middle.areaNotes.itemX;

import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Definit le nom du SubItem
 */
public class NameItemX extends JTextField implements KeyListener, MouseListener{
    private SubItem itemX;

    public NameItemX(SubItem itemX) {
        this.itemX = itemX;

        /**
         * Style du JTextField
         */
        this.setText(itemX.getName());
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.addKeyListener(this);
        this.addMouseListener(this);
        this.setEditable(false);

        /**
         * Recupere la largeur du message pour gerer la taille du JTextField
         */
        FontMetrics metrics = this.getFontMetrics(this.getFont());
        //On récupère la largeur du message du JLabel
        int messageWidth = metrics.stringWidth(this.getText());

        this.setMaximumSize(new Dimension(messageWidth,50));
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    /**
     * On definit le nouveau nom du SubItem lorsque l'on appuye sur entré
     * On redefinit la vue courante
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == 10) {
            for (SubItem item : VariablesGlobals.getFolderCurrent().getContents()) {
                if (this.itemX == item) {
                    item.setName(this.getText());
                    this.setEditable(false); //remet en non editable
                }
            }
            VariablesGlobals.getFolderCurrent().sortContents();
            VariablesGlobals.getViewCurrent().setChildView();
        }
    }

    /**
     *  -On verifie si il y a double click de la souris afin de pouvoir modifier le nom
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            this.setEditable(true);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }
}
