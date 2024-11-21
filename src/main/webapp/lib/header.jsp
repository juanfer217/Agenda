<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="mundo.Contacto"%>
<%@page import="java.util.LinkedList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz" crossorigin="anonymous"></script>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <link rel="stylesheet" href="styles/navbar.css">
        <script src="https://kit.fontawesome.com/424ce1386e.js" crossorigin="anonymous"></script>
        <title>Agenda de Contactos</title>
    </head>
    <nav class="navbar">
        <div class="navbar-container">
            <a class="navbar-brand">Mi Agenda</a>
            <ul class="navbar-menu">
                <li><a href="agenda.jsp">Contactos</a></li>
                <li><a href="lugares.jsp">Lugares Visitados</a></li>
                <li><a href="viajes.jsp">Viajes</a></li>
                <li><a href="login.jsp" class="active">Cerrar Sesión</a></li>
            </ul>
        </div>
    </nav>
    



