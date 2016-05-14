
package inter;

import bean.Livre;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.List;

public interface LivreInterface extends Remote{
    public List<Livre> findAll() throws Exception, RemoteException;
     public Livre findById(int id) throws Exception ,RemoteException;
     public byte[]  setImage(int id) throws Exception,RemoteException;
     public ArrayList<Livre> BindTable() throws  RemoteException ;
}
