/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inter;

import bean.Client;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

/**
 *
 * @author pc
 */
public interface ClientInterface extends Remote {

    public int seConnecter(Client user) throws RemoteException;

    public int save(Client t) throws Exception, RemoteException;

    public List<Client> findAll() throws Exception, RemoteException;

    public int Inscription(Client client) throws RemoteException;

    public Client findById(int id) throws Exception, RemoteException;
          public byte[]  getImage(String id) throws Exception,RemoteException;
           public Client findByLogin(String login) throws Exception,RemoteException;

}
