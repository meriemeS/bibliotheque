
package service;

import bean.Livre;
import dao.LivreDao;
import dao.ClientDao;
import inter.LivreInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;


public class LivreService extends UnicastRemoteObject implements LivreInterface {
     LivreDao  livreDao = new LivreDao();

    public LivreService() throws RemoteException {
        super();
    }
    
     @Override
     public List<Livre> findAll() throws Exception, RemoteException{
          return livreDao.findAll();
     }
          public Livre findById(int id) throws Exception ,RemoteException{
         return livreDao.findById(id);
              
          }
   public byte[]  setImage(int id) throws Exception,RemoteException {
//       
//        ResultSet rs=livreDao.findById_forimage(id);
//        if(rs.next()){
//         byte[] img = rs.getBytes("image");
//         return img;
//       }
         return null;
    }
   
    public ArrayList<Livre> BindTable() throws  RemoteException {
        return livreDao.BindTable();
    }
}
