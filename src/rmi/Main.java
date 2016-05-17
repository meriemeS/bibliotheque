
package rmi;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import service.AuteurService;
import service.CategorieService;
import service.LivreService;
import service.ClientService;

public class Main {
     public static void main(String[] args) throws MalformedURLException {
       try {
            
            LocateRegistry.createRegistry(1099);
            LivreService livreOD = new LivreService();
            ClientService userODD = new ClientService();
            AuteurService auteurOD = new AuteurService();
            Naming.rebind("AuteurStub", auteurOD);
            Naming.rebind("ClientServiceStub", userODD);
            Naming.rebind("livre", livreOD);
            ClientService userOD = new ClientService();
             Naming.rebind("ClientServiceStub2", userOD);
             CategorieService catOD = new CategorieService();
             Naming.rebind("CatServiceStub", catOD);
             AuteurService autOD = new AuteurService();
             Naming.rebind("AutServiceStub", autOD);
            System.out.println("L'objet distant (OD) est enregistre dans RMI ... serveur pret");
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }
}
