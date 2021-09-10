package com.company.samuel.views.viewFile.middle.editFile;

import com.company.samuel.models.Text;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 * JTextArea affichant le texte contenu dans l'objet Text du Fichier
 */
public class BoxText extends JTextArea implements KeyListener, MouseListener {
    private Text _textX;
    private int widthBoxText;
    private int _numberLine = 0;
    private int heightFont16 = 19;
    private int widthFont16 = 8;

    public BoxText(Text textX, Dimension scrollPaneSize) {
        /**
         * Taille du JTextField
         *  la hauteur est redefinit avec la taille et les parametre de l'objet Text
         */
        this._textX = textX;
        this.widthBoxText = (int)scrollPaneSize.width-100;
        //Hauteur
        textX.setNumberColumn(widthBoxText);
        _textX.setNumberLine();
        this._numberLine = _textX.getNumberLine();

        /**
         * Design du JTextArea
         */
        this.setPreferredSize(new Dimension(widthBoxText, _numberLine * heightFont16 + 30));
        this.setMinimumSize(new Dimension(widthBoxText, _numberLine * heightFont16 + 30));
        this.setMaximumSize(new Dimension(widthBoxText, _numberLine * heightFont16 + 30));

        this.setMargin(new Insets(15,20,15,20));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());

        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(16);
        this.setFont(VariablesGlobals.getFont1());
        this.setLineWrap(true);


        /**
         * affiche le contenu de l'objet Text
         */
        this.setText(textX.getText());

        //Action
        this.addKeyListener(this);
        this.addMouseListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * Le But est de gerer efficassement la hauteur du JTextArea lors de l'edition du texte
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        _textX.setText(this.getText());
        /**
         * recupere le nombre de retour a la ligne du texte
         */
        _textX.setNumberLine(this.getLineCount());
        _numberLine = _textX.getNumberLine();

        /**
         * On evite de modifier le texte si on utilise les fleches dirrectionnel du clavier (37, 3!, 39, 40)
         */
        if (e.getKeyCode() != 37 && e.getKeyCode() != 38 && e.getKeyCode() != 39 && e.getKeyCode() != 40) {
            /**
             * Si on appuye sur entrer on augmente le nombre de ligne
             * Si on appuye sur supprimer on retire une ligne
             * On verifier que la taille est >2 avant de redefinir l'ensemble
             * On raffraichit aussi le texte du fichier tampon
             */
            if (e.getKeyCode() == 10) {
                _numberLine++;
            } else if (e.getKeyCode() == 8) {
                _numberLine--;
            }
            if (_numberLine > 2) {
                this.setSize(widthBoxText, _numberLine, heightFont16);
                VariablesGlobals.getFileModified().setText(_textX);
            }
        }
        /**
         * Si on appoye sur tab, on raffraichit la vue
         */
        if (e.getKeyCode() == 9) {
            VariablesGlobals.getViewCurrent().setChildView();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    /**
     * Definit la hauteur du JTextField en fonction du nombre de ligne, de la largeur du JTextField et du
     * nombre de pixel d'un caractere
     * @param widthBoxText
     * @param _numberLine
     * @param heightFont16
     */
    private void setSize(int widthBoxText, int _numberLine, int heightFont16) {
        this.setPreferredSize(new Dimension(widthBoxText, _numberLine * heightFont16 + 30));
        this.setMinimumSize(new Dimension(widthBoxText, _numberLine * heightFont16 + 30));
        this.setMaximumSize(new Dimension(widthBoxText, _numberLine * heightFont16 + 30));
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    /**
     * Au clic de la souris sur la TextArea on deffinit le Text correspondant en Text Courrant
     * --> Permet de pouvoir utiliser une liste de Text dans un fichier
     * @param e
     */
    @Override
    public void mousePressed(MouseEvent e) {
        VariablesGlobals.setTextCurrent(_textX);
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
