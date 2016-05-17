
package dao;

import bean.Auteur;
import java.util.List;

public class AuteurDao extends AbstractDao<Auteur>{
    
    public AuteurDao() {
        super(Auteur.class);
    }
    
    public Auteur findByNom(String nom) throws Exception {
         String requette = "SELECT * FROM auteur WHERE nom='" + nom + "'";
           List<Auteur> list = load(requette);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
