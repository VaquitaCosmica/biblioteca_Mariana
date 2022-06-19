package servlets;

import daos.AlquilaDAO;
import daos.ClienteDAO;
import daos.CuidaDAO;
import daos.EmpleadoDAO;
import daos.LibroDAO;
import daos.MobiliarioDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
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
import modelos.Cliente;
import modelos.Cuida;
import modelos.Empleado;
import modelos.Libro;
import modelos.Mobiliario;

@WebServlet(name = "MantenimientoServlet", urlPatterns = {"/MantenimientoServlet"})
public class MantenimientoServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private AlquilaDAO mAlquilaDAO;
    private EmpleadoDAO mEmpleadoDAO;
    private LibroDAO mLibroDAO;
    private ClienteDAO mClienteDAO;
    private CuidaDAO mCuidaDAO;
    private MobiliarioDAO mMobiliarioDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "PRECREAR":
                    System.out.println("ESTOY EN PREECREAR mantenimiento");
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);
                    mCuidaDAO = new CuidaDAO(mPoolConexionesBD);
                    mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);

                    try {
                        request.setAttribute("permiso", "true");
                        List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", empleados);
                        List<Mobiliario> mobiliario = mMobiliarioDAO.encontrarTodos();
                        request.setAttribute("mobiliario", mobiliario);
                        request.getRequestDispatcher("crearMantenimiento.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "CREAR":
                    System.out.println("ESTOY EN CREAR mantenimiento");

                    mCuidaDAO = new CuidaDAO(mPoolConexionesBD);
                    Cuida nuevo_mantenimiento = new Cuida();
                    nuevo_mantenimiento.setF_manto(Date.valueOf(request.getParameter("f_manto")));
                    nuevo_mantenimiento.setID_empleado(Integer.parseInt(request.getParameter("ID_empleado")));
                    nuevo_mantenimiento.setId_manto(request.getParameter("id_manto"));
                    nuevo_mantenimiento.setId_mobiliario(request.getParameter("id_mobiliario"));

                    try {
                        mCuidaDAO.crear(nuevo_mantenimiento);
                        List<Cuida> mantenimientos = mCuidaDAO.encontrarTodos();
                        request.setAttribute("mantenimientos", mantenimientos);
                        request.getRequestDispatcher("Mantenimiento.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    System.out.println("ESTOY EN PREEACTUALIZAR mantenimiento: " + request.getParameter("ID_empleado"));
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);
                    mCuidaDAO = new CuidaDAO(mPoolConexionesBD);
                    mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);

                    request.setAttribute("f_manto", request.getParameter("f_manto"));
                    request.setAttribute("ID_empleado", request.getParameter("ID_empleado"));
                    request.setAttribute("id_manto", request.getParameter("id_manto"));
                    request.setAttribute("id_mobiliario", request.getParameter("id_mobiliario"));

                    try {
                        List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", empleados);
                        List<Mobiliario> mobiliario = mMobiliarioDAO.encontrarTodos();
                        request.setAttribute("mobiliario", mobiliario);
                        request.getRequestDispatcher("actualizarMantenimiento.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ACTUALIZAR":
                    System.out.println("ESTOY EN ACTUALIZAR mantenimiento");
                    mCuidaDAO = new CuidaDAO(mPoolConexionesBD);

                    Cuida mantenimiento = new Cuida();
                    mantenimiento.setF_manto(Date.valueOf(request.getParameter("f_manto")));
                    mantenimiento.setID_empleado(Integer.parseInt(request.getParameter("ID_empleado")));
                    mantenimiento.setId_manto(request.getParameter("id_manto"));
                    mantenimiento.setId_mobiliario(request.getParameter("id_mobiliario"));
                    try {
                        mCuidaDAO.actualizar(mantenimiento, request.getParameter("antiguoId"));
                        List<Cuida> mantenimientos = mCuidaDAO.encontrarTodos();
                        request.setAttribute("mantenimientos", mantenimientos);
                        request.getRequestDispatcher("Mantenimiento.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    String id = (String) request.getParameter("id_manto");
                    if (id != null && !id.isEmpty()) {
                        mCuidaDAO = new CuidaDAO(mPoolConexionesBD);
                        try {
                            mCuidaDAO.eliminar(id);
                            List<Cuida> mantenimientos = mCuidaDAO.encontrarTodos();
                            request.setAttribute("mantenimientos", mantenimientos);
                            request.getRequestDispatcher("Mantenimiento.jsp").forward(request, response);
                        } catch (SQLException e) {
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
                        }
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
