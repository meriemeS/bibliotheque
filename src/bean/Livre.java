
package bean;

import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.ImageIcon;


public class Livre implements Serializable{
    
    private int id;
    private String titre;
    private int id_aut;
    private int id_cat;
    private String description;
    private String pdf;
    ArrayList<ImageIcon> images;
    private String nom_aut;
    private String prenom_aut;
    private String lib_cat;

    public Livre(int id, String titre, int id_aut, int id_cat,  String pdf,String description, ArrayList<ImageIcon> images) {
        this.id = id;
        this.titre = titre;
        this.id_aut = id_aut;
        this.id_cat = id_cat;
        
        this.pdf = pdf;
        this.description = description;
        this.images = images;
    }

    public Livre(int id, String titre, int id_aut, int id_cat , String pdf, String description ) {
        this.id = id;
        this.titre = titre;
        this.id_aut = id_aut;
        this.id_cat = id_cat;
        
        this.pdf = pdf;
        this.description = description;
    }

    public Livre(String titre, String nom_aut, String prenom_aut, String lib_cat, String description) {
        this.titre = titre;
        
        this.nom_aut = nom_aut;
        this.prenom_aut = prenom_aut;
        this.lib_cat = lib_cat;
        this.description = description;
    }

    

    

    public Livre() {
    }
    
    

    public String getPdf() {
        return pdf;
    }

    public ArrayList<ImageIcon> getImages() {
        return images;
    }

    public void setPdf(String pdf) {
        this.pdf = pdf;
    }

    public void setImages(ArrayList<ImageIcon> images) {
        this.images = images;
    }

  

   
    public int getId() {
        return id;
    }

    public String getTitre() {
        return titre;
    }

    public int getId_aut() {
        return id_aut;
    }

    public int getId_cat() {
        return id_cat;
    }

    public String getDescription() {
        return description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setId_aut(int id_aut) {
        this.id_aut = id_aut;
    }

    public void setId_cat(int id_cat) {
        this.id_cat = id_cat;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNom_aut() {
        return nom_aut;
    }

    public String getPrenom_aut() {
        return prenom_aut;
    }

    public String getLib_cat() {
        return lib_cat;
    }

    public void setNom_aut(String nom_aut) {
        this.nom_aut = nom_aut;
    }

    public void setPrenom_aut(String prenom_aut) {
        this.prenom_aut = prenom_aut;
    }

    public void setLib_cat(String lib_cat) {
        this.lib_cat = lib_cat;
    }
  
    
}
