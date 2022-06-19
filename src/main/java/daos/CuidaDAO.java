package daos;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelos.Alquila;
import modelos.Cuida;
import modelos.Editorial;
import modelos.Libro;

public class CuidaDAO {

    private DataSource mDataSource;

    public CuidaDAO() {
    }

    public CuidaDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Añadir un nuevo cuidado
    public void crear(Cuida cuida) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO cuida VALUES(?,?,?,?)");
            ps.setString(1, cuida.getId_manto());
            ps.setDate(2, (Date) cuida.getF_manto());
            ps.setString(3, cuida.getId_mobiliario());
            ps.setInt(4, cuida.getID_empleado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encontrar todos los mantenimientos
    public List<Cuida> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Cuida cuidado = null;
        ResultSet res;
        List<Cuida> cuidados = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from cuida");
            res = ps.executeQuery();
            while (res.next()) {
                cuidado = new Cuida();
                cuidado.setF_manto(res.getDate("f_manto"));
                cuidado.setID_empleado(res.getInt("ID_empleado"));
                cuidado.setId_manto(res.getString("id_manto"));
                cuidado.setId_mobiliario(res.getString("id_mobiliario"));
                cuidados.add(cuidado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MobiliarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuidados;
    }

    // Buscar una editorial por mobiliario
    public List<Cuida> busqueda_porMobiliario(String id_mobiliario) throws SQLException {
        PreparedStatement ps;
        Cuida cuida = null;
        ResultSet res;
        List<Cuida> cuidados = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from cuida WHERE id_mobiliario = ?");
            ps.setString(1, id_mobiliario);
            res = ps.executeQuery();
            if (res.next()) {
                cuida = new Cuida();
                cuida.setF_manto(res.getDate("f_manto"));
                cuida.setID_empleado(res.getInt("ID_empleado"));
                cuida.setId_manto(res.getString("id_manto"));
                cuida.setId_mobiliario(res.getString("id_mobiliario"));
                cuidados.add(cuida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuidados;
    }

    // Buscar una editorial por empleado
    public List<Cuida> busqueda_porEmpleado(String id_empleado) throws SQLException {
        PreparedStatement ps;
        Cuida cuida = null;
        ResultSet res;
        List<Cuida> cuidados = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from cuida WHERE ID_empleado = ?");
            ps.setString(1, id_empleado);
            res = ps.executeQuery();
            if (res.next()) {
                cuida = new Cuida();
                cuida.setF_manto(res.getDate("f_manto"));
                cuida.setID_empleado(res.getInt("ID_empleado"));
                cuida.setId_manto(res.getString("id_manto"));
                cuida.setId_mobiliario(res.getString("id_mobiliario"));
                cuidados.add(cuida);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cuidados;
    }

    // Actualizar datos de la relacion cuida
    public void actualizar(Cuida cuida, String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE cuida SET f_manto = ?, id_mobiliario = ?, ID_empleado = ?, id_manto = ? WHERE id_manto = ?");
            ps.setDate(1, (Date) cuida.getF_manto());
            ps.setString(2, cuida.getId_mobiliario());
            ps.setInt(3, cuida.getID_empleado());
            ps.setString(4, cuida.getId_manto());
            ps.setString(5, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar relacion cuida
    public void eliminar(String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM cuida WHERE id_manto = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
