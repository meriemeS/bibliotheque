
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import service.LivreService;
import service.ClientService;

public class Main {
     public static void main(String[] args) throws MalformedURLException {
       try {
            
            LocateRegistry.createRegistry(1099);
           
            ClientService userOD = new ClientService();
            LivreService livreOD = new LivreService();
            ClientService userODD = new ClientService();
            Naming.rebind("ClientServiceStub", userODD);
            Naming.rebind("UserServiceStub", userOD);
            Naming.rebind("LivreServiceStub", livreOD);
            System.out.println("L'objet distant (OD) est enregistre dans RMI ... serveur pret");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
