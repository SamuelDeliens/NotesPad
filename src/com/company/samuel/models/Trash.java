package com.company.samuel.models;

public class Trash extends Folder {
    /**
     *     Une Trash ne comprend rien
     * @param location
     */

    /**
     *     Une Trash est un dossier qui ajoute une methode pour redeplacer les elements en dehors de celle ci vers le dossier localisation
     * @param location
     */

    /**
     *     Création d'une Trash avec le BlocNote qui la contient
     * @param location
     */
    public Trash(BlocNotes location) {
        super("Trash", location);
        this._typeSubItem = "Trash";
    }
    /**
     *     Methode permettant de retirer le SubItem de la Trash
     * @param i
     */
    public void restore(SubItem i) {
        move(i, i._location);
    }
}
