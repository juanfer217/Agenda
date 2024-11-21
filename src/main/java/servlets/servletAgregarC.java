package servlets;

import mundo.AgendaContactos;
import mundo.Contacto;
import java.io.IOException;
import java.util.LinkedList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "servletAgregarC", urlPatterns = {"/servletAgregarC"})
public class servletAgregarC extends HttpServlet {

    public static AgendaContactos gesContactos = new AgendaContactos();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            long telefono = Long.parseLong(request.getParameter("telefono"));
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
            String email = request.getParameter("email");
            String direccion = request.getParameter("direccion");

            LinkedList<Contacto> listaContactos = gesContactos.getMisContactos(getServletContext());
            if (listaContactos != null) {
                for (Contacto ct : listaContactos) {
                    if (ct.getTelefono() == telefono) {
                        request.getSession().setAttribute("mensaje", "El número de teléfono ya está en uso.");
                        response.sendRedirect("agenda.jsp");
                        return;
                    }
                }
            }

            Contacto nuevoContacto = new Contacto(nombre, apellido, telefono, email, direccion);
            gesContactos.agregarContacto(nuevoContacto, getServletContext());

            listaContactos = gesContactos.getMisContactos(getServletContext());
            request.getSession().setAttribute("listaContactos", listaContactos);
            response.sendRedirect("agenda.jsp");
        } catch (NumberFormatException e) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "El número de teléfono no es válido");
        } catch (IOException e) {
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud");
        }
    }

    @Override
    public String getServletInfo() {
        return "Servlet para agregar contactos.";
    }
}
