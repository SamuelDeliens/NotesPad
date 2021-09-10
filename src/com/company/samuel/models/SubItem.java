package com.company.samuel.models;

import java.io.*;
import java.util.Comparator;
import java.util.Date;

public abstract class SubItem implements Serializable {
    /**
     *      Un subItem comprend: un nom, une localisation, une epingle (boolean), un type (File ou Folder), une date
     */
    protected static int id = 0;
    protected int _id;
    protected String _name;
    protected Folder _location;
    protected Boolean _pin;
    protected String _typeSubItem;
    protected Date _date;

    /**
     *     Un subItem est une classe abstraite de Dossiers et de Fichier
     *     Un subItem a par defaut pas d'epingle et une date de creation
     * @param name
     * @param location
     */

    /**
     *      Création d'un SubItem avec nom (File ou Folder dans le cas des constructeur de Fichier et Dossier sans nom)
     * @param name
     * @param location
     */
    public SubItem(String name, Folder location) {
        this._id = id++;
        this._name = name;
        this._location = location;
        this._pin = false;
        this._date = new Date();
    }

    //--------------------------------------------Name------------------------------------------------------
    /**
     *     Permet de recuperer le nom du SubItem
     * @return
     */
    public String getName() {
        return this._name;
    }
    /**
     *     Permet de definir le nom du SubItem
     * @param name
     */
    public void setName(String name) {
        this._name = name;
    }

    //--------------------------------------------Pin------------------------------------------------------
    /**
     *     Permet de recuperer si le SubItem est epinglé ou non
     * @return
     */
    public Boolean getPin() {
        return this._pin;
    }

    /**
     *     Permet de changer l'epingle du SubItem (on le met epinglé si il ne l'était pas et inversement)
     */
    public void changePin() {
        this._pin = !_pin;
    }

    //--------------------------------------------Id------------------------------------------------------
    /**
     *     Permet de recuperer l'id du SubItem
     * @return
     */
    public int getId() {
        return this._id;
    }

    //-----------------------------------------Location------------------------------------------------------
    /**
     *     Permet de recuperer la localisation du SubItem
     * @return
     */
    public Folder getLocation() {
        return this._location;
    }

    /**
     *      Permet de changer la localisation du SubItem
     * @param location
     */
    public void setLocation(Folder location) {
        this._location = location;
    }

    //-----------------------------------------TypeSubItem--------------------------------------------------
    /**
     *     Permet de recuperer le type du SubItem
     * @return
     */
    public String getTypeSubItem() {
        return this._typeSubItem;
    }

    //--------------------------------------------Date------------------------------------------------------
    /**
     *     Permet de recuperer la date du SubItem
     * @return
     */
    public Date getDate() {
        return this._date;
    }

    /**
     *     Permet de definir une nouvelle date au SubItem
     */
    public void set_date() {
        this._date = new Date();
    }

    //-----------------------------------------Comparator------------------------------------------------------
    /**
     *     Comparateur pour le tri des dossier (on compare le nom ou le type) --> Important de comparer outre les majuscules
     */
    public static Comparator<SubItem> ComparatorName = Comparator.comparing(o -> o.getName().toUpperCase());

    public static Comparator<SubItem> ComparatorType = Comparator.comparing(o -> o.getTypeSubItem().toUpperCase());

}
