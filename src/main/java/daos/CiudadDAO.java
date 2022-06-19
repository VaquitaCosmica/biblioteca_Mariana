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
import modelos.Ciudad;

public class CiudadDAO {
    
    private DataSource mDataSource;
    
    public CiudadDAO() {
    }
    
    public CiudadDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Encotrar todas las ciudades
    public List<Ciudad> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Ciudad ciudad = null;
        ResultSet res;
        List<Ciudad> ciudades = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from ciudad");
            res = ps.executeQuery();
            while (res.next()) {
                ciudad = new Ciudad();
                ciudad.setCiudad_ID(res.getString("ciudad_id"));
                ciudad.setNombre(res.getString("nombre"));
                ciudades.add(ciudad);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ciudades;
    }
    
}
