package com.company.samuel.models;

public class File extends SubItem {
    /**
     * un fichier comprend: un Text
     */
    private Text _content;
    //private List<Text> _content;

    /**
     *      Un fichier est un SubItem qui ne peut contenir qu'un seul element Text()
     *      Un fichier doit posseder une localisation
     */

    /**
     * Création d'un fichier sans nom (la localisation est obligatoire)
     * @param location
     */
    public File(Folder location) {
        /**
         *      On recupere le constructeur du SubItem pour le nom et la localisation
         *      Le nom par defaut est "file"
         */
        super("file", location);
        this._content = new Text();
        this._typeSubItem = "File";
    }

    /**
     * Création d'un fichier avec un nom
     * @param name
     * @param location
     */
    public File(String name, Folder location) {
        super(name, location);
        this._content = new Text();
        this._typeSubItem = "File";
    }

    //-----------------------------------------Contents--------------------------------------------------
    /**
     * Permet de recuperer le contenu (Text) d'un fichier
     * @return _content
     */
    public Text getContent() {
        return this._content;
    }

    /**
     * Permet de definir l'objet Text d'un fichier
     * @param text
     */
    public void setText(Text text) {
        this._content = text;
    }
}
