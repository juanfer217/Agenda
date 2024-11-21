package mundo;

public class NodoDoble {
    
    private Lugar lugar;
    private NodoDoble siguiente;
    private NodoDoble anterior;

    public NodoDoble(Lugar lugar) {
        this.lugar = lugar;
        this.siguiente = null;
        this.anterior = null;
    }

    public Lugar getLugar() {
        return lugar;
    }

    public NodoDoble getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoDoble siguiente) {
        this.siguiente = siguiente;
    }

    public NodoDoble getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoDoble anterior) {
        this.anterior = anterior;
    }
}
