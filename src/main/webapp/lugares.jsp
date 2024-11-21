<%@page import="java.util.List"%>
<%@page import="mundo.Lugar"%>
<%@include file="lib/header.jsp" %>

<div class="container">
    <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="styles/lugares.css">

    <h1 class="mt-4">Lugares Visitados</h1>

    <!-- Botón para mostrar los lugares -->
    <form action="gestionarLugares" method="get">
        <button type="submit" class="btn btn-primary mt-2" name="action" value="listar">Mostrar Lugares</button>
    </form>


    <hr>

    <!-- Formulario para agregar un lugar -->
    <h2>Agregar Lugar</h2>
    <form action="gestionarLugares" method="post">
        <input type="hidden" name="accion" value="agregar">
        <div class="form-group">
            <label for="idLugar">ID del Lugar:</label>
            <input type="number" class="form-control" id="idLugar" name="idLugar" required>
        </div>
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" id="nombre" name="nombre" required>
        </div>
        <div class="form-group">
            <label for="ciudad">Ciudad:</label>
            <input type="text" class="form-control" id="ciudad" name="ciudad" required>
        </div>
        <div class="form-group">
            <label for="descripcion">Descripción:</label>
            <textarea class="form-control" id="descripcion" name="descripcion" required></textarea>
        </div>
        <div class="form-group">
            <label for="puntuacion">Puntuación:</label>
            <div class="star-rating">
                <input type="radio" id="star5" name="puntuacion" value="5" required>
                <label for="star5" title="5 estrellas">O</label>
                <input type="radio" id="star4" name="puntuacion" value="4" required>
                <label for="star4" title="4 estrellas">O</label>
                <input type="radio" id="star3" name="puntuacion" value="3" required>
                <label for="star3" title="3 estrellas">O</label>
                <input type="radio" id="star2" name="puntuacion" value="2" required>
                <label for="star2" title="2 estrellas">O</label>
                <input type="radio" id="star1" name="puntuacion" value="1" required>
                <label for="star1" title="1 estrella">O</label>
            </div>
        </div>

        <button type="submit" class="btn btn-success mt-2">Agregar Lugar</button>
    </form>

    <hr>

    <!-- Tabla de lugares -->

    <section id="ListaL">
        <h2>Listado de Lugares</h2>
        <table class="table table-bordered">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Ciudad</th>
                    <th>Descripción</th>
                    <th>Puntuación</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <%
                    // Obtenemos la lista de lugares desde el request
                    List<Lugar> lugares = (List<Lugar>) request.getAttribute("lugares");

                    // Si la lista no es nula y contiene lugares
                    if (lugares != null && !lugares.isEmpty()) {
                        for (Lugar lugar : lugares) {
                %>
                <tr>
                    <td><%= lugar.getIdLugar()%></td>
                    <td><%= lugar.getNombre()%></td>
                    <td><%= lugar.getCiudad()%></td>
                    <td><%= lugar.getDescripcion()%></td>
                    <td><%= lugar.getPuntuacion()%></td>
                    <td>
                        <!-- Formulario para eliminar -->
                        <form action="gestionarLugares" method="post" style="display:inline;">
                            <input type="hidden" name="accion" value="eliminar">
                            <input type="hidden" name="idLugar" value="<%= lugar.getIdLugar()%>">
                            <button type="submit" class="btn btn-danger btn-sm">Eliminar</button>
                        </form>

                        <!-- Botón para editar -->
                        <button class="btn btn-warning btn-sm" data-toggle="modal" data-target="#editModal<%= lugar.getIdLugar()%>">Editar</button>

                        <!-- Modal para editar lugar -->
                        <div class="modal fade" id="editModal<%= lugar.getIdLugar()%>" tabindex="-1" role="dialog" aria-labelledby="editModalLabel" aria-hidden="true">
                            <div class="modal-dialog" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title">Editar Lugar</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>
                                    <div class="modal-body">
                                        <form action="gestionarLugares" method="post">
                                            <input type="hidden" name="accion" value="editar">
                                            <input type="hidden" name="idLugar" value="<%= lugar.getIdLugar()%>">
                                            <div class="form-group">
                                                <label for="nombre">Nombre:</label>
                                                <input type="text" class="form-control" id="nombre" name="nombre" value="<%= lugar.getNombre()%>" required>
                                            </div>
                                            <div class="form-group">
                                                <label for="ciudad">Ciudad:</label>
                                                <input type="text" class="form-control" id="ciudad" name="ciudad" value="<%= lugar.getCiudad()%>" required>
                                            </div>
                                            <div class="form-group">
                                                <label for="descripcion">Descripción:</label>
                                                <textarea class="form-control" id="descripcion" name="descripcion" required><%= lugar.getDescripcion()%></textarea>
                                            </div>
                                            <div class="form-group">
                                                <label for="puntuacion">Puntuación:</label>
                                                <input type="number" class="form-control" id="puntuacion" name="puntuacion" value="<%= lugar.getPuntuacion()%>" min="1" max="5" required>
                                            </div>
                                            <button type="submit" class="btn btn-primary mt-2">Actualizar Lugar</button>
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </td>
                </tr>
                <%
                }
            } else {
            %>
            <tr>
                <td colspan="7">No hay servicios registrados.</td>
            </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </section>

</div>

<%@include file="lib/footer.jsp" %>

