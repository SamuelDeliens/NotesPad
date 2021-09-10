package com.company.samuel.views.mainView;

import com.company.samuel.views.general.*;
import com.company.samuel.views.mainView.middle.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel milieu de la vue Principale --> affiche la liste des BlocNotes
 */
public class MiddleContainer extends JPanel {
    private JScrollPane scrollPane;
    private int heightMiddleContainer;
    private int widthMiddleContainer;
    private Dimension middleContainerSize;

    public MiddleContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        this.widthMiddleContainer = (int)screenSize.getWidth();
        this.heightMiddleContainer = (int)(90*(screenSize.getHeight()/100));
        this.middleContainerSize = new Dimension(widthMiddleContainer, heightMiddleContainer);

        this.setPreferredSize(middleContainerSize);
        this.setMaximumSize(middleContainerSize);

        /**
         *  Definit un layout en colonne
         */

        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(VariablesGlobals.getColorBackground1());

        /**
         * Utilise un scrollPane (package general) en mettant un panel (ScrollPanel) en enfant
         */
        scrollPane = new JScrollPane(new ScrollPanel(screenSize));
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setPreferredSize(screenSize);
        scrollPane.setMaximumSize(screenSize);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

        /**
         * Definit une scrollBar (package general) afin de changer son style
         */
        JScrollBar verticalBar = new JScrollBar();
        verticalBar.setLayout(new BorderLayout());
        verticalBar.setOpaque(false);
        verticalBar.setUI(new MyScrollBarUi());

        scrollPane.setVerticalScrollBar(verticalBar);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());

        /**
         * Contents
         */
        this.add(Box.createRigidArea(new Dimension(0,5)));
        /**
         * titre de la Fenetre: "Notes"
         */
        this.add(new Title());
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(scrollPane);
    }
}
