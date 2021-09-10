package com.company.samuel.views.viewBloc.middle.areaNotes.itemX;

import com.company.samuel.Main;
import com.company.samuel.models.Folder;
import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Definit le bouton pour deplacer le SubItem vers la corbeille et inversement
 */
public class ThrowButton extends JButton {
    private SubItem _itemX;
    private int _widthScale;
    private int _heightScale;
    private int _widhtMore;
    private Folder folder;

    public ThrowButton(SubItem itemX, int widthScale, int heightScale, int widhtMore) {
        /**
         * Definition des scales pour l'icone
         */
        _itemX = itemX;
        _widthScale = widthScale;
        _heightScale = heightScale;
        _widhtMore = widhtMore;

        /**
         * On verifie si on doit utiliser le dossier courant ou le dossier de recherche
         */
        if (VariablesGlobals.getFolderSearch() == null) {
            folder = VariablesGlobals.getFolderCurrent();
        } else {
            folder = VariablesGlobals.getFolderSearch();
        }

        /**
         * Design
         */
        this.setOpaque(false);
        this.setBorder(BorderFactory.createEmptyBorder());
        this.setPreferredSize(new Dimension(_widthScale + _widhtMore, _heightScale));
        this.setIcon();

        //Action
        this.addActionListener(e -> {
            /**
             * On verifie si on se situe dans la poubelle --> soit on retire, soit on place dans la poubelle
             */

            if (!VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
                /**
                 * On deplace le SubItem vers la poubelle
                 * On le retire du dossier de recherche s'il etait existant
                 * On raffraichit la vue
                 */
                VariablesGlobals.getFolderCurrent().moveTrash(itemX, VariablesGlobals.getBlocNoteCurrent().getTrash());
                if (VariablesGlobals.getFolderSearch() != null) {
                    VariablesGlobals.getFolderSearch().getContents().remove(itemX);
                }
                VariablesGlobals.getViewCurrent().setChildView();
            } else if (VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
                /**
                 * On deplace le SubItem vers sa localisation
                 * On le retire du dossier de recherche s'il etait existant
                 * On raffraichit la vue
                 */
                VariablesGlobals.getFolderCurrent().moveTrash(itemX, itemX.getLocation());
                if (VariablesGlobals.getFolderSearch() != null) {
                    VariablesGlobals.getFolderSearch().getContents().remove(itemX);
                }
                VariablesGlobals.getViewCurrent().setChildView();
            }
        });
    }

    /**
     * Definit l'icon en fonction du style (iconD --> dark / iconL --> light)
     * On verifie aussi si on se situe dans la poubelle ou non
     */
    public void setIcon() {
        if (!_itemX.getPin() && !VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
            if (VariablesGlobals.getStyle().equals("dark")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/Trash.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/Trash.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        } else if (VariablesGlobals.getFolderCurrent().getTypeSubItem().equals("Trash")) {
            if (VariablesGlobals.getStyle().equals("dark")) {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsD/restaure.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            } else {
                ImageIcon icon = new ImageIcon(Main.class.getResource("Assets/Icons/iconsL/restaure.png"));
                ImageIcon iconR = new ImageIcon(icon.getImage().getScaledInstance(_widthScale, _heightScale, Image.SCALE_DEFAULT));
                this.setIcon(iconR);
            }
        }
    }
}
