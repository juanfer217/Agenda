package mundo;

public class Lugar {
    
    private int idLugar;
    private String nombre;
    private String ciudad;
    private String descripcion;
    private int puntuacion;

    public Lugar() {
    }

    public Lugar(int idLugar, String nombre, String ciudad, String descripcion, int puntuacion) {
        this.idLugar = idLugar;
        this.nombre = nombre;
        this.ciudad = ciudad;
        this.descripcion = descripcion;
        this.puntuacion = puntuacion;
    }

    public int getIdLugar() {
        return idLugar;
    }

    public void setIdLugar(int idLugar) {
        this.idLugar = idLugar;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
    
}
