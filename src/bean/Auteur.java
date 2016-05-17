
package bean;

import java.io.Serializable;

/**
 *
 * @author MERIEME SOUKRAT
 */
public class Auteur implements Serializable{
    private int id;
    private String nom;
    private String prenom;

    public Auteur(int id, String nom, String prenom) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
    }

    public Auteur() {
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    @Override
    public String toString() {
        return "Auteur{" + "id=" + id + ", nom=" + nom + ", prenom=" + prenom + '}';
    }

   
}
