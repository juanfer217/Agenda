package mundo;

public class Usuario {
    
    private String nombreUsu;
    private String correo;
    private String contrasena;

    public Usuario() {
    }

    public Usuario(String nombreUsu, String correo, String contrasena) {
        this.nombreUsu = nombreUsu;
        this.correo = correo;
        this.contrasena = contrasena;
    }

    public String getNombreUsu() {
        return nombreUsu;
    }

    public void setNombreUsu(String nombreUsu) {
        this.nombreUsu = nombreUsu;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
    
    
}
