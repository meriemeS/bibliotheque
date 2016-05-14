
package dao;

import bean.Client;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClientDao extends AbstractDao<Client> {
            

    public ClientDao() {
        super(Client.class);
    }
    
    

    public int seConnecter(Client client){
        
        Client loadedClient = null;
        try {
            loadedClient = findById(client.getId());
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(loadedClient!=null){
            if(loadedClient.getPassword().equals(client.getPassword())){
                
                return 2; // pass ok login ok mais blocked
            }
            return -1;
        }
        return -2;
    }
    
        public int Inscription(Client client){
            Client newClient = null;
       
        try {
            newClient = findById(client.getId());
        } catch (Exception ex) {
            Logger.getLogger(ClientDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(newClient!=null){
            
            return -1;
        }
            return 1;
        }
        
        
         public ResultSet findAll_rs(String id) throws Exception {
        String st = "SELECT * FROM client  WHERE id='" + id + "'";
        ResultSet rs = ConnectDB.load(st);
        return rs;
    }
    
}
