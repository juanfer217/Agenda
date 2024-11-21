<%@page import="mundo.AgendaContactos"%>
<%@include file="lib/header.jsp" %>
<%@page import="mundo.Contacto"%>
<%@page import="java.util.LinkedList"%>
<link rel="stylesheet" href="styles/styleIndex.css">

<%
    ServletContext context = request.getServletContext();
    AgendaContactos gesContactos = new AgendaContactos();
    gesContactos.cargarContactosDesdeArchivo(context);
    LinkedList<Contacto> listaContactos = gesContactos.getMisContactos(context);
    request.getSession().setAttribute("listaContactos", listaContactos);
%>

<body>
    <div class="container">
        <h1>Contactos</h1>
        <div class="row">
            <!-- Columna izquierda -->
            <div class="col-md-4">
                <div class="form-container">
                    <h5>Agregar Contacto</h5>
                    <form action="servletAgregarC" method="post">
                        <div class="form-group">
                            <label for="telefono">Teléfono:</label>
                            <input type="text" name="telefono" required>
                        </div>
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" name="nombre" required>
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido:</label>
                            <input type="text" name="apellido" required>
                        </div>
                        <div class="form-group">
                            <label for="direccion">Dirección:</label>
                            <input type="text" name="direccion">
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="text" name="email">
                        </div>
                        <div class="form-group">
                            <input type="submit" name="agregar" value="Agregar" class="btn">
                        </div>
                    </form>
                </div>
            </div>
            <!-- Columna derecha -->
            <div class="col-md-8">
                <div class="table-container">
                    <h5>Listado de Contactos</h5>
                    <div class="row">
                        <%
                            if (listaContactos != null && !listaContactos.isEmpty()) {
                                for (Contacto contacto : listaContactos) {%>

                        <div class="col-md-6">
                            <div class="card">
                                <div class="card-body">
                                    <h5 class="card-title"><%= contacto.getNombre() + " " + contacto.getApellido()%></h5>
                                    <p class="card-text"><strong>Teléfono:</strong> <%= contacto.getTelefono()%></p>
                                    <p class="card-text"><strong>Email:</strong> <%= contacto.getEmail()%></p>
                                    <p class="card-text"><strong>Dirección:</strong> <%= contacto.getDireccion()%></p>
                                    <div class="card-actions">
                                        <a href="#" class="icon-button" data-bs-toggle="modal" data-bs-target="#verModal<%= contacto.getTelefono()%>">Ver</a>
                                        <a href="#" class="icon-button" data-bs-toggle="modal" data-bs-target="#verModal2<%= contacto.getTelefono()%>">Editar</a>
                                        <a href="servletEliminarC?telefono=<%= contacto.getTelefono()%>" class="icon-button" onclick="return confirm('¿Estás seguro de eliminar este contacto?')">Eliminar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <% }
                        } else { %>
                        <div class="col-12">
                            <div class="alert alert-info">No hay contactos registrados</div>
                        </div>
                        <% } %>
                    </div>
                </div>
            </div>

        </div>
    </div>

    <% if (listaContactos != null && !listaContactos.isEmpty()) {
            for (Contacto contacto : listaContactos) {%>
    <!-- Modal Ver Contacto -->
    <div class="modal fade" id="verModal<%= contacto.getTelefono()%>" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5>Información del Contacto</h5>
                    <button type="button" class="close" data-bs-dismiss="modal">Cerrar</button>
                </div>
                <div class="modal-body">
                    <p>Teléfono: <%= contacto.getTelefono()%></p>
                    <p>Nombre: <%= contacto.getNombre()%></p>
                    <p>Apellido: <%= contacto.getApellido()%></p>
                    <p>Dirección: <%= contacto.getDireccion()%></p>
                    <p>Email: <%= contacto.getEmail()%></p>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cerrar</button>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal Editar Contacto -->
    <div class="modal fade" id="verModal2<%= contacto.getTelefono()%>" tabindex="-1" aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h5>Editar Contacto con Teléfono: <%= contacto.getTelefono()%></h5>
                    <button type="button" class="close" data-bs-dismiss="modal">Cerrar</button>
                </div>
                <div class="modal-body">
                    <form action="servletEditarC" method="post">
                        <input type="hidden" name="telefono" value="<%= contacto.getTelefono()%>">
                        <div class="form-group">
                            <label for="nombre">Nombre:</label>
                            <input type="text" name="nombre" value="<%= contacto.getNombre()%>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="apellido">Apellido:</label>
                            <input type="text" name="apellido" value="<%= contacto.getApellido()%>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="direccion">Dirección:</label>
                            <input type="text" name="direccion" value="<%= contacto.getDireccion()%>" class="form-control">
                        </div>
                        <div class="form-group">
                            <label for="email">Email:</label>
                            <input type="text" name="email" value="<%= contacto.getEmail()%>" class="form-control">
                        </div>
                        <div class="modal-footer">
                            <button type="submit" class="btn btn-primary">Guardar Cambios</button>
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Cancelar</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
    <% }
        }%>


</body>

<%@include file="lib/footer.jsp" %>
