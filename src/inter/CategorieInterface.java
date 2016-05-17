/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import bean.Categorie;
import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author pc
 */
public interface CategorieInterface extends Remote {
     public Categorie findById(int id) throws Exception, RemoteException;
      public Categorie findByLib(String lib) throws Exception,RemoteException;
}
