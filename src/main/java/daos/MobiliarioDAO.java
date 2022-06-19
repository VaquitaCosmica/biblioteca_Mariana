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
import modelos.Autor;
import modelos.Mobiliario;
import modelos.Usuario;

public class MobiliarioDAO {

    private DataSource mDataSource;

    public MobiliarioDAO() {
    }

    public MobiliarioDAO(DataSource datasource) {
        //super();
        this.mDataSource = datasource;
    }

    // Añadir un nuevo MOBILIARIO
    public void crear(Mobiliario mobiiliario) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();

        try {
            ps = conexion.prepareStatement("INSERT INTO mobiliario VALUES(?,?,?)");
            ps.setString(1, mobiiliario.getId_mobiliario());
            ps.setString(2, mobiiliario.getNombre());
            ps.setInt(3, mobiiliario.getCantidad());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encotrar todo el mobiliario
    public List<Mobiliario> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Mobiliario mobiliario = null;
        ResultSet res;
        List<Mobiliario> mobiliarios = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from mobiliario");
            res = ps.executeQuery();
            while (res.next()) {
                mobiliario = new Mobiliario();
                mobiliario.setId_mobiliario(res.getString("id_mobiliario"));
                mobiliario.setCantidad(res.getInt("cantidad"));
                mobiliario.setNombre(res.getString("nombre"));
                mobiliarios.add(mobiliario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MobiliarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mobiliarios;
    }

    // Buscar un mobiliario por id
    public Mobiliario busqueda_porId(String Id) throws SQLException {
        PreparedStatement ps;
        Mobiliario mobiliario = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from mobiliario WHERE id_mobiliario = ?");
            ps.setString(1, Id);
            res = ps.executeQuery();
            if (res.next()) {
                mobiliario = new Mobiliario();
                mobiliario.setId_mobiliario(res.getString("id_mobiliario"));
                mobiliario.setNombre(res.getString("nombre"));
                mobiliario.setCantidad(res.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mobiliario;
    }

    /*
    // Buscar un usuario por nombre
    public Mobiliario busqueda_porNombre(String nombre) throws SQLException {
        PreparedStatement ps;
        Mobiliario mobiliario = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from mobiliario WHERE id_mobiliario = ?");
            ps.setString(1, nombre);
            res = ps.executeQuery();
            if (res.next()) {
                mobiliario = new Mobiliario();
                mobiliario.setId_mobiliario(res.getString("id_mobiliario"));
                mobiliario.setNombre(res.getString("nombre"));
                mobiliario.setCantidad(res.getInt("cantidad"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mobiliario;
    }*/
    // Actualizar datos del mobiliario
    public void actualizar(Mobiliario mobiliario, String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE mobiliario SET nombre = ?, cantidad = ?, id_mobiliario = ? WHERE id_mobiliario = ?");
            ps.setString(1, mobiliario.getNombre());
            ps.setInt(2, mobiliario.getCantidad());
            ps.setString(3, mobiliario.getId_mobiliario());
            ps.setString(4, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar MOBILIARIO
    public void eliminar(String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM mobiliario WHERE id_mobiliario = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
