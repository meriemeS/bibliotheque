/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import bean.Livre;
import dao.AuteurDao;
import dao.LivreDao;
import java.rmi.RemoteException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author pc
 */
public class test {
    public static void main(String[] args) throws RemoteException, Exception {
        LivreDao livre = new LivreDao();
        Livre l = new Livre("sense and sensibility","austen","jane","romance","beautiful novel");
       
        livre.save_byNames(l);
        
//        AuteurDao aut = new AuteurDao();
//        System.out.println(aut.findByNom("austen").getId());
//                
    }
}
