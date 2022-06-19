package servlets;

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
import modelos.Usuario;
import modelos.UsuarioDAOPrueba;
import org.apache.commons.codec.digest.DigestUtils;

@WebServlet(name = ""
        + ""
        + "", urlPatterns = {"/ServletBiblioteca"})
public class ServletBiblioteca extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private UsuarioDAO mUsuarioDAO;

    @Override
    public void init() throws ServletException {
        super.init();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // REGISTRAR USUARIO

        String esRegistro = request.getParameter("esRegistro");
        System.out.println("esRegistro: " + esRegistro);
        if (request.getParameter("usuario") != null && request.getParameter("contrasena") != null) {
            Usuario a = new Usuario(request.getParameter("usuario"), request.getParameter("contrasena"));
            mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
            try {
                mUsuarioDAO.crear(a);
                if (esRegistro.equals("true")) {
                    request.getRequestDispatcher("login.jsp").forward(request, response);
                }
                if (esRegistro.equals("false")) {
                    List<Usuario> datos = mUsuarioDAO.encontrarTodos();
                    request.setAttribute("users", datos);
                    request.getRequestDispatcher("Usuario.jsp").forward(request, response);
                    //request.getRequestDispatcher("menu.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // AUTENTICACION
        if (request.getParameter("usuario") != null && request.getParameter("contrasena") != null) {
            UsuarioDAO mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
            try {
                Usuario USUARIO = mUsuarioDAO.busqueda_porCredenciales(request.getParameter("usuario"), DigestUtils.md5Hex(request.getParameter("contrasena")));
                //         Usuario USUARIO = mUsuarioDAO.busqueda_porCredenciales(request.getParameter("usuario"), request.getParameter("contrasena"));
                if (USUARIO == null) {
                    response.sendRedirect("index.jsp");
                } else {
                    //response.sendRedirect("Usuario.jsp");
                    //cuando autenticación sí funciona
                    List<Usuario> datos = mUsuarioDAO.encontrarTodos();
                    System.out.println("MIRAAAAAAAAAA:" + datos.get(0).getUser());
                    request.setAttribute("users", datos);
                    request.getRequestDispatcher("menu.jsp").forward(request, response);
                }
            } catch (SQLException e) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Hace las operaciones de crear y autenticar usuario";
    }
}
