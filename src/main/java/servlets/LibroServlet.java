package servlets;

import daos.AutorDAO;
import daos.CategoriaDAO;
import daos.EditorialDAO;
import daos.LibroDAO;
import daos.UsuarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modelos.Autor;
import modelos.Categoria;
import modelos.Editorial;
import modelos.Libro;
import modelos.Usuario;

@WebServlet(name = "LibroServlet", urlPatterns = {"/LibroServlet"})
public class LibroServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private UsuarioDAO mUsuarioDAO;
    private LibroDAO mLibroDAO;
    private AutorDAO mAutorDAO;
    private CategoriaDAO mCategoriaDAO;
    private EditorialDAO mEditorialDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "PRECREAR":
                    System.out.println("ESTOY EN PREECREAR LIBROOOOO");
                    mAutorDAO = new AutorDAO(mPoolConexionesBD);
                    mCategoriaDAO = new CategoriaDAO(mPoolConexionesBD);
                    mEditorialDAO = new EditorialDAO(mPoolConexionesBD);
                    try {
                        request.setAttribute("permiso", "true");
                        List<Autor> autores = mAutorDAO.encontrarTodos();
                        request.setAttribute("autores", autores);
                        List<Categoria> categorias = mCategoriaDAO.encontrarTodos();
                        request.setAttribute("categorias", categorias);
                        List<Editorial> editoriales = mEditorialDAO.encontrarTodos();
                        request.setAttribute("editoriales", editoriales);
                        request.getRequestDispatcher("crearLibro.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "CREAR":
                    System.out.println("ESTOY EN CREAR LIBROOOOO");
                    mLibroDAO = new LibroDAO(mPoolConexionesBD);
                    Libro nuevoLibro = new Libro();
                    nuevoLibro.setAutor(request.getParameter("autor"));
                    nuevoLibro.setTitulo(request.getParameter("titulo"));
                    nuevoLibro.setIdioma(request.getParameter("idioma"));
                    nuevoLibro.setId_libro(request.getParameter("id"));
                    nuevoLibro.setEditorial(request.getParameter("editorial"));
                    nuevoLibro.setCategoria(request.getParameter("categoria"));
                    nuevoLibro.setAnaquel(Integer.parseInt(request.getParameter("anaquel")));
                    nuevoLibro.setPaginas(Integer.parseInt(request.getParameter("paginas")));
                    nuevoLibro.setAño(Integer.parseInt(request.getParameter("anio")));
                    try {
                        mLibroDAO.crear(nuevoLibro);
                        List<Libro> libros = mLibroDAO.encontrarTodos();
                        request.setAttribute("libros", libros);
                        request.getRequestDispatcher("Libro.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    System.out.println("ESTOY EN PREEACTUALIZAR LIBROOOOO");
                    mLibroDAO = new LibroDAO(mPoolConexionesBD);
                    mAutorDAO = new AutorDAO(mPoolConexionesBD);
                    mCategoriaDAO = new CategoriaDAO(mPoolConexionesBD);
                    mEditorialDAO = new EditorialDAO(mPoolConexionesBD);

                    request.setAttribute("autor", request.getParameter("autor"));
                    request.setAttribute("titulo", request.getParameter("titulo"));
                    request.setAttribute("idioma", request.getParameter("idioma"));
                    request.setAttribute("id", request.getParameter("id"));
                    request.setAttribute("editorial", request.getParameter("editorial"));
                    request.setAttribute("categoria", request.getParameter("categoria"));
                    request.setAttribute("anaquel", request.getParameter("anaquel"));
                    request.setAttribute("paginas", request.getParameter("paginas"));
                    request.setAttribute("autor", request.getParameter("autor"));
                    request.setAttribute("anio", request.getParameter("anio"));

                    try {
                        List<Autor> autores = mAutorDAO.encontrarTodos();
                        request.setAttribute("autores", autores);
                        List<Categoria> categorias = mCategoriaDAO.encontrarTodos();
                        request.setAttribute("categorias", categorias);
                        List<Editorial> editoriales = mEditorialDAO.encontrarTodos();
                        request.setAttribute("editoriales", editoriales);
                        request.getRequestDispatcher("actualizarLibro.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ACTUALIZAR":
                    System.out.println("ESTOY EN ACTUALIZAR LIBROOOOO");
                    mLibroDAO = new LibroDAO(mPoolConexionesBD);
                    Libro libro = new Libro();
                    libro.setAutor(request.getParameter("autor"));
                    libro.setTitulo(request.getParameter("titulo"));
                    libro.setIdioma(request.getParameter("idioma"));
                    libro.setId_libro(request.getParameter("id"));
                    libro.setEditorial(request.getParameter("editorial"));
                    libro.setCategoria(request.getParameter("categoria"));
                    libro.setAnaquel(Integer.parseInt(request.getParameter("anaquel")));
                    libro.setPaginas(Integer.parseInt(request.getParameter("paginas")));
                    libro.setAño(Integer.parseInt(request.getParameter("anio")));
                    try {
                        mLibroDAO.actualizar(libro, request.getParameter("antiguoId"));
                        List<Libro> libros = mLibroDAO.encontrarTodos();
                        request.setAttribute("libros", libros);
                        request.getRequestDispatcher("Libro.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    String id = (String) request.getParameter("id");
                    if (id != null && !id.isEmpty()) {
                        mLibroDAO = new LibroDAO(mPoolConexionesBD);
                        try {
                            mLibroDAO.eliminar(id);
                            List<Libro> libros = mLibroDAO.encontrarTodos();
                            request.setAttribute("libros", libros);
                        } catch (SQLException e) {
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
                        }
                        request.getRequestDispatcher("Libro.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
