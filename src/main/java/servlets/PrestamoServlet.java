package servlets;

import daos.AlquilaDAO;
import daos.ClienteDAO;
import daos.EmpleadoDAO;
import daos.LibroDAO;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import modelos.Libro;
import javax.annotation.Resource;
import modelos.Alquila;
import modelos.Cliente;
import modelos.Empleado;

@WebServlet(name = "PrestamoServlet", urlPatterns = {"/PrestamoServlet"})
public class PrestamoServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private AlquilaDAO mAlquilaDAO;
    private EmpleadoDAO mEmpleadoDAO;
    private LibroDAO mLibroDAO;
    private ClienteDAO mClienteDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "PRECREAR":
                    System.out.println("ESTOY EN PREECREAR prestamo");
                    mAlquilaDAO = new AlquilaDAO(mPoolConexionesBD);
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);
                    mLibroDAO = new LibroDAO(mPoolConexionesBD);
                    mClienteDAO = new ClienteDAO(mPoolConexionesBD);

                    try {
                        request.setAttribute("permiso", "true");
                        List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", empleados);
                        List<Libro> libros = mLibroDAO.encontrarTodos();
                        request.setAttribute("libros", libros);
                        List<Cliente> clientes = mClienteDAO.encontrarTodos();
                        request.setAttribute("clientes", clientes);
                        request.getRequestDispatcher("crearPrestamo.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "CREAR":
                    System.out.println("ESTOY EN CREAR prestamo");

                    mAlquilaDAO = new AlquilaDAO(mPoolConexionesBD);
                    Alquila nuevo_prestamo = new Alquila();
                    nuevo_prestamo.setF_entrada(Date.valueOf(request.getParameter("f_entrada")));
                    nuevo_prestamo.setF_salida(Date.valueOf(request.getParameter("f_salida")));
                    nuevo_prestamo.setID_cliente(Integer.parseInt(request.getParameter("ID_cliente")));
                    nuevo_prestamo.setID_empleada(Integer.parseInt(request.getParameter("ID_empleado")));
                    nuevo_prestamo.setId_alquiler(request.getParameter("id_alquiler"));
                    nuevo_prestamo.setId_libro(request.getParameter("id_libro"));

                    try {
                        mAlquilaDAO.crear(nuevo_prestamo);
                        List<Alquila> prestamos = mAlquilaDAO.encontrarTodos();
                        request.setAttribute("prestamos", prestamos);
                        request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    System.out.println("ESTOY EN PREEACTUALIZAR prestamo");
                    mAlquilaDAO = new AlquilaDAO(mPoolConexionesBD);
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);
                    mLibroDAO = new LibroDAO(mPoolConexionesBD);
                    mClienteDAO = new ClienteDAO(mPoolConexionesBD);

                    request.setAttribute("id_aquilar", request.getParameter("id_aquilar"));
                    request.setAttribute("f_salida", request.getParameter("f_salida"));
                    request.setAttribute("f_entrada", request.getParameter("f_entrada"));
                    request.setAttribute("ID_empleado", request.getParameter("ID_empleado"));
                    request.setAttribute("id_libro", request.getParameter("id_libro"));

                    try {
                        List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", empleados);
                        List<Libro> libros = mLibroDAO.encontrarTodos();
                        request.setAttribute("libros", libros);
                        List<Cliente> clientes = mClienteDAO.encontrarTodos();
                        request.setAttribute("clientes", clientes);
                        request.getRequestDispatcher("actualizarPrestamo.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ACTUALIZAR":
                    System.out.println("ESTOY EN ACTUALIZAR prestamo");
                    mAlquilaDAO = new AlquilaDAO(mPoolConexionesBD);

                    Alquila prestamo = new Alquila();
                    prestamo.setF_entrada(Date.valueOf(request.getParameter("f_entrada")));
                    prestamo.setF_salida(Date.valueOf(request.getParameter("f_salida")));
                    prestamo.setID_cliente(Integer.parseInt(request.getParameter("ID_cliente")));
                    prestamo.setID_empleada(Integer.parseInt(request.getParameter("ID_empleado")));
                    prestamo.setId_alquiler(request.getParameter("id_alquiler"));
                    prestamo.setId_libro(request.getParameter("id_libro"));

                    try {
                        mAlquilaDAO.actualizar(prestamo, request.getParameter("antiguoId"));
                        List<Alquila> prestamos = mAlquilaDAO.encontrarTodos();
                        request.setAttribute("prestamos", prestamos);
                        request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    String id = (String) request.getParameter("id_alquiler");
                    if (id != null && !id.isEmpty()) {
                        mAlquilaDAO = new AlquilaDAO(mPoolConexionesBD);
                        try {
                            mAlquilaDAO.eliminar(id);
                            List<Alquila> prestamos = mAlquilaDAO.encontrarTodos();
                            request.setAttribute("prestamos", prestamos);
                            request.getRequestDispatcher("Prestamo.jsp").forward(request, response);
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
