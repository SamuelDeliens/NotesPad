package com.company.samuel.models;

import java.awt.*;
import java.io.Serializable;

public class Text implements Serializable {
    /**
     *     Un Text comprend: un texte, une police, une couleur, un nombre de ligne et de colonne, une taille
     *     Le nombre de lignes et colonnes est utile pour definir la taille de l'Interface
     */
    private String _text;
    private Font _font;
    private Color _color;
    private int _numberLine;
    private int _numberColumn;
    private static int widthFont16 = 8;

    /**
     *     Un Text a un texte par defaut, une police, une couleur et une taille definir
     */

    /**
     *     Création d'un Text
     */
    public Text() {
        this._text = "Edit here  *refresh by press tab* ";
        this._font = new Font("Helvetica Neue", Font.PLAIN, 16);
        this._color = Color.white;
        this._numberLine = 3;
        this._numberColumn = 0;
    }

    //-----------------------------------------Text------------------------------------------------------
    /**
     *    Permet de definir le texte d'un objet Text
     * @param text
     */
    public void setText(String text) {
        this._text = text;
    }

    /**
     * Permet de recuperer le text d'un objet Text
     * @return _text
     */
    public String getText() {
        return this._text;
    }

    //-----------------------------------------Font------------------------------------------------------
    /**
     *     Permet de definir la police d'un objet Text
     * @param font
     */
    public void setFont(Font font) {
        this._font = font;
    }

    /**
     *      Permet de recuperer la police
     * @return _font
     */
    public Font getFont() {
        return this._font;
    }

    //-----------------------------------------Color------------------------------------------------------
    /**
     *     Permet de definir la couleur d'un objet Text
     * @param color
     */
    public void setColor(Color color) {
        this._color = color;
    }

    /**
     *      Permet de recuperer la couleur
     * @return _color
     */
    public Color getColor() {
        return this._color;
    }

    //-----------------------------------------Column------------------------------------------------------
    /**
     *     Permet de definir le nombre colonnes d'un objet Text
     * @param widthBoxText
     */
    public void setNumberColumn(int widthBoxText) {
        //On utilise le nombre de pixel pour une police de 16 (widthFont16)
        //taille de la fenetre / taille pixel donne le nombre de pixel possible en une ligne
        this._numberColumn = widthBoxText/widthFont16;
    }

    /**
     * Permet de recuperer le nombre de colonnes d'un objet Text
     * @return _numberColumn
     */
    public int getNumberColumn() {
        return this._numberColumn;
    }

    //-----------------------------------------Line------------------------------------------------------
    /**
     *     Permet de definir le nombre de lignes d'un objet Text en recuperant le nombre de retour à la ligne
     * @param _numberEnter
     */
    public void setNumberLine(int _numberEnter) {
        this._numberLine = _numberEnter;
        //recupere donc chaque ligne (entre les caracteres '\n')
        for(String s : this.getText().split("\n")) {
            //On incrementes le nombre de ligne si le nombre de caractere depace le nombre disponible d'une ligne (numberColumn)
            this._numberLine += (int)Math.floor(s.length()/_numberColumn);
        }
        //le nombre de ligne minimum est 3
        if (this._numberLine <= 2) {
            this._numberLine = 3;
        }
    }
    /**
     *     Permet de definir le nombre de lignes d'un objet Text sans avoir le nombre de colonne
     */
    public void setNumberLine() {
        //On definir le nombre de ligne à 1
        this._numberLine =1;
        //On increment pour chaque ligne (entre caracteres '\n')
        for(String s : this.getText().split("\n")) {
            _numberLine++;
        }
        //Comme pour la methode precedente, on increment si la ligne est revenu a la ligne sans '\n'
        for(String s : this.getText().split("\n")) {
            this._numberLine += (int)Math.floor(s.length()/_numberColumn);
        }
        //Le nombre minimal est encore 3
        if (this._numberLine <= 2) {
            this._numberLine = 3;
        }
    }

    /**
     *     Permet de recuperer le nombre de ligne
     * @return
     */
    public int getNumberLine() {
        return this._numberLine;
    }
}
