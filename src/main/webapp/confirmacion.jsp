<%@include file="lib/header.jsp" %>
<link href="styles/confirmacion.css" rel="stylesheet" type="text/css"/>
<div class="confirmation-container">
    <div class="confirmation-box">
        <h2>Confirmación de Compra</h2>
        <p>¡Gracias por su compra!</p>
        <p><strong>Total pagado:</strong> $<%= request.getParameter("total") %></p>
        <a href="viajes.jsp" class="btn btn-primary">Regresar a viajes</a>
    </div>
</div>
<%@include file="lib/footer.jsp" %>
