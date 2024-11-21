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

@WebServlet(name = "servletEliminarC", urlPatterns = {"/servletEliminarC"})
public class servletEliminarC extends HttpServlet {

    private static final AgendaContactos gesContactos = new AgendaContactos();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        long telefonoEliminar = Long.parseLong(request.getParameter("telefono"));
        ServletContext context = request.getServletContext();
        
        gesContactos.cargarContactosDesdeArchivo(context);
        gesContactos.eliminarContacto(telefonoEliminar, context);

        LinkedList<Contacto> listaContactos = gesContactos.getMisContactos(context);
        request.getSession().setAttribute("listaContactos", listaContactos);

        response.sendRedirect("agenda.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Servlet para eliminar contactos";
    }
}
