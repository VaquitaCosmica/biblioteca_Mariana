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

@WebServlet(name = "UsuarioServlet", urlPatterns = {"/UsuarioServlet"})
public class UsuarioServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private UsuarioDAO mUsuarioDAO;

    // Actualizar usuario
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = (String) request.getParameter("id");
        String password = (String) request.getParameter("contrasena");
        String antiguo_id = (String) request.getParameter("antiguoId");

        if (id != null && !id.isEmpty()) {
            mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
            try {
                Usuario user = new Usuario(id, password);
                mUsuarioDAO.actualizar(user, antiguo_id);
                List<Usuario> datos = mUsuarioDAO.encontrarTodos();
                request.setAttribute("users", datos);
                request.getRequestDispatcher("Usuario.jsp").forward(request, response);
            } catch (SQLException e) {
                System.out.println("no funciona");
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    //Eliminar
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String id = (String) request.getParameter("id");

        if (id != null && !id.isEmpty()) {
            mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
            try {
                mUsuarioDAO.eliminar(id);
                List<Usuario> datos = mUsuarioDAO.encontrarTodos();
                request.setAttribute("users", datos);
            } catch (SQLException e) {
                System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
            }
            request.getRequestDispatcher("Usuario.jsp").forward(request, response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    public String getServletInfo() {
        return "Se encarga de eliminar y actualizar a un usuario";
    }// </editor-fold>

}
