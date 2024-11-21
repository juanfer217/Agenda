package servlets;

import mundo.ManejoArchivos;
import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

// Servlet para iniciar sesión
@WebServlet("/loginServlet")
public class loginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener el correo electrónico y la contraseña desde el formulario
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("password");

            // Validar usuario en usuarios.txt
            if (ManejoArchivos.validarUsuario(correo, contrasena, getServletContext().getRealPath("/data/usuarios.txt"))) {
                // Guardar el correo electrónico en la sesión
                HttpSession session = request.getSession();
                session.setAttribute("email", correo);
                response.sendRedirect("agenda.jsp");
            } else {
                // Redireccionar de nuevo al login con un mensaje de error
                response.sendRedirect("login.jsp?error=true");
            }
        } catch (Exception e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=invalid_credentials");
        }
    }
}
