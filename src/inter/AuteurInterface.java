package inter;

import bean.Auteur;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AuteurInterface extends Remote {
     public Auteur findByNom(String nom) throws Exception,RemoteException;
}
