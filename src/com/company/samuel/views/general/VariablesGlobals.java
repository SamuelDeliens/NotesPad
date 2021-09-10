package com.company.samuel.views.general;

import com.company.samuel.controllers.*;
import com.company.samuel.models.*;
import com.company.samuel.views.viewBloc.middle.*;

import java.awt.*;

public class VariablesGlobals {
    /**
     * Variable non modifiable
     *  -hauteur graphique des SubItems
     *  -nombre de SubItem par ligne en mode gallery
     */
    private static int noteSize = 50;
    private static int numberLineGallery = 6;

    /**
     * ---------------------------STYLE DISPLAY---------------------------
     */
        /**
         * Definit les couleurs utilisées pour le style dark
        */
    private static Color colorD = new Color(0xFF131313, true);
    private static Color colorD2 = new Color(0x71717175, true);
    private static Color colorDS = new Color(0x3C3C3E);
    private static Color colorFontD = new Color(0xFFFFFF);
    private static Color colorFont2D = new Color(0xFFF29E00);
    private static Color colorDialogD = new Color(0x212121);

    /**
     * Definit les couleurs utilisées pour le style light
     */
    private static Color colorL = new Color(0xECECEC);
    private static Color colorL2 = new Color(0x70393E61, true);
    private static Color colorLS = new Color(0x9D9FAE);
    private static Color colorFontL = new Color(0x000000);
    private static Color colorFont2L = new Color(0x843434);
    private static Color colorDialogL = new Color(0xDEDEDE);

    /**
     * Definit les variables globals pour le style (par defaut, ce sont les couleurs dark)
     */
    private static Color colorBackground = colorD;
    private static Color colorBackground2 = colorD2;
    private static Color colorBackgroundS = colorDS;
    private static Color colorBackgroundDialog = colorDialogD;

    private static Color colorFont1 = colorFont2D;
    private static Color colorFont2 = colorFontD;

    /**
     * Definit un font global
     */
    private static Font font1;

    /**
     * Definit le style (TRUE --> dark / FALSE --> light)
     */
    private static Boolean style = true; //TRUE --> DARK //FALSE --> LIGHT


    /**
     *     -----------------RECUP OBJET D'AFFICHAGE (vue actuelle / blocNote actuelle / ect...)----------------
     */
    private static Views viewCurrent;

    private static BlocNotes blocNoteCurrent;
    private static Folder folderCurrent;
    private static File fileCurrent;
    private static Text textCurrent;

    /**
     *  Utilise un fichier tampon afin de ne pas modifier dirrectement le fichier lorsque l'on travail sur le text
     */
    private static File fileModified;
    /**
     * utilise un dossier tampon afin d'afficher seulements les SubItem lors d'une recherche sans modifier le dossier de base
     */
    private static Folder folderSearch = null;
    /**
     * texte de recherche (String utilisé pour definir le folderSearch)
     *      ce texte est definit par l'utilisateur et est remis en null une fois la recherche finis
     */
    private static String searchText;

    private static ScrollPanel displayAreaNotes;
    private static ChooseTypeAreaNotes displayTypeAreaNotes;

    /**
     *     -------------------------------------------METHODS-------------------------------------------------
     */
    public VariablesGlobals() {}

    public static void setNoteSize(int size) {
        noteSize = size;
    }
    public static int getNoteSize() {
        return noteSize;
    }

    public static void setNumberLineGallery(int number) {
        numberLineGallery = number;
    }
    public static int getNumberLineGallery() {
        return numberLineGallery;
    }


    /**
     *     ---------------------------METHOD DISPLAY---------------------------
     */

    /**
     * Definit et recupere les differentes couleurs de fond (en fonction du style --> dark ou light)
     */
    public static void setColorBackground1() {
        if (style) {
            colorBackground = colorD;
        } else {
            colorBackground = colorL;
        }
    }
    public static Color getColorBackground1() {
        return colorBackground;
    }

    public static void setColorBackground2() {
        if (style) {
            colorBackground2 = colorD2;
        } else {
            colorBackground2 = colorL2;
        }
    }
    public static Color getColorBackground2() {
        return colorBackground2;
    }

    public static void setColorBackgroundS() {
        if (style) {
            colorBackgroundS = colorDS;
        } else {
            colorBackgroundS = colorLS;
        }
    }
    public static Color getColorBackgroundS() {
        return colorBackgroundS;
    }

    public static void setColorBackgroundDialog() {
        if (style) {
            colorBackgroundDialog = colorDialogD;
        } else {
            colorBackgroundDialog = colorDialogL;
        }
    }
    public static Color getColorBackgroundDialog() {
        return colorBackgroundDialog;
    }

    /**
     * Definit la police en fonction de la taille
     * @param size
     */
    public static void setFont1(int size) {
        font1 = new Font("Helvetica Neue", Font.PLAIN, size);
    }
    public static Font getFont1() {
        return font1;
    }

    /**
     * Definit les couleurs de la police (en fonction du style --> dark ou light)
     */
    public static void setColorFont1() {
        if (style) {
            colorFont1 = colorFont2D;
        } else {
            colorFont1 = colorFont2L;
        }
    }
    public static Color getColorFont1() {
        return colorFont1;
    }

    public static void setColorFont2() {
        if (style) {
            colorFont2 = colorFontD;
        } else {
            colorFont2 = colorFontL;
        }
    }
    public static Color getColorFont2() {
        return colorFont2;
    }

    /**
     * Switch de style entre light et dark --> raffraichit l'ensemble des couleurs
     */
    public static void switchStyle() {
        style = !style;
        setColorBackground1();
        setColorBackground2();
        setColorBackgroundS();
        setColorFont1();
        setColorFont2();
        setColorBackgroundDialog();
    }
    public static String getStyle() {
        if (style) {
            return "dark";
        } else {
            return "light";
        }
    }


    /**
     *     ---------------------------METHOD RECUP---------------------------
     *     On redefinit tous les objets (affichage et fonctionnel)
     */
    public static void setBlocNoteCurrent(BlocNotes blocNote) {
        blocNoteCurrent = blocNote;
    }
    public static BlocNotes getBlocNoteCurrent() {
        return blocNoteCurrent;
    }

    public static void setFolderCurrent(Folder folder) {
        folderCurrent = folder;
    }
    public static Folder getFolderCurrent() {
        return folderCurrent;
    }

    public static void setFileCurrent(File file) {
        fileCurrent = file;
    }
    public static File getFileCurrent() {
        return fileCurrent;
    }

    public static void setTextCurrent(Text text) {
        textCurrent = text;
    }
    public static Text getTextCurrent() {
        return textCurrent;
    }

    /**
     * Definit les objets tampons (dossier de recherche et fichier modifié lors edition du contenu)
     * @param file
     */
    public static void setFileModified(File file) {
        fileModified = file;
    }
    public static File getFileModified() {
        return fileModified;
    }

    public static void setFolderSearch(Folder folder) {
        folderSearch = folder;
    }
    public static Folder getFolderSearch() {
        return folderSearch;
    }

    /**
     * texte de recherche
     * @param text
     */
    public static void setSearchText(String text) {
        searchText = text;
    }
    public static String getSearchText() {
        return searchText;
    }

    /**
     * Objet courrant --> permet le rafraichissement
     * @return
     */
    public static ScrollPanel getDisplayAreaNotes() {
        return displayAreaNotes;
    }
    public static void setDisplayAreaNotes(ScrollPanel newDisplay) {
        displayAreaNotes = newDisplay;
    }

    public static ChooseTypeAreaNotes getDisplayTypeAreaNotes() {
        return displayTypeAreaNotes;
    }
    public static void setDisplayTypeAreaNotes(ChooseTypeAreaNotes newTypeDisplay) {
        displayTypeAreaNotes = newTypeDisplay;
    }

    public static Views getViewCurrent() {
        return viewCurrent;
    }
    public static void setViewCurrent(Views newView) {
        viewCurrent = newView;
    }
}
