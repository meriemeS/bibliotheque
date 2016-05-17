
package bean;

import java.io.Serializable;

/**
 *
 * @author MERIEME SOUKRAT
 */
public class Categorie implements Serializable{
    private int id;
    private String lib;

    public Categorie(int id, String lib) {
        this.id = id;
        this.lib = lib;
    }
    public Categorie() {
    }

    public int getId() {
        return id;
    }

    public String getLib() {
        return lib;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLib(String lib) {
        this.lib = lib;
    }

    @Override
    public String toString() {
        return "Categorie{" + "id=" + id + ", lib=" + lib + '}';
    }

    

}
