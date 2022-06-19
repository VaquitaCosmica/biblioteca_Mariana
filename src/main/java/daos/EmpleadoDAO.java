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
import modelos.Editorial;
import modelos.Empleado;
import modelos.Libro;

public class EmpleadoDAO {

    private DataSource mDataSource;

    public EmpleadoDAO() {
    }

    public EmpleadoDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Añadir un nuevo Empleado
    public void crear(Empleado empleado) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO empleado (nombre, ape_pat, ape_mat, f_nacimiento, calle, numero, colonia, telefono, ciudad_id, user,ID_empleado) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApe_pat());
            ps.setString(3, empleado.getApe_mat());
            ps.setDate(4, (Date) empleado.getF_nacimiento());
            ps.setString(5, empleado.getCalle());
            ps.setInt(6, empleado.getNumero());
            ps.setString(7, empleado.getColonia());
            ps.setString(8, empleado.getTelefono());
            ps.setString(9, empleado.getCiudad_id());
            ps.setString(10, empleado.getUser());
            ps.setInt(11, empleado.getID_empleado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encotrar todos los empleados
    public List<Empleado> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Empleado empleado = null;
        ResultSet res;
        List<Empleado> empleados = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from empleado");
            res = ps.executeQuery();
            while (res.next()) {
                empleado = new Empleado();
                empleado.setID_empleado(res.getInt("ID_empleado"));
                empleado.setApe_mat(res.getString("ape_mat"));
                empleado.setApe_pat(res.getString("ape_pat"));
                empleado.setCalle(res.getString("calle"));
                empleado.setCiudad_id(res.getString("ciudad_id"));
                empleado.setColonia(res.getString("colonia"));
                empleado.setF_nacimiento(res.getDate("f_nacimiento"));
                empleado.setNombre(res.getString("nombre"));
                empleado.setNumero(res.getInt("numero"));
                empleado.setTelefono(res.getString("telefono"));
                empleado.setUser(res.getString("user"));
                empleados.add(empleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleados;
    }

    // Buscar un empleado por id
    public Empleado busqueda_porId(String id) throws SQLException {
        PreparedStatement ps;
        Empleado empleado = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from empleado WHERE ID_empleado = ?");
            ps.setString(1, id);
            res = ps.executeQuery();
            while (res.next()) {
                empleado.setApe_mat(res.getString("ape_mat"));
                empleado.setApe_pat(res.getString("ape_pat"));
                empleado.setCalle(res.getString("calle"));
                empleado.setCiudad_id(res.getString("ciudad_id"));
                empleado.setColonia(res.getString("colonia"));
                empleado.setF_nacimiento(res.getDate("f_nacimiento"));
                empleado.setNombre(res.getString("nombre"));
                empleado.setNumero(res.getInt("numero"));
                empleado.setTelefono(res.getString("telefono"));
                empleado.setUser(res.getString("user"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }

    // Actualizar datos del empleado
    public void actualizar(Empleado empleado, int id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE empleado SET nombre = ?, ape_pat = ?, ape_mat = ?, f_nacimiento = ?, calle = ?, numero = ?, colonia = ?, "
                    + "telefono = ?, ciudad_id = ?, user = ?, ID_empleado = ? WHERE ID_empleado = ?");
            ps.setString(1, empleado.getNombre());
            ps.setString(2, empleado.getApe_pat());
            ps.setString(3, empleado.getApe_mat());
            ps.setDate(4, (Date) empleado.getF_nacimiento());
            ps.setString(5, empleado.getCalle());
            ps.setInt(6, empleado.getNumero());
            ps.setString(7, empleado.getColonia());
            ps.setString(8, empleado.getTelefono());
            ps.setString(9, empleado.getCiudad_id());
            ps.setString(10, empleado.getUser());
            ps.setInt(11, empleado.getID_empleado());
            ps.setInt(12, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar empleado
    public void eliminar(int id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM empleado WHERE ID_empleado = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
