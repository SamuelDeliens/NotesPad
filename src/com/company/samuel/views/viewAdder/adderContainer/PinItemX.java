package com.company.samuel.views.viewAdder.adderContainer;

import com.company.samuel.Main;
import com.company.samuel.models.SubItem;

import javax.swing.*;
import java.awt.*;

/**
 * Bouton pour definir si le SubItem est epinglé ou non
 */
public class PinItemX extends JButton {
    private SubItem _itemX;
    private int _widthScale;
    private int _heightScale;
    private int _widhtMore;

    public PinItemX(SubItem itemX, int widthScale, int heightScale, int widhtMore) {
        /**
         * Scale et variable _itemX pour y acceder dans changeIcon()
         */
        _itemX = itemX;
        _widthScale = widthScale;
        _heightScale = heightScale;
        _widhtMore = widhtMore;

        /**
         * Design du Bouton
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(_widthScale+_widhtMore,_heightScale));
        this.changeIcon();

        /**
         * On change l'icon et la variable du SubItem que l'on veux ajouter
         */
        this.addActionListener(e -> {
            itemX.changePin();
            changeIcon();
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     */
    public void changeIcon() {
        if (_itemX.getPin()) {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/Pin.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        } else {
            ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/noPin2.png"));
            ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
            this.setIcon(iconR);
        }
    }
}
