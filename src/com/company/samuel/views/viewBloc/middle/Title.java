package com.company.samuel.views.viewBloc.middle;

import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewBloc.middle.areaNotes.itemX.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * Panel Contenant le Titre de la vue
 */
public class Title extends JPanel implements MouseListener {
    /**
     * Variables definissant taille, Dossier courant, un JTextField pour y acceder dans les listener
     */
    private int heightTitle;
    private int widthTitle;
    private Dimension TitleSize;
    private Folder folderT = VariablesGlobals.getFolderCurrent();
    private JTextField titre2;

    public Title(Dimension middleContainerSize) {
        /**
         * Definit la taille du Panel en utilisant la taille entré en parametre
         */
        this.widthTitle = (int) middleContainerSize.getWidth();
        this.heightTitle = (int) (middleContainerSize.getHeight() / 20);
        this.TitleSize = new Dimension(widthTitle, heightTitle);

        /**
         * Design
         */
        this.setPreferredSize(TitleSize);
        this.setMaximumSize(TitleSize);
        this.setBackground(VariablesGlobals.getColorBackground1());
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        /**
         * JTextField si on est pas dans Trash
         */
        titre2 = new JTextField();
        titre2.setText(folderT.getName());
        VariablesGlobals.setFont1(24);
        titre2.setFont(VariablesGlobals.getFont1());
        titre2.setForeground(VariablesGlobals.getColorFont1());
        titre2.setOpaque(false);
        titre2.setBorder(BorderFactory.createEmptyBorder());
        titre2.setEditable(false);
        titre2.addMouseListener(this);

        //Action
        titre2.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {

            }

            /**
             * On definit le nouveau nom du dossier courant lorsque l'on appuye sur entré
             * On redefinit la vue courante
             * @param e
             */
            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == 10) {
                    VariablesGlobals.getFolderCurrent().setName(titre2.getText());
                    VariablesGlobals.getViewCurrent().setChildView();
                }
            }
        });

        /**
         * JLabel si on est dans Trash
         */
        JLabel titre3 = new JLabel(folderT.getName());
        titre3.setFont(VariablesGlobals.getFont1());
        titre3.setForeground(VariablesGlobals.getColorFont1());

        /**
         * JLabel si on effectue une recherche
         */
        JLabel titre4 = new JLabel("Recherche: < "+ VariablesGlobals.getSearchText()+" >");
        titre4.setFont(VariablesGlobals.getFont1());
        titre4.setForeground(VariablesGlobals.getColorFont2());

        /**
         * On definit le titre differement selon le dossier courant ou si l'on effectue une recherche
         */
        if (VariablesGlobals.getFolderSearch() == null) {
            switch (folderT.getTypeSubItem()) {
                case "Folder":
                    this.add(Box.createRigidArea(new Dimension(10, 10)));
                    this.add(titre2);
                    this.add(new PinItemX(folderT, 20, 20, 10, "title"));
                    break;
                case "BlocNotes":
                    this.add(titre2);
                    break;
                case "Trash":
                    this.add(Box.createRigidArea(new Dimension(10, 10)));
                    this.add(titre3);
                    this.add(new ClearItems(20, 20, 10));
                    break;
                default: break;
            }
        } else {
            this.add(titre4);
        }
    }

    /**
     * Dans le cas ou l'on se situe dans un dossier (pas la poubelle ni un blocNotes)
     *  -On verifie si il y a double click de la souris afin de pouvoir modifier le nom
     * @param e
     */
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2 && e.getButton() == MouseEvent.BUTTON1) {
            titre2.setEditable(true);
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
