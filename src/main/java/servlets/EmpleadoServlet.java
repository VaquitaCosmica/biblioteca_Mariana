package servlets;

import daos.AutorDAO;
import daos.CategoriaDAO;
import daos.CiudadDAO;
import daos.EditorialDAO;
import daos.EmpleadoDAO;
import daos.LibroDAO;
import daos.UsuarioDAO;
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
import modelos.Autor;
import modelos.Categoria;
import modelos.Ciudad;
import modelos.Editorial;
import modelos.Empleado;
import modelos.Libro;
import modelos.Usuario;

@WebServlet(name = "EmpleadoServlet", urlPatterns = {"/EmpleadoServlet"})
public class EmpleadoServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private UsuarioDAO mUsuarioDAO;
    private CiudadDAO mCiudadDAO;
    private EmpleadoDAO mEmpleadoDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "PRECREAR":
                    System.out.println("ESTOY EN PREECREAR EMPLEADO");
                    mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
                    mCiudadDAO = new CiudadDAO(mPoolConexionesBD);
                    try {
                        request.setAttribute("permiso", "true");
                        List<Usuario> usuarios = mUsuarioDAO.encontrarTodos();
                        request.setAttribute("usuarios", usuarios);
                        List<Ciudad> ciudades = mCiudadDAO.encontrarTodos();
                        request.setAttribute("ciudades", ciudades);
                        request.getRequestDispatcher("crearEmpleado.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;

                case "CREAR":
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);

                    Empleado nuevo_empleado = new Empleado();
                    nuevo_empleado.setUser(request.getParameter("user"));
                    nuevo_empleado.setTelefono(request.getParameter("telefono"));
                    nuevo_empleado.setNumero(Integer.parseInt(request.getParameter("numero")));
                    nuevo_empleado.setNombre(request.getParameter("nombre"));
                    nuevo_empleado.setID_empleado(Integer.parseInt(request.getParameter("ID_empleado")));
                    nuevo_empleado.setF_nacimiento(Date.valueOf(request.getParameter("f_nacimiento")));
                    nuevo_empleado.setColonia(request.getParameter("colonia"));
                    nuevo_empleado.setCiudad_id(request.getParameter("ciudad_id"));
                    nuevo_empleado.setCalle(request.getParameter("calle"));
                    nuevo_empleado.setApe_pat(request.getParameter("ape_pat"));
                    nuevo_empleado.setApe_mat(request.getParameter("ape_mat"));
                    System.out.println("ESTOY EN CREAR EMPLEADO");
                    try {
                        mEmpleadoDAO.crear(nuevo_empleado);
                        List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", empleados);
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    System.out.println("ESTOY EN PREEACTUALIZAR empleado");
                    mUsuarioDAO = new UsuarioDAO(mPoolConexionesBD);
                    mCiudadDAO = new CiudadDAO(mPoolConexionesBD);

                    request.setAttribute("ID_empleado", request.getParameter("ID_empleado"));
                    request.setAttribute("nombre", request.getParameter("nombre"));
                    request.setAttribute("ape_pat", request.getParameter("ape_pat"));
                    request.setAttribute("ape_mat", request.getParameter("ape_mat"));
                    request.setAttribute("f_naciemiento", request.getParameter("f_naciemiento"));
                    request.setAttribute("calle", request.getParameter("calle"));
                    request.setAttribute("numero", request.getParameter("numero"));
                    request.setAttribute("colonia", request.getParameter("colonia"));
                    request.setAttribute("telefono", request.getParameter("telefono"));
                    request.setAttribute("ciudad_id", request.getParameter("ciudad_id"));
                    request.setAttribute("user", request.getParameter("user"));

                    try {
                        List<Usuario> usuarios = mUsuarioDAO.encontrarTodos();
                        request.setAttribute("usuarios", usuarios);
                        List<Ciudad> ciudades = mCiudadDAO.encontrarTodos();
                        request.setAttribute("ciudades", ciudades);
                        request.getRequestDispatcher("actualizarEmpleado.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ACTUALIZAR":
                    System.out.println("ESTOY EN ACTUALIZAR EMPLEADO");
                    mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);

                    Empleado empleado = new Empleado();
                    empleado.setUser(request.getParameter("user"));
                    empleado.setTelefono(request.getParameter("telefono"));
                    empleado.setNumero(Integer.parseInt(request.getParameter("numero")));
                    empleado.setNombre(request.getParameter("nombre"));
                    empleado.setID_empleado(Integer.parseInt(request.getParameter("ID_empleado")));
                    empleado.setF_nacimiento(Date.valueOf(request.getParameter("f_nacimiento")));
                    empleado.setColonia(request.getParameter("colonia"));
                    empleado.setCiudad_id(request.getParameter("ciudad_id"));
                    empleado.setCalle(request.getParameter("calle"));
                    empleado.setApe_pat(request.getParameter("ape_pat"));
                    empleado.setApe_mat(request.getParameter("ape_mat"));

                    try {
                        mEmpleadoDAO.actualizar(empleado, Integer.parseInt(request.getParameter("antiguoId")));
                        List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                        request.setAttribute("empleados", empleados);
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    if (request.getParameter("id") != null) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        mEmpleadoDAO = new EmpleadoDAO(mPoolConexionesBD);
                        try {
                            mEmpleadoDAO.eliminar(id);
                            List<Empleado> empleados = mEmpleadoDAO.encontrarTodos();
                            request.setAttribute("empleados", empleados);
                        } catch (SQLException e) {
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
                        }
                        request.getRequestDispatcher("Empleado.jsp").forward(request, response);
                    } else {
                        request.getRequestDispatcher("index.jsp").forward(request, response);
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
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
