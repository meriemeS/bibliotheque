package dao;

import bean.Livre;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.DaoEngigne;

public class LivreDao extends AbstractDao<Livre> {

    public LivreDao() {
        super(Livre.class);
    }

    public ResultSet findAll_rs() throws Exception {
        String st = "SELECT * FROM livre";
        ResultSet rs = ConnectDB.load(st);
        return rs;
    }
       //fonction pour JTable qui va afficher les images
    public ArrayList<Livre> BindTable() {

        ArrayList<Livre> list = new ArrayList<Livre>();
        com.mysql.jdbc.Connection conn = ConnectDB.connectionFactory().getConn();
        Statement st;
        ResultSet rs;

        try {
            st = conn.createStatement();
            rs = st.executeQuery("SELECT `id`, `description`, `titre`, `id_aut`, `id_cat`, `image` FROM `livre`");
            

            Livre l;
            while (rs.next()) {
                l = new Livre(
                        rs.getInt("id"),
                        rs.getString("description"),
                        rs.getInt("id_aut"),
                        rs.getInt("id_cat"),
                        rs.getString("description"),
                        rs.getBytes("image")
                );
                list.add(l);
            }

        } catch (SQLException ex) {
            Logger.getLogger(LivreDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
}
