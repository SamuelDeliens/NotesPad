package com.company.samuel.views.general;

/**
 * Permet de redessiner la scrollBar des JScrollPane
 */

import javax.swing.*;
import javax.swing.plaf.ScrollBarUI;
import java.awt.*;

public class MyScrollBarUi extends ScrollBarUI {
    public void MyScrollBarUI() {}

    @Override
    public void installUI(JComponent c) {
        super.installUI(c);
    }

    @Override
    public void paint(Graphics g, JComponent c) {
        System.out.println(c.getX());
        System.out.println(c.getY());
        System.out.println(c.getWidth());
        System.out.println(c.getHeight());

        super.paint(g, c);
        Graphics2D graphics2D = (Graphics2D) g.create();
        graphics2D.fillRoundRect(c.getX(),c.getY(), c.getWidth(), c.getHeight()/2,5,5);
        graphics2D.setColor(VariablesGlobals.getColorFont1());
        graphics2D.setBackground(Color.red);
        graphics2D.dispose();
    }
}
