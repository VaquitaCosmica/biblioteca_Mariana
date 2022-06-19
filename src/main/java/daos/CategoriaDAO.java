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

public class CategoriaDAO {
    
    private DataSource mDataSource;
    
    public CategoriaDAO() {
    }
    
    public CategoriaDAO(DataSource datasource) {
        this.mDataSource = datasource;
    }

    // Encotrar todas las categorias de libros
    public List<Categoria> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Categoria categoria = null;
        ResultSet res;
        List<Categoria> categorias = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from categoria");
            res = ps.executeQuery();
            while (res.next()) {
                categoria = new Categoria();
                categoria.setId_categoria(res.getString("categoria"));
                categorias.add(categoria);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return categorias;
    }
}
