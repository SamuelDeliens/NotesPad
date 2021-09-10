package com.company.samuel.views.viewBloc;

import com.company.samuel.views.general.*;
import com.company.samuel.views.viewBloc.middle.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Milieu de la vue BlocNotes
 */
public class MiddleContainer extends JPanel {

    /**
     * Variable definissant la taille du Panel
     */
    private int heightMiddleContainer;
    private int widthMiddleContainer;
    private Dimension middleContainerSize;

    public MiddleContainer(Dimension screenSize) {
        /**
         * Definit la taille du Panel en fonction de la taille d'écran passé en parametre
         */
        this.widthMiddleContainer = (int)screenSize.getWidth();
        this.heightMiddleContainer = (int)(90*(screenSize.getHeight()/100));
        this.middleContainerSize = new Dimension(widthMiddleContainer, heightMiddleContainer);

        /**
         * Design
         */
        this.setPreferredSize(middleContainerSize);
        this.setMaximumSize(middleContainerSize);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setBackground(VariablesGlobals.getColorBackground1());

        /**
         * Utilise un scrollPane (package general) en mettant un panel (ScrollPanel) en enfant
         */
        JScrollPane scrollPane = new JScrollPane(new ScrollPanel(middleContainerSize));
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setPreferredSize(middleContainerSize);
        scrollPane.setMaximumSize(middleContainerSize);
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
         * Contents:
         *  -Un titre: Le nom du Dossier courant
         *  -Une Bare de recherche: Search()
         *  -l'element scrollPane pour afficher le contenu du Dossier courant
         */
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(new Title(middleContainerSize));
        this.add(Box.createRigidArea(new Dimension(0,10)));
        this.add(new Search(middleContainerSize));
        this.add(Box.createRigidArea(new Dimension(0,5)));
        this.add(scrollPane);
    }
}
