
package bean;

import java.io.Serializable;


public class Livre implements Serializable{
    
    private int id;
    private String titre;
    private int id_aut;
    private int id_cat;
    private String description;
     private byte[] Image;

  

    public Livre(int id, String titre, int id_aut, int id_cat, String description, byte[] Image) {
        this.id = id;
        this.titre = titre;
        this.id_aut = id_aut;
        this.id_cat = id_cat;
        this.description = description;
        this.Image = Image;
    }

     public byte[] getImage() {
        return Image;
    }

    public void setImage(byte[] Image) {
        this.Image = Image;
    }
     


  
    public Livre() {

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

    @Override
    public String toString() {
        return "Livre{" + "id=" + id + ", titre=" + titre + ", id_aut=" + id_aut + ", id_cat=" + id_cat + ", description=" + description + '}';
    }

   
   
    
    
}
