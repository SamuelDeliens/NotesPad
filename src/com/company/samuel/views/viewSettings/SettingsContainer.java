package com.company.samuel.views.viewSettings;

import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewSettings.settingsContainer.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Principal de la vue Settings
 */
public class SettingsContainer extends JPanel {
    private int heightSettingsContainer;
    private int widthSettingsContainer;
    private Dimension settingsContainerSize;

    public SettingsContainer(Dimension borderSize) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        widthSettingsContainer = (int)borderSize.getWidth()-30;
        heightSettingsContainer = (int)borderSize.getHeight()-30;
        settingsContainerSize = new Dimension(widthSettingsContainer,heightSettingsContainer);

        /**
         * Design du Container
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);
        this.setVisible(true);

        /**
         * Contents
         *  -Ajoute le titre des Settings
         *  -Ajoute le changement de style (dark / light)
         *  -Ajoute display et sort si on est dans un dossier
         */
        this.add(new QuitButton(settingsContainerSize));
        this.add(new TitleSettings(settingsContainerSize));

        this.add(Box.createRigidArea(new Dimension(0,20)));
        this.add(new SettingX(settingsContainerSize, "style"));

        if (VariablesGlobals.getFolderCurrent() != null) {
            this.add(Box.createRigidArea(new Dimension(0,10)));
            this.add(new SettingX(settingsContainerSize, "display"));
            this.add(Box.createRigidArea(new Dimension(0,10)));
            this.add(new SettingX(settingsContainerSize, "sort"));
        }
    }
}
