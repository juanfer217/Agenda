<%@page import="mundo.ListaCircularSimple"%>
<%@page import="mundo.Viajes"%>
<%@page import="mundo.ManejoArchivos"%>
<%@include file="lib/header.jsp" %>
<link href="styles/viajesStyles.css" rel="stylesheet" type="text/css"/>
<div class="container">
    <h2>Compra de Viajes</h2>
    <form action="servletCompraViajes" method="post">
        <div class="form-group">
            <label for="viaje">Selecciona un viaje:</label>
            <select class="form-control" id="viaje" name="viaje" required>
                <%
                    ListaCircularSimple listaViajes = ManejoArchivos.cargarViajes(application.getRealPath("/data/viajes.txt"));

                    for (Viajes v : listaViajes.obtenerViajes()) {
                %>
                    <option value="<%= v.getIdViaje() %>">
                        <%= v.getDestino() %> - Duración: <%= v.getDuracion() %> días - $<%= v.getPrecio() %>
                    </option>
                <%
                    }
                %>
            </select>
        </div>
        <div class="form-group">
            <label for="pasajeros">Cantidad de Pasajeros:</label>
            <input type="number" class="form-control" id="pasajeros" name="pasajeros" min="1" required>
        </div>
        <button type="submit" class="btn btn-primary">Comprar</button>
    </form>
</div>

