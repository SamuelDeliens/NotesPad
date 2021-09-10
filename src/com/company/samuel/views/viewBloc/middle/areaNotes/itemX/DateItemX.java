package com.company.samuel.views.viewBloc.middle.areaNotes.itemX;

import com.company.samuel.models.SubItem;
import com.company.samuel.views.general.VariablesGlobals;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;

/**
 * Label affichant la date du SubItem
 */
public class DateItemX extends JLabel {
    public DateItemX(SubItem itemX, int size) {
        this.setLayout(new FlowLayout(FlowLayout.CENTER));

        /**
         * On choisit le type d'affichage de la Date --> j/m/a h:m
         */
        DateFormat shortDateFormat = DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT);

        this.setText(shortDateFormat.format(itemX.getDate()));
        this.setForeground(VariablesGlobals.getColorFont2());
        VariablesGlobals.setFont1(size);
        this.setFont(VariablesGlobals.getFont1());
    }
}
