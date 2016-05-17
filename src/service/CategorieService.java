
package service;



import bean.Categorie;
import dao.CategorieDao;
import inter.CategorieInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CategorieService extends UnicastRemoteObject implements CategorieInterface{
      CategorieDao categorieDao = new CategorieDao();

    public CategorieService() throws RemoteException {
        super();
    }
    public Categorie findById(int id) throws Exception, RemoteException{
        return categorieDao.findById(id);
    }
    public Categorie findByLib(String lib) throws Exception,RemoteException{
        return categorieDao.findByLib(lib);
    }
}
