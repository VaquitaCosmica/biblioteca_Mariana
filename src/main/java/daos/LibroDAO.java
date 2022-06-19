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
import modelos.Libro;
import modelos.Usuario;

public class LibroDAO {
    
    private DataSource mDataSource;
    
    public LibroDAO() {
    }
    
    public LibroDAO(DataSource datasource) {
        //super();
        this.mDataSource = datasource;
    }

    // Añadir un nuevo libro
    public void crear(Libro libro) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("INSERT INTO libro VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, libro.getId_libro());
            ps.setString(2, libro.getTitulo());
            ps.setString(3, libro.getCategoria());
            ps.setInt(4, libro.getAnaquel());
            ps.setString(5, libro.getIdioma());
            ps.setInt(6, libro.getPaginas());
            ps.setString(7, libro.getAutor());
            ps.setInt(8, libro.getAño());
            ps.setString(9, libro.getEditorial());
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Encotrar todos los libros
    public List<Libro> encontrarTodos() throws SQLException {
        PreparedStatement ps;
        Libro libro = null;
        ResultSet res;
        List<Libro> libros = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from libro");
            res = ps.executeQuery();
            while (res.next()) {
                libro = new Libro();
                libro.setId_libro(res.getString("id_libro"));
                libro.setAnaquel(res.getInt("anaquel"));
                libro.setAutor(res.getString("autor"));
                libro.setAño(res.getInt("anio"));
                libro.setTitulo(res.getString("titulo"));
                libro.setPaginas(res.getInt("paginas"));
                libro.setIdioma(res.getString("idioma"));
                libro.setEditorial(res.getString("editorial"));
                libro.setCategoria(res.getString("categoria"));
                libros.add(libro);
            }
        } catch (SQLException ex) {
            Logger.getLogger(EditorialDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    // Buscar un libro por id
    public Libro busqueda_porId(String id) throws SQLException {
        PreparedStatement ps;
        Libro libro = null;
        ResultSet res;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from libro WHERE id_libro = ?");
            ps.setString(1, id);
            res = ps.executeQuery();
            while (res.next()) {
                libro.setId_libro(res.getString("id_libro"));
                libro.setAnaquel(res.getInt("anaquel"));
                libro.setAutor(res.getString("autor"));
                libro.setAño(res.getInt("anio"));
                libro.setCategoria(res.getString("categoria"));
                libro.setEditorial(res.getString("editorial"));
                libro.setIdioma(res.getString("idioma"));
                libro.setPaginas(res.getInt("paginas"));
                libro.setTitulo(res.getString("titulo"));
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libro;
    }

    // Buscar una lista de libros por titulo
    public List<Libro> busqueda_porTitulo(String titulo) throws SQLException {
        PreparedStatement ps;
        ResultSet res;
        List<Libro> libros = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from libro WHERE titulo = ?");
            ps.setString(1, titulo);
            res = ps.executeQuery();
            while (res.next()) {
                Libro libro = new Libro();
                libro.setId_libro(res.getString("id_libro"));
                libro.setAnaquel(res.getInt("anaquel"));
                libro.setAutor(res.getString("autor"));
                libro.setAño(res.getInt("anio"));
                libro.setCategoria(res.getString("categoria"));
                libro.setEditorial(res.getString("editorial"));
                libro.setIdioma(res.getString("idioma"));
                libro.setPaginas(res.getInt("paginas"));
                libro.setTitulo(res.getString("titulo"));
                libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    // Buscar una lista de libros por autor
    public List<Libro> busqueda_porAutor(String autor) throws SQLException {
        PreparedStatement ps;
        ResultSet res;
        List<Libro> libros = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from libro WHERE autor = ?");
            ps.setString(1, autor);
            res = ps.executeQuery();
            while (res.next()) {
                Libro libro = new Libro();
                libro.setId_libro(res.getString("id_libro"));
                libro.setAnaquel(res.getInt("anaquel"));
                libro.setAutor(res.getString("autor"));
                libro.setAño(res.getInt("anio"));
                libro.setCategoria(res.getString("categoria"));
                libro.setEditorial(res.getString("editorial"));
                libro.setIdioma(res.getString("idioma"));
                libro.setPaginas(res.getInt("paginas"));
                libro.setTitulo(res.getString("titulo"));
                libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    // Buscar una lista de libros por categoria
    public List<Libro> busqueda_porCategoria(String categoria) throws SQLException {
        PreparedStatement ps;
        ResultSet res;
        List<Libro> libros = new ArrayList<>();
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("SELECT * from libro WHERE categoria = ?");
            ps.setString(1, categoria);
            res = ps.executeQuery();
            while (res.next()) {
                Libro libro = new Libro();
                libro.setId_libro(res.getString("id_libro"));
                libro.setAnaquel(res.getInt("anaquel"));
                libro.setAutor(res.getString("autor"));
                libro.setAño(res.getInt("anio"));
                libro.setCategoria(res.getString("categoria"));
                libro.setEditorial(res.getString("editorial"));
                libro.setIdioma(res.getString("idioma"));
                libro.setPaginas(res.getInt("paginas"));
                libro.setTitulo(res.getString("titulo"));
                libros.add(libro);
            }
            ps.close();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return libros;
    }

    // Actualizar datos del libro
    public void actualizar(Libro libro, String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("UPDATE libro SET titulo = ?, categoria = ?, anaquel = ?, idioma = ?, paginas = ?, autor = ?, "
                    + "anio = ?, editorial = ?, id_libro = ? WHERE id_libro = ?");
            ps.setString(1, libro.getTitulo());
            ps.setString(2, libro.getCategoria());
            ps.setInt(3, libro.getAnaquel());
            ps.setString(4, libro.getIdioma());
            ps.setInt(5, libro.getPaginas());
            ps.setString(6, libro.getAutor());
            ps.setInt(7, libro.getAño());
            ps.setString(8, libro.getEditorial());
            ps.setString(9, libro.getId_libro());
            ps.setString(10, id);
            ps.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar libro
    public void eliminar(String id) throws SQLException {
        PreparedStatement ps;
        Connection conexion = mDataSource.getConnection();
        try {
            ps = conexion.prepareStatement("DELETE FROM libro WHERE id_libro = ?");
            ps.setString(1, id);
            ps.executeUpdate();
        } catch (Exception ex) {
            Logger.getLogger(LibroDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
