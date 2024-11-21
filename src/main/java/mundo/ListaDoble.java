package mundo;

import java.util.ArrayList;
import java.util.List;

public class ListaDoble {

    private NodoDoble cabeza;

    public ListaDoble() {
        this.cabeza = null;
    }

    // Método para agregar un lugar a la lista doble
    public void agregar(Lugar lugar) {
        NodoDoble nuevoNodo = new NodoDoble(lugar);
        if (cabeza == null) {
            cabeza = nuevoNodo;
        } else {
            NodoDoble temp = cabeza;
            while (temp.getSiguiente() != null) {
                temp = temp.getSiguiente();
            }
            temp.setSiguiente(nuevoNodo);
            nuevoNodo.setAnterior(temp);
        }
    }

    // Método para listar los lugares en la lista doble
    public List<Lugar> listar() {
        List<Lugar> lugares = new ArrayList<>();
        NodoDoble temp = cabeza;
        while (temp != null) {
            lugares.add(temp.getLugar());
            temp = temp.getSiguiente();
        }
        return lugares;
    }

    // Método para eliminar un lugar por id
    public void eliminar(int idLugar) {
        if (cabeza == null) {
            return;
        }

        if (cabeza.getLugar().getIdLugar() == idLugar) {
            cabeza = cabeza.getSiguiente();
            if (cabeza != null) {
                cabeza.setAnterior(null);
            }
        } else {
            NodoDoble temp = cabeza;
            while (temp.getSiguiente() != null && temp.getSiguiente().getLugar().getIdLugar() != idLugar) {
                temp = temp.getSiguiente();
            }
            if (temp.getSiguiente() != null) {
                temp.setSiguiente(temp.getSiguiente().getSiguiente());
                if (temp.getSiguiente() != null) {
                    temp.getSiguiente().setAnterior(temp);
                }
            }
        }
    }

    // Método para editar un lugar
    public void editar(int idLugar, String nombre, String ciudad, String descripcion, int puntuacion) {
        NodoDoble temp = cabeza;
        while (temp != null) {
            if (temp.getLugar().getIdLugar() == idLugar) {
                temp.getLugar().setNombre(nombre);
                temp.getLugar().setCiudad(ciudad);
                temp.getLugar().setDescripcion(descripcion);
                temp.getLugar().setPuntuacion(puntuacion);
                return;
            }
            temp = temp.getSiguiente();
        }
    }

    // Método para obtener un lugar por id
    public Lugar obtener(int idLugar) {
        NodoDoble temp = cabeza;
        while (temp != null) {
            if (temp.getLugar().getIdLugar() == idLugar) {
                return temp.getLugar();
            }
            temp = temp.getSiguiente();
        }
        return null; // Retorna null si no se encuentra el lugar con el id
    }
}
