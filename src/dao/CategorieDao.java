
package dao;

import bean.Categorie;
import java.util.List;

public class CategorieDao extends AbstractDao<Categorie>{
    
    public CategorieDao() {
        super(Categorie.class);
    }
    
    public Categorie findByLib(String lib) throws Exception {
         String requette = "SELECT * FROM categorie WHERE lib='" + lib + "'";
           List<Categorie> list = load(requette);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
    }
}
