package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelos.Categoria;
import modelos.Editorial;
import modelos.Mobiliario;

public class EditorialDAO {

    private DataSource mDataSource;

    public EditorialDAO() {
    }

    public EditorialDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Añadir una nueva editorial
    public void crear(Editorial editorial) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO editorial VALUES(?,?)");
            ps.setString(1, editorial.getRazon_social());
            ps.setString(2, editorial.getNombre());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encotrar todas las editoriales
    public List<Editorial> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Editorial editorial = null;
        ResultSet res;
        List<Editorial> editoriales = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from editorial");
            res = ps.executeQuery();
            while (res.next()) {
                editorial = new Editorial();
                editorial.setNombre(res.getString("nombre"));
                editorial.setRazon_social(res.getString("razon_social"));
                editoriales.add(editorial);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return editoriales;
    }

    // Buscar una editorial por RazonSocial
    public Editorial busqueda_porId(String razonSocial) throws SQLException {
        PreparedStatement ps;
        Editorial editorial = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from editorial WHERE razon_social = ?");
            ps.setString(1, razonSocial);
            res = ps.executeQuery();
            if (res.next()) {
                editorial = new Editorial();
                editorial.setRazon_social(res.getString("razon_social"));
                editorial.setNombre(res.getString("nombre"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return editorial;
    }

    // Actualizar datos de la editorial
    public void actualizar(Editorial editorial) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE editorial SET nombre = ? WHERE razon_social = ?");
            ps.setString(1, editorial.getNombre());
            ps.setString(2, editorial.getRazon_social());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar editorial
    public void eliminar(Editorial editorial) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM editorial WHERE razon_social = ?");
            ps.setString(1, editorial.getRazon_social());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
