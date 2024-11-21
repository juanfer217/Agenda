<link rel="stylesheet" href="styles/registro.css">

<div class="container">
    <div class="form-container">
        <h1>Registro</h1>
        <h5>Crea una cuenta nueva</h5>
        <form action="ServletNewUsuarios" method="POST" onsubmit="return validarContrase�a();">
            <div class="form-group">
                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" placeholder="Ingresa tu nombre" required>
            </div>
            <div class="form-group">
                <label for="email">Correo Electr�nico</label>
                <input type="text" id="correo" name="correo" placeholder="Ingresa tu correo" required>
            </div>
            <div class="form-group">
                <label for="password">Contrase�a</label>
                <input type="password" id="password" name="password" placeholder="Crea una contrase�a" required>
            </div>
            <div class="form-group">
                <label for="confirmarPassword">Confirmar Contrase�a</label>
                <input type="password" id="confirmarPassword" name="confirmarPassword" placeholder="Confirma tu contrase�a" required>
            </div>
            <button type="submit" class="btn">Registrarse</button>
        </form>
        <p class="text-center mt-3">
            �Ya tienes una cuenta? <a href="login.jsp" class="link">Inicia sesi�n</a>
        </p>
    </div>
</div>

<script>
    // Funci�n para validar que la contrase�a y la confirmaci�n de la contrase�a sean iguales
    function validarContrase�a() {
        var password = document.getElementById("password").value;
        var confirmarPassword = document.getElementById("confirmarPassword").value;

        if (password !== confirmarPassword) {
            alert("Las contrase�as no coinciden. Por favor, intenta nuevamente.");
            return false; // Previene el env�o del formulario si las contrase�as no coinciden
        }

        return true; // Si las contrase�as coinciden, permite el env�o del formulario
    }
</script>
