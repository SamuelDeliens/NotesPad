package com.company.samuel.models;

import java.io.*;
import java.io.File;

public class BlocNotes extends Folder {
     //Un BlocNote comprend: une poubelle
    private Trash _trash;

    /**
     *     Un blocNote n'a pas de dossier "maitre" et ne possede donc pas de localisation
     *     Un blocNote possede aussi une poubelle (différence avec les dossiers)
     */


    /**
     *      Creation de blocNote sans lui donner de nom
     */
    public BlocNotes() {
        /**
         *      On recupere le constructeur du Folder pour le nom et la localisation
         *      Le nom par defaut est "Mon Petit BlocNote d'Amour"
         */
        super("Mon Petit BlocNote d'Amour", null);
        this._trash = new Trash(this);
        this.add(_trash);
        this._typeSubItem = "BlocNotes";
    }

    /**
     * Creation de blocNote en fournissant un nom
     * @param name
     */
    public BlocNotes(String name) {
        super(name, null);
        this._trash = new Trash(this);
        this.add(_trash);
        this._typeSubItem = "BlocNotes";
    }

    //-----------------------------------------Trash------------------------------------------------------
    /**
     * recupere la poubelle du BlocNote
     * @return _trash
     */
    public Trash getTrash() {
        return this._trash;
    }

    //-----------------------------------------Save------------------------------------------------------
    /**
     *      Permet d'enregistrer un blocNote dans un fichier contenu dans le dossier data
     *      Le nom de fichier est crée par le nom du BlocNote sans espace
     *      Le fichier est un data/nomBlocNote.ser
     * @param blocNotes
     */
    public void save(BlocNotes blocNotes) {
        //On retire les espaces du nom du blocNote et on l'ajoute dans le path du dossier
        String path = "./data/"+blocNotes.getName().replaceAll("\\s","")+".ser";
        java.io.File data =  new File(path);
        try {
            //Si la création a pu s'effectuer
            ObjectOutputStream oos =  new ObjectOutputStream(new FileOutputStream(data));
            oos.writeObject(this) ;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //-----------------------------------------Recup------------------------------------------------------
    /**
     * Permet de recuperer les blocNotes (fichier) placé dans le repertoire data
     * @param fichierBlocNote
     * @return blocNotes / null
     */
    public BlocNotes recup(File fichierBlocNote) {
        java.io.File data =  fichierBlocNote;

        try {
            //Si la recuperation a pu s'effectuer
            ObjectInputStream ois =  new ObjectInputStream(new FileInputStream(data)) ;
            BlocNotes blocNotes = (BlocNotes) ois.readObject();

            //renvoie le blocNote contenu dans le fichier
            return blocNotes;

        } catch (IOException | ClassNotFoundException e) {
            //recuperation a echoué, on renvoie donc null
            return null;
        }
    }
}
