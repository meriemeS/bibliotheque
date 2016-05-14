
package service;



import dao.CategorieDao;
import inter.CategorieInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CategorieService extends UnicastRemoteObject implements CategorieInterface{
      CategorieDao categorieDao = new CategorieDao();

    public CategorieService() throws RemoteException {
        super();
    }
}
