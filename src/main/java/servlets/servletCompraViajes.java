package servlets;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import mundo.ListaCircularSimple;
import mundo.ManejoArchivos;
import mundo.Viajes;

// Servlet para manejar la compra de viajes
@WebServlet("/servletCompraViajes")
public class servletCompraViajes extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int idViaje = Integer.parseInt(request.getParameter("viaje")); // ID del viaje seleccionado
        int cantidadPasajeros = Integer.parseInt(request.getParameter("pasajeros")); // Número de pasajeros
        String correo = (String) request.getSession().getAttribute("email"); // Usuario identificado

        // Obtener la lista de viajes
        ListaCircularSimple listaViajes = ManejoArchivos.cargarViajes(getServletContext().getRealPath("/data/viajes.txt"));

        Viajes viajeSeleccionado = null;

        // Buscar el viaje seleccionado por ID
        for (Viajes v : listaViajes.obtenerViajes()) {
            if (v.getIdViaje() == idViaje) {
                viajeSeleccionado = v;
                break;
            }
        }

        if (viajeSeleccionado == null) {
            // Si no se encuentra el viaje, redirigir con un mensaje de error
            response.sendRedirect("error.jsp?mensaje=Viaje no encontrado");
            return;
        }

        // Calcular el total
        double total = viajeSeleccionado.getPrecio() * cantidadPasajeros;

        // Generar la factura
        String factura = "Correo: " + correo + 
                         "\nDestino: " + viajeSeleccionado.getDestino() + 
                         "\nDuración: " + viajeSeleccionado.getDuracion() + " días" +
                         "\nCantidad de Pasajeros: " + cantidadPasajeros + 
                         "\nTotal: $" + total;
        ManejoArchivos.guardarFactura(factura, getServletContext().getRealPath("/data/facturas.txt"));

        // Redirigir a la página de confirmación con el costo total
        response.sendRedirect("confirmacion.jsp?total=" + total);
    }
}
