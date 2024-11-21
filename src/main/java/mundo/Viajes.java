package mundo;

public class Viajes {
    private int idViaje;
    private String destino;
    private String duracion;
    private double precio;

    public Viajes() {
    }

    public Viajes(int idViaje, String destino, String duracion, double precio) {
        this.idViaje = idViaje;
        this.destino = destino;
        this.duracion = duracion;
        this.precio = precio;
    }

    public int getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(int idViaje) {
        this.idViaje = idViaje;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    
}
