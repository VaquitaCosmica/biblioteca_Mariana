package servlets;

import daos.AutorDAO;
import daos.MobiliarioDAO;
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
import modelos.Mobiliario;

@WebServlet(name = "MobiliarioServlet", urlPatterns = {"/MobiliarioServlet"})
public class MobiliarioServlet extends HttpServlet {

    @Resource(name = "jdbc/myDatasource")
    private DataSource mPoolConexionesBD;
    private AutorDAO mAutorDAO;
    private MobiliarioDAO mMobiliarioDAO;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("ESTOY EN SERVLET MOVILIARIO");
        String operacion = request.getParameter("operacion");
        if (operacion != null) {
            switch (operacion) {
                case "CREAR":
                    System.out.println("ESTOY EN CREAR mobiliario");
                    mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);
                    Mobiliario nuevo_mobiliario = new Mobiliario();
                    nuevo_mobiliario.setId_mobiliario(request.getParameter("id_mobiliario"));
                    nuevo_mobiliario.setNombre(request.getParameter("nombre"));
                    nuevo_mobiliario.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    try {
                        mMobiliarioDAO.crear(nuevo_mobiliario);
                        List<Mobiliario> mobiliarios = mMobiliarioDAO.encontrarTodos();
                        request.setAttribute("mobiliario", mobiliarios);
                        request.getRequestDispatcher("Mobiliario.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "PREACTUALIZAR":
                    mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);
                    request.setAttribute("id_mobiliario", request.getParameter("id_mobiliario"));
                    request.setAttribute("nombre", request.getParameter("nombre"));
                    request.setAttribute("cantidad", request.getParameter("cantidad"));
                    request.getRequestDispatcher("actualizarMobiliario.jsp").forward(request, response);
                    break;
                case "ACTUALIZAR":
                    System.out.println("ESTOY EN ACTUALIZAR mobiliario, id: " + request.getParameter("id_mobiliario"));
                    mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);
                    Mobiliario mobiliario = new Mobiliario();
                    mobiliario.setId_mobiliario(request.getParameter("id_mobiliario"));
                    mobiliario.setNombre(request.getParameter("nombre"));
                    mobiliario.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
                    try {
                        mMobiliarioDAO.actualizar(mobiliario, request.getParameter("antiguoId"));
                        List<Mobiliario> mobiliarios = mMobiliarioDAO.encontrarTodos();
                        request.setAttribute("mobiliario", mobiliarios);
                        request.getRequestDispatcher("Mobiliario.jsp").forward(request, response);
                        //    request.getRequestDispatcher("menu.jsp").forward(request, response);
                    } catch (SQLException e) {
                        System.out.println("no funciona");
                    }
                    break;
                case "ELIMINAR":
                    System.out.println("ESTOY EN eliminar mobiliario, id: " + request.getParameter("id_mobiliario"));
                    String id = (String) request.getParameter("id_mobiliario");
                    if (id != null && !id.isEmpty()) {
                        mMobiliarioDAO = new MobiliarioDAO(mPoolConexionesBD);
                        try {
                            mMobiliarioDAO.eliminar(id);
                            List<Mobiliario> mobiliarios = mMobiliarioDAO.encontrarTodos();
                            request.setAttribute("mobiliario", mobiliarios);
                            request.getRequestDispatcher("Mobiliario.jsp").forward(request, response);
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
