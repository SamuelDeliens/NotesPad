package com.company.samuel.models;

import java.util.*;

public class Folder extends SubItem {
    /**
     *     Un dossier comprend: une list de SubItem, son type d'affichage (list ou gallery) et son type de tri (nom ou type)
     */
    protected ArrayList<SubItem> _contentsSubItem;
    protected String _displayType;
    protected String _typeSort;

    /**
     *      Un dossier est un SubItem qui peut contenir plusieurs SubItem
     *      Un fichier doit posseder une localisation (outre le cas du BlocNote dont la localisation est null)
     */

    /**
     *      Création d'un dossier sans nom (la localisation est obligatoire)
     * @param location
     */
    public Folder(Folder location) {
        /**
         *         On recupere le constructeur du SubItem pour le nom et la localisation
         *         Le nom par defaut est "folder"
         *         l'affichage par defaut est list et le tri est name
         */
        super("folder", location);
        this._contentsSubItem = new ArrayList<SubItem>();
        this._displayType = "list";
        this._typeSubItem = "Folder";
        this._typeSort = "name";
    }

    /**
     *      Création d'un dossier avec nom
     * @param name
     * @param location
     */
    public Folder(String name, Folder location) {
        super(name, location);
        this._contentsSubItem = new ArrayList<SubItem>();
        this._displayType = "list";
        this._typeSubItem = "Folder";
        this._typeSort = "name";
    }

    //-----------------------------------------Contents--------------------------------------------------
    /**
     *      Permet de recuperer l'ensemble des SubItem contenu dans le dossier
     * @return _contentsSubItem
     */
    public ArrayList<SubItem> getContents() {
        return this._contentsSubItem;
    }

    /**
     *      Permet d'ajouter un element au dossier
     */
    public void add(SubItem i) {
        this._contentsSubItem.add(i);
    }

    /**
     *      Permet de retirer un element au dossier
     */
    public void delete(SubItem i) {
        this._contentsSubItem.remove(i);
    }

    /**
     *      Permet de retirer l'ensemble des elements du dossier
     */
    public void clear() {
        this._contentsSubItem.clear();
    }

    //-----------------------------------------Move--------------------------------------------------
    /**
     *      Permet de deplacer un element du dossier vers un autre dossier
     *         -On ajoute l'element à l'autre dossier
     *         -On retire l'element du dossier
     *         -On change la localisation
     */
    public void move(SubItem item, Folder folderFinal) {
        folderFinal.add(item);
        this.delete(item);
        item._location = folderFinal;
    }

    /**
     *      Permet de deplacer un element vers la poubelle du BlocNote (etape obligatoire pour supprimer un element par sécurité)
     *         -On ajoute le nouvel elementà l'autre dossier
     *         -On retire l'element du dossier
     *         -On ne change pas la localisation afin de permettre de redeplacer l'element dans son dossier si erreur
     */
    public void moveTrash(SubItem i, Folder f) {
        f.add(i);
        this.delete(i);
    }

    //-----------------------------------------TypeDisplay--------------------------------------------------
    /**
     *      Permet de changer le type d'affichage du dossier
     */
    public void setDisplayType(String type) {
        this._displayType = type;
    }

    /**
     *      Permet de recuperer le type d'affichage du dossier
     * @return _displayType
     */
    public String getDisplayType() {
        return _displayType;
    }

    //-----------------------------------------Type sort--------------------------------------------------
    /**
     *      Permet de changer le type de tri du dossier
     */
    //
    public void setTypeSort(String newSort) {
        this._typeSort = newSort;
    }

    /**
     *      Permet de recuperer le type de tri du dossier
     * @return _typeSort
     */
    public String getTypeSort() {
        return this._typeSort;
    }

    //-----------------------------------------tri--------------------------------------------------
    /**
     *      Methode de tri
     */
    public void sortContents() {
        switch (this._typeSort) {
            case "name":
                Collections.sort(this._contentsSubItem, SubItem.ComparatorName);
                Collections.reverseOrder();
            case "type":
                //Compare le type
                Collections.sort(this._contentsSubItem, SubItem.ComparatorType);
                Collections.reverseOrder();
        }
    }
}
