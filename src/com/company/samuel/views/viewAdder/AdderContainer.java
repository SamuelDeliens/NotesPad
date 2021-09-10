package com.company.samuel.views.viewAdder;

import com.company.samuel.models.BlocNotes;
import com.company.samuel.models.*;
import com.company.samuel.views.general.VariablesGlobals;
import com.company.samuel.views.viewAdder.adderContainer.*;

import javax.swing.*;
import java.awt.*;

/**
 * Container Principal de la vue Adder
 */
public class AdderContainer extends JPanel {
    /**
     * On utilise un SubItem tampon et un BlocNote tampon en fonction de l'objet que l'on veut ajouter
     */
    private SubItem newSubItem = null;
    private BlocNotes newBloc = null;
    private int heightAdderContainer;
    private int widthAdderContainer;
    private Dimension adderContainerSize;

    public AdderContainer(Dimension borderSize, String type) {
        /**
         * Definit la taille du Panel en utilisant la taille de l'ecran passé en parametre
         */
        widthAdderContainer = (int)borderSize.getWidth()-30;
        heightAdderContainer = (int)borderSize.getHeight()-30;
        adderContainerSize = new Dimension(widthAdderContainer,heightAdderContainer);

        /**
         * On remplit les variables tampons en fonction de l'objet que l'on veut ajouter
         */
        if (type == "folder") {
            newSubItem = new Folder("folder", VariablesGlobals.getFolderCurrent());
        }
        else if (type == "file") {
            newSubItem = new File("file", VariablesGlobals.getFolderCurrent());
        }
        else if (type == "blocNotes") {
            newSubItem = new BlocNotes();
            newBloc = new BlocNotes();
        }

        /**
         * Style du Panel
         */
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setOpaque(false);
        this.setVisible(true);

        /**
         * On envoie dans tous les cas newSubItem mais on a besoin d'envoyer en plus newBloc dans le cas du AcceptButton afin d'acceder à la methode save()
         */
        this.add(new QuitButton(adderContainerSize, newSubItem));
        this.add(new TitleAdder(adderContainerSize, type, newSubItem));
        this.add(Box.createRigidArea(new Dimension(10,20)));
        this.add(new NameAdder(adderContainerSize, newSubItem));
        this.add(Box.createRigidArea(new Dimension(10,100)));
        this.add(new AcceptButton(adderContainerSize, newSubItem, newBloc));
    }
}
