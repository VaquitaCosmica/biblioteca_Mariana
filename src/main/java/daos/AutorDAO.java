package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import javax.sql.DataSource;
import java.util.logging.Logger;
import modelos.Autor;

public class AutorDAO {

    private DataSource mDataSource;

    public AutorDAO() {
    }

    public AutorDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Encotrar todos los autores
    public List<Autor> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Autor autor = null;
        ResultSet res;
        List<Autor> autores = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from autor");
            res = ps.executeQuery();
            while (res.next()) {
                autor = new Autor();
                autor.setNombre(res.getString("nombre"));
                autor.setId_Autor(res.getString("id_autor"));
                autores.add(autor);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return autores;
    }

    // Añadir nuevo autor
    public void crear(Autor autor) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO autor VALUES(?,?)");
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getId_Autor());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Actualizar datos del autor
    public void actualizar(Autor autor, String id) throws SQLException {
        System.out.println("ESTOY EN DAO ACTUALIZAR autor, parametro id_autor: " + autor.getId_Autor()
                + " nombre: " + autor.getNombre() + " idAntiguo: " + id);
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE autor SET nombre = ?,id_autor = ?  WHERE id_autor = ?");
            ps.setString(1, autor.getNombre());
            ps.setString(2, autor.getId_Autor());
            ps.setString(3, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AutorDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar autor
    public void eliminar(String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM autor WHERE id_autor = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
