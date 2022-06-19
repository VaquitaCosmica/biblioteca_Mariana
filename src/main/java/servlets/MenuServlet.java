package servlets;

import daos.AlquilaDAO;
import daos.AutorDAO;
import daos.ClienteDAO;
import daos.CuidaDAO;
import daos.DesempleadoDAO;
import daos.EmpleadoDAO;
import daos.LibroDAO;
import daos.MobiliarioDAO;
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
import modelos.Alquila;
import modelos.Autor;
import modelos.Cliente;
import modelos.Cuida;
import modelos.Desempleado;
import modelos.Empleado;
import modelos.Libro;
import modelos.Mobiliario;
import modelos.Usuario;

@WebServlet(name = "MenuServlet", urlPatterns = {"/MenuServlet"})
public class MenuServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private UsuarioDAO mUsuarioDAO;
    private LibroDAO mLibroDAO;
    private EmpleadoDAO mEmpleadoDAO;
    private DesempleadoDAO mDesempleadoDAO;
    private ClienteDAO mClienteDAO;
    private AutorDAO mAutorDAO;
    private MobiliarioDAO mMobiliarioDAO;
    private AlquilaDAO mAlquilaDAO;
    private CuidaDAO mCuidaDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tipo = request.getParameter("Tipo");
        System.out.println("TIPO: " + tipo);

        if (tipo != null) {
            switch (tipo) {
                case "USUARIO":
                    mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
                    try {
                        List<Usuario> datos = mUsuarioDAO.encontrarTodos();
                        request.setAttribute("users", datos);
                        request.getRequestDispatcher("Usuario.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "LIBRO":
                    mLibroDAO = new LibroDAO(mPoolConexionesBD);
                    try {
                        List<Libro> datos = mLibroDAO.encontrarTodos();
                        request.setAttribute("libros", datos);
                        request.getRequestDispatcher("Libro.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "EMPLEADO":
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);
                    try {
                        List<Empleado> datos = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", datos);
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "DESEMPLEADO":
                    mDesempleadoDAO = new DesempleadoDAO(mPoolConexionesBD);
                    try {
                        List<Desempleado> desempleados = mDesempleadoDAO.encontrarTodos();
                        request.setAttribute("desempleados", desempleados);
                        request.getRequestDispatcher("Desempleado.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "CLIENTE":
                    mClienteDAO = new ClienteDAO(mPoolConexionesBD);
                    try {
                        List<Cliente> clientes = mClienteDAO.encontrarTodos();
                        request.setAttribute("clientes", clientes);
                        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "AUTOR":
                    mAutorDAO = new AutorDAO(mPoolConexionesBD);
                    try {
                        List<Autor> autores = mAutorDAO.encontrarTodos();
                        request.setAttribute("autores", autores);
                        request.getRequestDispatcher("Autor.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "MOBILIARIO":
                    mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);
                    try {
                        List<Mobiliario> mobiliario = mMobiliarioDAO.encontrarTodos();
                        request.setAttribute("mobiliario", mobiliario);
                        request.getRequestDispatcher("Mobiliario.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PRESTAMO":
                    mAlquilaDAO = new AlquilaDAO(mPoolConexionesBD);
                    try {
                        List<Alquila> prestamos = mAlquilaDAO.encontrarTodos();
                        request.setAttribute("prestamos", prestamos);
                        request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "MANTENIMIENTO":
                    mCuidaDAO = new CuidaDAO(mPoolConexionesBD);
                    try {
                        List<Cuida> mantenimientos = mCuidaDAO.encontrarTodos();
                        request.setAttribute("mantenimientos", mantenimientos);
                        request.getRequestDispatcher("Mantenimiento.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                default:
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                    break;
            }
        } else {
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Maneja las peticiones para saber qué tabla se quiere tomar y se encarga de redirigir al usuario a ella";
    }// </editor-fold>

}
