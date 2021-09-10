package com.company.samuel.views.viewSettings.settingsContainer;

import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;

/**
 * Panel affichant le nom du parametre
 */
public class ObjectSetting extends JPanel {
    public ObjectSetting(String setting) {
        /**
         * Design du Panel
         */
        this.setPreferredSize(new Dimension(100,40));
        this.setOpaque(false);

        /**
         * nom du parametre --> entré en parametre
         */
        JLabel text = new JLabel();
        text.setText(setting);
        text.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(18);
        text.setFont(VariablesGlobals.getFont1());

        this.add(text);
    }
}
