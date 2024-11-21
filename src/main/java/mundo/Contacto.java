package mundo;

public class Contacto {

    private String nombre;
    private String apellido;
    private long telefono; 
    private String email;
    private String direccion;

    public Contacto() {
    }

    public Contacto(String nombre, String apellido, long telefono, String email, String direccion) {  
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;  
        this.email = email;
        this.direccion = direccion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getTelefono() {  
        return telefono;  
    }

    public void setTelefono(long telefono) { 
        this.telefono = telefono; 
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
