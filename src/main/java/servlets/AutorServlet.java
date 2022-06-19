package servlets;

import daos.AutorDAO;
import daos.CategoriaDAO;
import daos.EditorialDAO;
import daos.LibroDAO;
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

@WebServlet(name = "AutorServlet", urlPatterns = {"/AutorServlet"})
public class AutorServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private AutorDAO mAutorDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTOY EN SERVLET AUTOR");
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "CREAR":
                    System.out.println("ESTOY EN CREAR autor, parametro id_autor: " + request.getParameter("id_autor")
                            + " nombre: " + request.getParameter("nombre"));
                    mAutorDAO = new AutorDAO(mPoolConexionesBD);
                    Autor nuevo_autor = new Autor();
                    nuevo_autor.setId_Autor(request.getParameter("id_autor"));
                    nuevo_autor.setNombre(request.getParameter("nombre"));
                    try {
                        mAutorDAO.crear(nuevo_autor);
                        List<Autor> autores = mAutorDAO.encontrarTodos();
                        request.setAttribute("autores", autores);
                        request.getRequestDispatcher("Autor.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    mAutorDAO = new AutorDAO(mPoolConexionesBD);
                    request.setAttribute("id_autor", request.getParameter("id_autor"));
                    request.setAttribute("nombre", request.getParameter("nombre"));
                    request.getRequestDispatcher("actualizarAutor.jsp").forward(request, response);
                    break;
                case "ACTUALIZAR":
                    mAutorDAO = new AutorDAO(mPoolConexionesBD);
                    Autor autor = new Autor();
                    autor.setId_Autor(request.getParameter("id_autor"));
                    autor.setNombre(request.getParameter("nombre"));
                    try {
                        mAutorDAO.actualizar(autor, request.getParameter("antiguoId"));
                        List<Autor> autores = mAutorDAO.encontrarTodos();
                        request.setAttribute("autores", autores);
                        request.getRequestDispatcher("Autor.jsp").forward(request, response);
                        //    request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    String id = (String) request.getParameter("id_autor");
                    if (id != null && !id.isEmpty()) {
                        mAutorDAO = new AutorDAO(mPoolConexionesBD);
                        try {
                            mAutorDAO.eliminar(id);
                            List<Autor> autores = mAutorDAO.encontrarTodos();
                            request.setAttribute("autores", autores);
                        } catch (SQLException e) {
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
                        }
                        request.getRequestDispatcher("Autor.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }
                    break;
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
