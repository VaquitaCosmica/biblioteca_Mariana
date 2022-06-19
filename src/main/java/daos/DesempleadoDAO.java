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
import modelos.Desempleado;
import modelos.Empleado;
import modelos.Libro;

public class DesempleadoDAO {

    private DataSource mDataSource;

    public DesempleadoDAO() {
    }

    public DesempleadoDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Añadir un nuevo Empleado
    public void crear(Desempleado desempleado) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO desempleado (nombre, ape_pat, ape_mat, f_nacimiento, calle, numero, colonia, telefono, ciudad_id, user) VALUES(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, desempleado.getNombre());
            ps.setString(2, desempleado.getApe_pat());
            ps.setString(3, desempleado.getApe_mat());
            ps.setDate(4, (Date) desempleado.getF_nacimiento());
            ps.setString(5, desempleado.getCalle());
            ps.setInt(6, desempleado.getNumero());
            ps.setString(7, desempleado.getColonia());
            ps.setString(8, desempleado.getTelefono());
            ps.setString(9, desempleado.getCiudad_id());
            ps.setString(10, desempleado.getUser());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DesempleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    // Encotrar todos los empleados
    public List<Desempleado> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Desempleado desempleado = null;
        ResultSet res;
        List<Desempleado> desempleados = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from desempleado");
            res = ps.executeQuery();
            while (res.next()) {
                desempleado = new Desempleado();
                desempleado.setID_empleado(res.getInt("ID_empleado"));
                desempleado.setApe_mat(res.getString("ape_mat"));
                desempleado.setApe_pat(res.getString("ape_pat"));
                desempleado.setCalle(res.getString("calle"));
                desempleado.setCiudad_id(res.getString("ciudad_id"));
                desempleado.setColonia(res.getString("colonia"));
                desempleado.setF_nacimiento(res.getDate("f_nacimiento"));
                desempleado.setNombre(res.getString("nombre"));
                desempleado.setNumero(res.getInt("numero"));
                desempleado.setTelefono(res.getString("telefono"));
                desempleado.setUser(res.getString("user"));
                desempleados.add(desempleado);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DesempleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return desempleados;
    }

    // Buscar un empleado por id
    public Desempleado busqueda_porId(String id) throws SQLException {
        PreparedStatement ps;
        Desempleado empleado = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from desempleado WHERE ID_empleado = ?");
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
    public void actualizar(Desempleado desempleado) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE desempleado SET nombre = ?, ape_pat = ?, ape_mat = ?, f_nacimiento = ?, calle = ?, numero = ?, colonia = ?, "
                    + "telefono = ?, ciudad_id = ?, user = ? WHERE ID_empleado = ?");
            ps.setString(1, desempleado.getNombre());
            ps.setString(2, desempleado.getApe_pat());
            ps.setString(3, desempleado.getApe_mat());
            ps.setDate(4, (Date) desempleado.getF_nacimiento());
            ps.setString(5, desempleado.getCalle());
            ps.setInt(6, desempleado.getNumero());
            ps.setString(7, desempleado.getColonia());
            ps.setString(8, desempleado.getTelefono());
            ps.setString(9, desempleado.getCiudad_id());
            ps.setString(10, desempleado.getUser());
            ps.setInt(11, desempleado.getID_empleado());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar empleado
    public void eliminar(Desempleado desempleado) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM desempleado WHERE ID_empleado = ?");
            ps.setInt(1, desempleado.getID_empleado());
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}