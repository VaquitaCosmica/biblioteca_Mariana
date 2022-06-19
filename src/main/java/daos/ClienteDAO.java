
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
import modelos.Cliente;
import modelos.Empleado;

public class ClienteDAO {
    
    private DataSource mDataSource;

    public ClienteDAO() {
    }

    public ClienteDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Añadir un nuevo Cliente
    public void crear(Cliente cliente) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO cliente (nombre, ape_pat, ape_mat, f_nacimiento, calle, numero, colonia, telefono, ciudad_id, ID_cliente, ocupacion) VALUES(?,?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApe_pat());
            ps.setString(3, cliente.getApe_mat());
            ps.setDate(4, (Date) cliente.getF_nacimiento());
            ps.setString(5, cliente.getCalle());
            ps.setInt(6, cliente.getNumero());
            ps.setString(7, cliente.getColonia());
            ps.setString(8, cliente.getTelefono());
            ps.setString(9, cliente.getCiudad_id());
            ps.setInt(10, cliente.getID_cliente());
            ps.setString(11, cliente.getOcupacion());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encotrar todos los clientes
    public List<Cliente> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Cliente cliente = null;
        ResultSet res;
        List<Cliente> clientes = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from cliente");
            res = ps.executeQuery();
            while (res.next()) {
                cliente = new Cliente();
                cliente.setID_cliente(res.getInt("ID_cliente"));
                cliente.setApe_mat(res.getString("ape_mat"));
                cliente.setApe_pat(res.getString("ape_pat"));
                cliente.setCalle(res.getString("calle"));
                cliente.setCiudad_id(res.getString("ciudad_id"));
                cliente.setColonia(res.getString("colonia"));
                cliente.setF_nacimiento(res.getDate("f_nacimiento"));
                cliente.setNombre(res.getString("nombre"));
                cliente.setNumero(res.getInt("numero"));
                cliente.setTelefono(res.getString("telefono"));
                cliente.setOcupacion(res.getString("ocupacion"));
                clientes.add(cliente);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EmpleadoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return clientes;
    }

   /* // Buscar un empleado por id
    public Cliente busqueda_porId(String id) throws SQLException {
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
                empleado.setTelefono(res.getInt("telefono"));
                empleado.setUser(res.getString("user"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return empleado;
    }*/

    // Actualizar datos del cliente
    public void actualizar(Cliente cliente, int id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE cliente SET nombre = ?, ape_pat = ?, ape_mat = ?, f_nacimiento = ?, calle = ?, numero = ?, colonia = ?, "
                    + "telefono = ?, ciudad_id = ?, ocupacion = ?, ID_cliente = ? WHERE ID_cliente = ?");
            ps.setString(1, cliente.getNombre());
            ps.setString(2, cliente.getApe_pat());
            ps.setString(3, cliente.getApe_mat());
            ps.setDate(4, (Date) cliente.getF_nacimiento());
            ps.setString(5, cliente.getCalle());
            ps.setInt(6, cliente.getNumero());
            ps.setString(7, cliente.getColonia());
            ps.setString(8, cliente.getTelefono());
            ps.setString(9, cliente.getCiudad_id());
            ps.setString(10, cliente.getOcupacion());
            ps.setInt(11, cliente.getID_cliente());
            ps.setInt(12, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar cliente
    public void eliminar(int id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM cliente WHERE ID_cliente = ?");
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
