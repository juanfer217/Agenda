<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Login</title>
    <link rel="stylesheet" href="styles/login.css">
</head>
<body>
    <div class="container">
        <div class="form-container">
            <h1>Iniciar Sesión</h1>
            <h5>Accede a tu cuenta</h5>
            <form action="loginServlet" method="post">
                <div class="form-group">
                    <label for="username">Usuario:</label>
                    <input type="text" id="correo" name="correo" placeholder="Ingresa correo electrónico" required>
                </div>
                <div class="form-group">
                    <label for="password">Contraseña:</label>
                    <input type="password" id="password" name="password" placeholder="Ingresa tu contraseña" required>
                </div>
                <button type="submit" class="btn">Ingresar</button>
            </form>
            <p class="register-link">
                ¿No tienes una cuenta? 
                <a href="index.jsp">Crear Cuenta</a>
            </p>
        </div>
    </div>

</body>
</html>
