package service;

import bean.Auteur;
import dao.AuteurDao;
import inter.AuteurInterface;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class AuteurService extends UnicastRemoteObject implements AuteurInterface {

    AuteurDao auteurDao = new AuteurDao();

    public AuteurService() throws RemoteException {
        super();
    }
    public Auteur findByNom(String nom) throws Exception,RemoteException{
        return auteurDao.findByNom(nom);
    }
}
