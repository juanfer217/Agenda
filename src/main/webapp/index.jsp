<link rel="stylesheet" href="styles/registro.css">

<div class="container">
    <div class="form-container">
        <h1>Registro</h1>
        <h5>Crea una cuenta nueva</h5>
        <form action="ServletNewUsuarios" method="POST" onsubmit="return validarContraseña();">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" placeholder="Ingresa tu nombre" required>
            </div>
            <div class="form-group">
                <label for="email">Correo Electrónico</label>
                <input type="text" id="correo" name="correo" placeholder="Ingresa tu correo" required>
            </div>
            <div class="form-group">
                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" placeholder="Crea una contraseña" required>
            </div>
            <div class="form-group">
                <label for="confirmarPassword">Confirmar Contraseña</label>
                <input type="password" id="confirmarPassword" name="confirmarPassword" placeholder="Confirma tu contraseña" required>
            </div>
            <button type="submit" class="btn">Registrarse</button>
        </form>
        <p class="text-center mt-3">
            ¿Ya tienes una cuenta? <a href="login.jsp" class="link">Inicia sesión</a>
        </p>
    </div>
</div>

<script>
    // Función para validar que la contraseña y la confirmación de la contraseña sean iguales
    function validarContraseña() {
        var password = document.getElementById("password").value;
        var confirmarPassword = document.getElementById("confirmarPassword").value;

        if (password !== confirmarPassword) {
            alert("Las contraseñas no coinciden. Por favor, intenta nuevamente.");
            return false; // Previene el envío del formulario si las contraseñas no coinciden
        }

        return true; // Si las contraseñas coinciden, permite el envío del formulario
    }
</script>
