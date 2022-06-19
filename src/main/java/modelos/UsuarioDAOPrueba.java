package modelos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

public class UsuarioDAOPrueba  {

    private  DataSource mDataSource;

    public UsuarioDAOPrueba(DataSource datasource) {
        //super();
        this.mDataSource = datasource;
    }

    // Añadir un nuevo usuario
    public void crear(Usuario usuario) throws SQLException  {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();

        try {
            ps = conexion.prepareStatement("INSERT INTO usuario VALUES(?,?)");
            ps.setString(1, usuario.getUser());
            ps.setString(2, usuario.getPassword());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDAOPrueba.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public UsuarioDAOPrueba() {
    }

}
