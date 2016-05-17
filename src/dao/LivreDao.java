package dao;

import bean.Auteur;
import bean.Categorie;
import bean.Livre;
import com.sun.pdfview.PDFFile;
import com.sun.pdfview.PDFPage;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.rmi.RemoteException;
import java.security.SecureRandom;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;


public class LivreDao extends AbstractDao<Livre> {

    public LivreDao() {
        super(Livre.class);
    }

    public ResultSet findAll_rs() throws Exception {
        String st = "SELECT * FROM livre";
        ResultSet rs = ConnectDB.load(st);
        return rs;
    }
//       fonction pour JTable qui va afficher les images
//    public ArrayList<Livre> BindTable() {
//
//        ArrayList<Livre> list = new ArrayList<Livre>();
//        com.mysql.jdbc.Connection conn = ConnectDB.connectionFactory().getConn();
//        Statement st;
//        ResultSet rs;
//
//        try {
//            st = conn.createStatement();
//            rs = st.executeQuery("SELECT `id`, `description`, `titre`, `id_aut`, `id_cat`, `image` FROM `livre`");
//            
//
//            Livre l;
//            while (rs.next()) {
//                l = new Livre(
//                        rs.getInt("id"),
//                        rs.getString("description"),
//                        rs.getInt("id_aut"),
//                        rs.getInt("id_cat"),
//                        rs.getString("description"),
//                        rs.getBytes("image")
//                );
//                list.add(l);
//            }
//
//        } catch (SQLException ex) {
//            Logger.getLogger(LivreDao.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return list;
//    }
    
    
    public List<Livre> findByCat(int id_cat) throws Exception{
         String st = "SELECT titre,nom,prenom,lib,description FROM livre,categorie,auteur WHERE livre.id_cat=categorie.id and livre.id_aut=auteur.id and id_cat = '" + id_cat + "'";
        ResultSet Rs = ConnectDB.load(st);
          List<Livre> list = new ArrayList<Livre>();
          while (Rs.next()) {              
              
         
            Livre livre = new Livre(
                 Rs.getString("titre"),
                 Rs.getString("nom"),
                 Rs.getString("prenom"),
                 Rs.getString("lib"),
                 Rs.getString("description")
                );
            
                 list.add(livre);
          }
        return list;
              
    }
    public List<Livre> findByAut(int id_aut) throws Exception{
         String st = "SELECT titre,nom,prenom,lib,description FROM livre,categorie,auteur WHERE livre.id_cat=categorie.id and livre.id_aut=auteur.id and id_aut='" + id_aut + "'";
          ResultSet Rs = ConnectDB.load(st);
          List<Livre> list = new ArrayList<Livre>();
          while (Rs.next()) {              
              
         
            Livre livre = new Livre(
                 Rs.getString("titre"),
                 Rs.getString("nom"),
                 Rs.getString("prenom"),
                 Rs.getString("lib"),
                 Rs.getString("description")
                );
            
                 list.add(livre);
          }
        return list;

    }
     public List<Livre> findByTitre(String titre) throws Exception{
         String requette = "SELECT * FROM livre WHERE titre ='" + titre + "'";
         return load(requette);

    }
    public ArrayList<Livre> findAll_2() throws Exception {
        String st = "SELECT titre,nom,prenom,lib,description FROM livre,auteur,categorie  WHERE livre.id_cat=categorie.id and livre.id_aut=auteur.id";
          ResultSet Rs = ConnectDB.load(st);
          ArrayList<Livre> list = new ArrayList<Livre>();
          while (Rs.next()) {              
              
         
            Livre livre = new Livre(
                 Rs.getString("titre"),
                 Rs.getString("nom"),
                 Rs.getString("prenom"),
                 Rs.getString("lib"),
                 Rs.getString("description")
                );
            
                 list.add(livre);
          }
        return list;
              
        
    }
    
       public Object getListe() throws RemoteException {
        
        ArrayList<Livre> L=new ArrayList<Livre>();
       
        Livre livre;
        try {
            String st = "SELECT * FROM livre";
            ResultSet Rs = ConnectDB.load(st);
             System.out.println("Rs ouii");
           ArrayList<ImageIcon> photos;
            ImageIcon imageIcon;
             while(Rs.next()){
                  photos=new ArrayList<ImageIcon>();
                 try {
            String sourceDir = Rs.getString("pdf");
            
            File sourceFile = new File(sourceDir);
            String fileName = sourceFile.getName().replace(".pdf", "");
            if (sourceFile.exists()) {
                RandomAccessFile raf = new RandomAccessFile(sourceFile, "r");
                FileChannel channel = raf.getChannel();
                ByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
                PDFFile pdf = new PDFFile(buf);
               
                for (int i = 0; i < pdf.getNumPages(); i++) {
                    PDFPage page = pdf.getPage(i);
                    // create the image
                   
                    Rectangle rect = new Rectangle(0, 0, (int) page.getBBox().getWidth(), (int) page.getBBox().getHeight());
                    BufferedImage bufferedImage = new BufferedImage(rect.width, rect.height, BufferedImage.TYPE_INT_RGB);
                    // image width, // image height, // clip rect, // null for the ImageObserver, // fill background with white, // block until drawing is done
                    Image image = page.getImage(rect.width, rect.height, rect, null, true, true );
                    Graphics2D bufImageGraphics = bufferedImage.createGraphics();
                    bufImageGraphics.drawImage(image, 0, 0, null);
                    imageIcon  = new ImageIcon(bufferedImage);
                   
                    photos.add(imageIcon);
                   
                } 
            } else {
                System.err.println(sourceFile.getName() +" File not exists");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
                livre= new Livre(
                 Rs.getInt("id"),
                 Rs.getString("titre"),
                 Rs.getInt("id_aut"),
                 Rs.getInt("id_cat"),
                 Rs.getString("pdf"),
                 Rs.getString("description"),
                 photos
                );
                 L.add(livre);
                 
              }
             
        } catch (SQLException ex) {
            Logger.getLogger(Livre.class.getName()).log(Level.SEVERE, null, ex);
        }
         
            
    return L;
        
    }
       
       public int save_byNames(Livre l) throws Exception{
           String titre = l.getTitre();
           String nom = l.getNom_aut();
           String prenom = l.getPrenom_aut();
           String lib = l.getLib_cat();
           String desc = l.getDescription();
           String pdf = l.getPdf();
           SecureRandom rand = new SecureRandom();
           int  n = rand.nextInt(50) + 1;

           
           AuteurDao aut = null;
           CategorieDao cat = null;
           LivreDao liv = null;
           
           
           if (aut.findByNom(nom).getNom() != null){
               Livre livre = new Livre(n,titre,aut.findByNom(nom).getId(),cat.findByLib(lib).getId(),"C:\\Users\\pc\\Documents\\NetBeansProjects\\Biblio\\src\\pdf\\"+titre+".pdf",desc);
               return liv.save(livre);
           } 
        return 0;

       }
       

}
