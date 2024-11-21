package servlets;

import mundo.AgendaContactos;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletContext;
import java.io.IOException;
import java.util.LinkedList;
import mundo.Contacto;

@WebServlet(name = "servletEditarC", urlPatterns = {"/servletEditarC"})
public class servletEditarC extends HttpServlet {

    private static final AgendaContactos gesContactos = new AgendaContactos();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            long telefono = Long.parseLong(request.getParameter("telefono"));
            String nuevoNombre = request.getParameter("nombre");
            String nuevoApellido = request.getParameter("apellido");
            String nuevoEmail = request.getParameter("email");
            String nuevaDireccion = request.getParameter("direccion");
            ServletContext context = request.getServletContext();
            
            gesContactos.editarContacto(telefono, nuevoNombre, nuevoApellido, nuevoEmail, nuevaDireccion, context);
            LinkedList<Contacto> listaContactos = gesContactos.getMisContactos(context);
            request.getSession().setAttribute("listaContactos", listaContactos);
            
        } catch (NumberFormatException e) {
            System.out.println("Número Invalido");
        } catch (IllegalArgumentException e) {
        }

        response.sendRedirect("agenda.jsp");
    }

    @Override
    public String getServletInfo() {
        return "Servlet para editar contactos";
    }
}
