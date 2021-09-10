package com.company.samuel.views.general;

/**
 *      Class general permettant de dessiner des Panel avec des bords arrondis
 */
import javax.swing.*;
import java.awt.*;

public class BorderPanel extends JPanel {
    private Color backgroundColor;
    private int cornerRadius = 15;

    /**
     * En utilisant le layout des enfants ainsi que le nombre de pixels des coins
     * @param layout
     * @param radius
     */
    public BorderPanel(LayoutManager layout, int radius) {
        super(layout);
        cornerRadius = radius;
    }

    /**
     * En utilisant la couleur en plus
     * @param layout
     * @param radius
     * @param bgColor
     */
    public BorderPanel(LayoutManager layout, int radius, Color bgColor) {
        super(layout);
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    /**
     * En utilisant seuelemnt le nombre de pixel des coins
     * @param radius
     */
    public BorderPanel(int radius) {
        super();
        cornerRadius = radius;
    }

    /**
     * En utilisant en plus la couleur de fond
     * @param radius
     * @param bgColor
     */
    public BorderPanel(int radius, Color bgColor) {
        super();
        cornerRadius = radius;
        backgroundColor = bgColor;
    }

    /**
     * On dessine ensuite le composant en utilisant les parametres déja rentré
     * @param g
     */
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Dimension arcs = new Dimension(cornerRadius, cornerRadius);
        int width = getWidth();
        int height = getHeight();
        Graphics2D graphics = (Graphics2D) g;
        graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        /**
         *     Dessine le panel arrondis avec les bordures
         */
        if (backgroundColor != null) {
            graphics.setColor(backgroundColor);
        } else {
            graphics.setColor(getBackground());
        }
        graphics.fillRoundRect(0, 0, width-5, height-10, arcs.width, arcs.height); //peint background
        graphics.setColor(getForeground());
        graphics.drawRoundRect(0, 0, width-5, height-10, arcs.width, arcs.height); //peint border
    }
}