package daos;

import modelos.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;
import modelos.Ciudad;
import org.apache.commons.codec.digest.DigestUtils;

public class UsuarioDAO {

    private DataSource mDataSource;

    public UsuarioDAO() {
    }

    public UsuarioDAO(DataSource datasource) {
        //super();
        this.mDataSource = datasource;
    }

    // Añadir un nuevo usuario
    public void crear(Usuario usuario) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();

        try {
            ps = conexion.prepareStatement("INSERT INTO usuario VALUES(?,?)");
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar un usuario que tenga el mismo nombre y password que las puestas en inicio de sesion
    public Usuario busqueda_porCredenciales(String nombre_usuario, String password) throws SQLException {
        PreparedStatement ps;
        Usuario usuario = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from usuario WHERE user = ? AND contraseña = ?");
            ps.setString(1, nombre_usuario);
            ps.setString(2, password);
            res = ps.executeQuery();
            if (res.next()) {
                usuario = new Usuario();
                usuario.setUser(res.getString("user"));
                usuario.setPassword(res.getString("contraseña"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    // Buscar un usuario que tenga el mismo nombre que el dado.
    public Usuario busqueda_porId(String user) throws SQLException {
        PreparedStatement ps;
        Usuario usuario = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from usuario WHERE user = ?");
            ps.setString(1, user);
            res = ps.executeQuery();
            if (res.next()) {
                usuario = new Usuario();
                usuario.setUser(res.getString("user"));
                usuario.setPassword(res.getString("contraseña"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    // Encotrar todos los usuarios
    public List<Usuario> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Usuario usuario = null;
        ResultSet res;
        List<Usuario> usuarios = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from usuario");
            res = ps.executeQuery();
            while (res.next()) {
                usuario = new Usuario();
                usuario.setUser(res.getString("user"));
                usuario.setPassword(res.getString("contraseña"));
                usuarios.add(usuario);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuarios;
    }


    // Actualizar datos del usuario
    public void actualizar(Usuario usuario, String antiguoID) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE usuario SET contraseña = ?, user = ? WHERE user = ?");
            ps.setString(1, DigestUtils.md5Hex(usuario.getPassword()));
            ps.setString(2, usuario.getUser());
            ps.setString(3, antiguoID);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar usuario
    public void eliminar(String usuario) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM usuario WHERE user = ?");
            ps.setString(1, usuario);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}