
package dao;

import bean.Client;
import java.sql.ResultSet;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoEngigne;

public class ClientDao extends AbstractDao<Client> {
            

    public ClientDao() {
        super(Client.class);
    }
    
    

    public int seConnecter(Client client){
        
        Client loadedClient = null;
        try {
            loadedClient = findByLogin(client.getLogin());
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(loadedClient!=null){
            if(loadedClient.getPassword().equals(client.getPassword())){
                
                return 2; 
            }
            return -1;
        }
        return -2;
    }
    
        public int Inscription(Client client){
            Client newClient = null;
       
        try {
            newClient = findByLogin(client.getLogin());
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(newClient!=null){
            
            return -1;
        }
            return 1;
        }
        
        public Client findByLogin(String login) throws Exception{
           String requette = "SELECT * FROM client WHERE login='" + login + "'";
           List<Client> list = load(requette);
        if (!list.isEmpty()) {
            return list.get(0);
        }
        return null;
            
        }
        
         public ResultSet findAll_rs(String id) throws Exception {
        String st = "SELECT * FROM client  WHERE id='" + id + "'";
        ResultSet rs = ConnectDB.load(st);
        return rs;
    }
    
}
