package com.company.samuel.views.viewSettings.settingsContainer;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel affichant le titre de la vue Settings
 */
public class TitleSettings extends JPanel {
    private int widthTitleSettings;
    private int heightTitleSettings;
    private Dimension titleSettingsSize;

    public TitleSettings(Dimension settingsContainerSize) {
        /**
         * Taille du Panel
         */
        this.widthTitleSettings = (int)(2*settingsContainerSize.getWidth()/3);
        this.heightTitleSettings = (int)settingsContainerSize.getHeight()/10;
        this.titleSettingsSize = new Dimension(widthTitleSettings, heightTitleSettings);

        /**
         * Design du Panel
         */
        this.setLayout(new FlowLayout(FlowLayout.CENTER));
        this.setOpaque(false);
        this.setBorder(BorderFactory.createMatteBorder(0, 0,1,0,VariablesGlobals.getColorFont1()));
        this.setPreferredSize(titleSettingsSize);
        this.setMaximumSize(titleSettingsSize);
        this.setMinimumSize(titleSettingsSize);

        /**
         * Titre de la Vue
         */
        JLabel title = new JLabel();
        title.setText("Settings");
        title.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(22);
        title.setFont(VariablesGlobals.getFont1());

        /**
         * Contents
         */
        this.add(title);
        this.add(Box.createRigidArea(new Dimension(10,0)));
    }
}
