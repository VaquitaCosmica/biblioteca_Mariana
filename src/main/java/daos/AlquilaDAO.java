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
import modelos.Mobiliario;

public class AlquilaDAO {

    private DataSource mDataSource;

    public AlquilaDAO() {
    }

    public AlquilaDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Añadir una nueva relacion alquila
    public void crear(Alquila alquila) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO alquila VALUES(?,?,?,?,?,?)");
            ps.setString(1, alquila.getId_alquiler());
            ps.setDate(2, (Date) alquila.getF_salida());
            ps.setDate(3, (Date) alquila.getF_entrada());
            ps.setInt(4, alquila.getID_empleada());
            ps.setString(5, alquila.getId_libro());
            ps.setInt(6, alquila.getID_cliente());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AlquilaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encotrar todos los prestamos
    public List<Alquila> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Alquila prestamo = null;
        ResultSet res;
        List<Alquila> prestamos = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from alquila");
            res = ps.executeQuery();
            while (res.next()) {
                prestamo = new Alquila();
                prestamo.setF_entrada(res.getDate("f_entrada"));
                prestamo.setF_salida(res.getDate("f_salida"));
                prestamo.setID_cliente(res.getInt("ID_cliente"));
                prestamo.setID_empleada(res.getInt("ID_empleado"));
                prestamo.setId_alquiler(res.getString("id_alquiler"));
                prestamo.setId_libro(res.getString("id_libro"));
                prestamos.add(prestamo);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MobiliarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prestamos;
    }

    // Actualizar datos de alquiler
    public void actualizar(Alquila alquiler, String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE alquila SET f_salida = ?, f_entrada = ?, ID_empleado = ?, "
                    + "id_libro = ?, ID_cliente = ?, id_alquiler = ? WHERE id_alquiler = ?");
            ps.setDate(1, (Date) alquiler.getF_salida());
            ps.setDate(2, (Date) alquiler.getF_entrada());
            ps.setInt(3, alquiler.getID_empleada());
            ps.setString(4, alquiler.getId_libro());
            ps.setInt(5, alquiler.getID_cliente());
            ps.setString(6, alquiler.getId_alquiler());
            ps.setString(7, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar relacion alquiler
    public void eliminar(String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM alquila WHERE id_alquiler = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(AlquilaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
