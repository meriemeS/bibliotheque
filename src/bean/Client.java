package bean;

import java.io.Serializable;

public class Client implements Serializable {
    private int id;
    private String login;
    private String nom;
    private String prenom;
    private String password;

    public Client(int id, String login, String nom, String prenom, String password) {
        this.id = id;
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }

    public Client(String login, String nom, String prenom, String password) {
        this.login = login;
        this.nom = nom;
        this.prenom = prenom;
        this.password = password;
    }

    public Client() {
    }
    

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getPassword() {
        return password;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setPassword(String password) {
        this.password = password;
    }
 
   
}
