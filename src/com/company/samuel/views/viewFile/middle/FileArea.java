package com.company.samuel.views.viewFile.middle;

import com.company.samuel.views.general.MyScrollBarUi;

import javax.swing.*;
import java.awt.*;

/**
 * Panel permettant d'obtenir une zone scrollable si le texte etait trop grand
 */
public class FileArea extends JPanel{
    private int heightScrollPane;
    private int widthScrollPane;
    private Dimension scrollPaneSize;

    public FileArea(Dimension borderSize) {
        /**
         * Definit la taille du Panel
         */
        this.widthScrollPane = (int)borderSize.getWidth()-30;
        this.heightScrollPane = (int)(25*borderSize.getHeight()/30);
        this.scrollPaneSize = new Dimension(widthScrollPane, heightScrollPane);

        /**
         * Design du Panel
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);

        /**
         * Utilise un scrollPane (package general) en mettant un panel (ScrollPanel) en enfant
         */
        JScrollPane scrollPane = new JScrollPane(new EditArea(scrollPaneSize, borderSize));
        scrollPane.setLayout(new ScrollPaneLayout());
        scrollPane.setPreferredSize(scrollPaneSize);
        scrollPane.setMinimumSize(scrollPaneSize);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.setOpaque(false);

        /**
         * Definit une scrollBar (package general) afin de changer son style
         */
        JScrollBar verticalBar = new JScrollBar();
        verticalBar.setLayout(new BorderLayout());
        verticalBar.setOpaque(false);
        verticalBar.setUI(new MyScrollBarUi());

        scrollPane.setVerticalScrollBar(verticalBar);

        /**
         * Contents
         */
        this.add(scrollPane);
    }
}
