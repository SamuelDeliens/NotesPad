package com.company.samuel.views.viewSettings.settingsContainer;

import com.company.samuel.views.viewSettings.settingsContainer.buttonSettings.*;

import javax.swing.*;
import java.awt.*;

/**
 * Panel général definissant un objet du parametre ainsi que le bouton correspondant
 *  -en fontion "setting" entré en parametre
 */
public class SettingX extends JPanel {
    private int widthTitleSettings;
    private int heightTitleSettings;
    private Dimension titleSettingsSize;

    public SettingX(Dimension settingsPanelSize, String setting) {
        /**
         * Taille du Panel
         */
        this.widthTitleSettings = (int)(2*settingsPanelSize.getWidth()/3);
        this.heightTitleSettings = (int)settingsPanelSize.getHeight()/10;
        this.titleSettingsSize = new Dimension(widthTitleSettings, heightTitleSettings);

        /**
         * Design du panel
         */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setOpaque(false);

        /**
         * Contents
         *  -ajout du nom du parametre
         *  -ajout du bouton correspondant en fonction de settings
         */
        this.add(new ObjectSetting(setting));
        this.add(Box.createRigidArea(new Dimension(150,0)));
        //ajout boutton X
        switch (setting) {
            case "style":
                this.add(new StyleButton());
                break;
            case "display":
                this.add(new DisplayButton());
                break;
            case "sort":
                this.add(new SortButton());
                break;
            default: break;
        }
    }
}
