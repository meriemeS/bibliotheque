package service;

import bean.Livre;
import com.healthmarketscience.rmiio.RemoteInputStream;
import com.healthmarketscience.rmiio.RemoteInputStreamClient;
import dao.LivreDao;
import dao.ClientDao;
import inter.LivreInterface;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class LivreService extends UnicastRemoteObject implements LivreInterface {

    LivreDao livreDao = new LivreDao();

    public LivreService() throws RemoteException {
        super();
    }

    @Override
    public List<Livre> findAll() throws Exception, RemoteException {
        return livreDao.findAll();
    }

    public Livre findById(int id) throws Exception, RemoteException {
        return livreDao.findById(id);

    }

    public byte[] setImage(int id) throws Exception, RemoteException {
//       
//        ResultSet rs=livreDao.findById_forimage(id);
//        if(rs.next()){
//         byte[] img = rs.getBytes("image");
//         return img;
//       }
        return null;
    }

//    public ArrayList<Livre> BindTable() throws  RemoteException {
//        return livreDao.BindTable();
//    }
    @Override
    public List<Livre> findByCat(int id_cat) throws Exception, RemoteException {
        return livreDao.findByCat(id_cat);
    }

    @Override
    public List<Livre> findByAut(int id_aut) throws Exception, RemoteException {
        return livreDao.findByAut(id_aut);
    }

    @Override
    public ArrayList<Livre> findAll_2() throws Exception, RemoteException {
        return livreDao.findAll_2();
    }

    @Override
    public List<Livre> findByTitre(String titre) throws Exception, RemoteException {
        return livreDao.findByTitre(titre);
    }

    @Override
    public void uploadFile(RemoteInputStream ristream) throws IOException, RemoteException {
        System.out.println("hello");
        InputStream istream = RemoteInputStreamClient.wrap(ristream);
        FileOutputStream ostream = null;
        try {

            File tempFile = File.createTempFile("sentFile_", ".dat");
            ostream = new FileOutputStream(tempFile);
            System.out.println("Writing file " + tempFile);

            byte[] buf = new byte[1024];

            int bytesRead = 0;
            while ((bytesRead = istream.read(buf)) >= 0) {
                ostream.write(buf, 0, bytesRead);
                
            }
            
            
            ostream.flush();

            System.out.println("Finished writing file " + tempFile);
            

        } finally {
            try {
                if (istream != null) {
                    istream.close();
                }
            } finally {
                if (ostream != null) {
                    ostream.close();
                }
            }
        }
    }
    
    @Override
       public Object getListe() throws RemoteException {
           return livreDao.getListe();
       }
       
    @Override
        public int save_byNames(Livre l) throws Exception,RemoteException{
            return livreDao.save_byNames(l);
        }
        
        @Override
    public int save(Livre livre) throws Exception, RemoteException {
        return livreDao.save(livre);
    }

}
