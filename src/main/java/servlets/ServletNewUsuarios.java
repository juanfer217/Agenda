package servlets;

import mundo.ManejoArchivos;
import mundo.Usuario;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ServletNewUsuarios")
public class ServletNewUsuarios extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            // Obtener parámetros del formulario
            
            String nombre = request.getParameter("nombre");
            String correo = request.getParameter("correo");
            String contrasena = request.getParameter("password");

            // Crear un nuevo usuario
            Usuario nuevoUsuario = new Usuario(nombre, correo, contrasena);

            // Guardar usuario en usuarios.txt
            ManejoArchivos.guardarUsuario(nuevoUsuario, getServletContext().getRealPath("/data/usuarios.txt"));

            // Redireccionar al login
            response.sendRedirect("login.jsp");
        } catch (Exception e) {
            
            e.printStackTrace();
            response.sendRedirect("index.jsp?error=true");
        }
    }
}
