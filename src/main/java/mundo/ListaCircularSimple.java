package mundo;
import java.util.ArrayList;

// Clase que representa una lista circular enlace simple

import java.util.ArrayList;

public class ListaCircularSimple {

    Nodo cabeza;
    Nodo ultimo;

    // Nodo inicial de la lista
    // Nodo final de la lista
    // Clase interna para representar un nodo
    private class Nodo {

        Viajes viaje;
        Nodo siguiente;

        Nodo(Viajes viaje) {
            this.viaje = viaje;
            this.siguiente = null;

        }
    }

    // Método para agregar un producto a la lista
    public void agregar(Viajes viaje) {
        Nodo nuevoNodo = new Nodo(viaje);

        // Si la lista está vacía
        if (cabeza == null) {
            cabeza = nuevoNodo;  // El nuevo nodo es la cabeza
            ultimo = nuevoNodo;  // También es el último nodo
            nuevoNodo.siguiente = cabeza; // El siguiente apunta a sí mismo para mantener la circularidad
        } else {
            // De lo contrario, agregar el nodo al final y mantener la circularidad
            ultimo.siguiente = nuevoNodo; // El último nodo apunta al nuevo nodo
            nuevoNodo.siguiente = cabeza; // El nuevo nodo apunta a la cabeza
            ultimo = nuevoNodo; // Actualizamos el último nodo
        }
    }

    // Método para obtener todos los productos en la lista
    public ArrayList<Viajes> obtenerViajes() {
        ArrayList<Viajes> listaViajes = new ArrayList<>();
        if (cabeza != null) {
            Nodo temp = cabeza;
            do {
                listaViajes.add(temp.viaje);
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        return listaViajes;
    }

    // Método para calcular el total de los viajes seleccionados
    public double calcularTotal() {
        double varAcumulador = 0;
        if (cabeza != null) {
            Nodo temp = cabeza;
            do {
                varAcumulador += temp.viaje.getPrecio();
                temp = temp.siguiente;
            } while (temp != cabeza);
        }
        return varAcumulador;
    }
}
