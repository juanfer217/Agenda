package servlets;

import mundo.GestionarLugares;
import mundo.Lugar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.List;

@WebServlet("/gestionarLugares")
public class servletLugares extends HttpServlet {
    private GestionarLugares gestionarLugares;

    @Override
    public void init() throws ServletException {
        gestionarLugares = new GestionarLugares();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        if (action != null) {
            switch (action) {
                case "listar":
                    List<Lugar> lugares = gestionarLugares.listarLugares();
                    request.setAttribute("lugares", lugares);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("lugares.jsp");
                    dispatcher.forward(request, response);
                    break;
                default:
                    response.sendRedirect("error.jsp");
                    break;
            }
        } else {
            response.sendRedirect("lugares.jsp");
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String accion = request.getParameter("accion");

        if (accion != null) {
            switch (accion) {
                case "agregar":
                    int idLugar = Integer.parseInt(request.getParameter("idLugar"));
                    String nombre = request.getParameter("nombre");
                    String ciudad = request.getParameter("ciudad");
                    String descripcion = request.getParameter("descripcion");
                    int puntuacion = Integer.parseInt(request.getParameter("puntuacion"));
                    gestionarLugares.agregarLugar(idLugar, nombre, ciudad, descripcion, puntuacion);
                    break;
                case "eliminar":
                    int idEliminar = Integer.parseInt(request.getParameter("idLugar"));
                    gestionarLugares.eliminarLugar(idEliminar);
                    break;
                case "editar":
                    int idEditar = Integer.parseInt(request.getParameter("idLugar"));
                    String nuevoNombre = request.getParameter("nombre");
                    String nuevaCiudad = request.getParameter("ciudad");
                    String nuevaDescripcion = request.getParameter("descripcion");
                    int nuevaPuntuacion = Integer.parseInt(request.getParameter("puntuacion"));
                    gestionarLugares.editarLugar(idEditar, nuevoNombre, nuevaCiudad, nuevaDescripcion, nuevaPuntuacion);
                    break;
                default:
                    response.sendRedirect("lugares.jsp");
                    return;
            }
        }

        response.sendRedirect("gestionarLugares?action=listar");
    }
}
