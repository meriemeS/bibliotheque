
package inter;

import bean.Livre;
import com.healthmarketscience.rmiio.RemoteInputStream;
import java.io.IOException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface LivreInterface extends Remote{
    public List<Livre> findAll() throws Exception, RemoteException;
     public Livre findById(int id) throws Exception ,RemoteException;
     public byte[]  setImage(int id) throws Exception,RemoteException;
//     public ArrayList<Livre> BindTable() throws  RemoteException ;
     public List<Livre> findByCat(int id_cat) throws Exception,RemoteException;
     public List<Livre> findByAut(int id_aut) throws Exception,RemoteException;
     public ArrayList<Livre> findAll_2() throws Exception,RemoteException;
     public List<Livre> findByTitre(String titre) throws Exception,RemoteException;
      public void uploadFile(RemoteInputStream remoteFileData) throws IOException,RemoteException;
      public Object getListe() throws RemoteException;
       public int save_byNames(Livre l) throws Exception,RemoteException;
       public int save(Livre livre) throws Exception, RemoteException ;
}
