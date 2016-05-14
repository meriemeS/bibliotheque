package bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Client implements Serializable {

    private String id;
    private String nom;
    private String prenom;
    private String password;
    private byte[] image;
    List<Livre> livres = new ArrayList<Livre>();

    public byte[] getImage() {
        return image;
    }

    public List<Livre> getLivres() {
        return livres;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public void setLivres(List<Livre> livres) {
        this.livres = livres;
    }

    public Client() {
    }

 

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public List<Livre> getUsers() {
        return livres;
    }

    public void setUsers(List<Livre> livres) {
        this.livres = livres;
    }

}
