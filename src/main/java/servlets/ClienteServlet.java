/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlets;

import daos.CiudadDAO;
import daos.ClienteDAO;
import daos.EmpleadoDAO;
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
import modelos.Ciudad;
import modelos.Cliente;
import modelos.Empleado;
import modelos.Usuario;

@WebServlet(name = "ClienteServlet", urlPatterns = {"/ClienteServlet"})
public class ClienteServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private UsuarioDAO mUsuarioDAO;
    private CiudadDAO mCiudadDAO;
    private EmpleadoDAO mEmpleadoDAO;
    private ClienteDAO mClienteDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "PRECREAR":
                    System.out.println("ESTOY EN PREECREAR CLIENTE");
                    mCiudadDAO = new CiudadDAO(mPoolConexionesBD);
                    try {
                        request.setAttribute("permiso", "true");
                        List<Ciudad> ciudades = mCiudadDAO.encontrarTodos();
                        request.setAttribute("ciudades", ciudades);
                        request.getRequestDispatcher("crearCliente.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;

                case "CREAR":
                    mClienteDAO = new ClienteDAO(mPoolConexionesBD);

                    Cliente nuevo_cliente = new Cliente();
                    nuevo_cliente.setOcupacion(request.getParameter("ocupacion"));
                    nuevo_cliente.setTelefono(request.getParameter("telefono"));
                    nuevo_cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
                    nuevo_cliente.setNombre(request.getParameter("nombre"));
                    nuevo_cliente.setID_cliente(Integer.parseInt(request.getParameter("ID_cliente")));
                    nuevo_cliente.setF_nacimiento(Date.valueOf(request.getParameter("f_nacimiento")));
                    nuevo_cliente.setColonia(request.getParameter("colonia"));
                    nuevo_cliente.setCiudad_id(request.getParameter("ciudad_id"));
                    nuevo_cliente.setCalle(request.getParameter("calle"));
                    nuevo_cliente.setApe_pat(request.getParameter("ape_pat"));
                    nuevo_cliente.setApe_mat(request.getParameter("ape_mat"));

                    System.out.println("ESTOY EN CREAR cliente");
                    try {
                        mClienteDAO.crear(nuevo_cliente);
                        List<Cliente> clientes = mClienteDAO.encontrarTodos();
                        request.setAttribute("clientes", clientes);
                        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    System.out.println("ESTOY EN PREEACTUALIZAR cliente");
                    mCiudadDAO = new CiudadDAO(mPoolConexionesBD);

                    request.setAttribute("ID_cliente", request.getParameter("ID_cliente"));
                    request.setAttribute("nombre", request.getParameter("nombre"));
                    request.setAttribute("ape_pat", request.getParameter("ape_pat"));
                    request.setAttribute("ape_mat", request.getParameter("ape_mat"));
                    request.setAttribute("f_naciemiento", request.getParameter("f_naciemiento"));
                    request.setAttribute("calle", request.getParameter("calle"));
                    request.setAttribute("numero", request.getParameter("numero"));
                    request.setAttribute("colonia", request.getParameter("colonia"));
                    request.setAttribute("telefono", request.getParameter("telefono"));
                    request.setAttribute("ciudad_id", request.getParameter("ciudad_id"));
                    request.setAttribute("ocupacion", request.getParameter("ocupacion"));
                    System.out.println("ocupacion en preactualizar: " + request.getParameter("ocupacion"));

                    try {
                        List<Ciudad> ciudades = mCiudadDAO.encontrarTodos();
                        request.setAttribute("ciudades", ciudades);
                        request.getRequestDispatcher("actualizarCliente.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ACTUALIZAR":
                    System.out.println("ESTOY EN ACTUALIZAR cliente");
                    mClienteDAO = new ClienteDAO(mPoolConexionesBD);

                    Cliente cliente = new Cliente();
                    cliente.setOcupacion(request.getParameter("ocupacion"));
                    cliente.setTelefono(request.getParameter("telefono"));
                    cliente.setNumero(Integer.parseInt(request.getParameter("numero")));
                    cliente.setNombre(request.getParameter("nombre"));
                    cliente.setID_cliente(Integer.parseInt(request.getParameter("ID_cliente")));
                    cliente.setF_nacimiento(Date.valueOf(request.getParameter("f_nacimiento")));
                    cliente.setColonia(request.getParameter("colonia"));
                    cliente.setCiudad_id(request.getParameter("ciudad_id"));
                    cliente.setCalle(request.getParameter("calle"));
                    cliente.setApe_pat(request.getParameter("ape_pat"));
                    cliente.setApe_mat(request.getParameter("ape_mat"));

                    try {
                        mClienteDAO.actualizar(cliente, Integer.parseInt(request.getParameter("antiguoId")));
                        List<Cliente> clientes = mClienteDAO.encontrarTodos();
                        request.setAttribute("clientes", clientes);
                        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
                        //request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    if (request.getParameter("id") != null) {
                        int id = Integer.parseInt(request.getParameter("id"));
                        mClienteDAO = new ClienteDAO(mPoolConexionesBD);
                        try {
                            mClienteDAO.eliminar(id);
                            List<Cliente> clientes = mClienteDAO.encontrarTodos();
                            request.setAttribute("clientes", clientes);
                        } catch (SQLException e) {
                            System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa , no funciona");
                        }
                        request.getRequestDispatcher("Cliente.jsp").forward(request, response);
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
