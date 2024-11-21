package mundo;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class GestionarLugares {

    private ListaDoble listaDoble;

    public GestionarLugares() {
        this.listaDoble = new ListaDoble();
        cargarLugares();
    }

    public List<Lugar> listarLugares() {
        return listaDoble.listar();
    }

    public void agregarLugar(int idLugar, String nombre, String ciudad, String descripcion, int puntuacion) {
        Lugar nuevoLugar = new Lugar(idLugar, nombre, ciudad, descripcion, puntuacion);
        listaDoble.agregar(nuevoLugar);
        guardarLugares();
    }

    public void eliminarLugar(int idLugar) {
        listaDoble.eliminar(idLugar);
        guardarLugares();
    }

    public void editarLugar(int idLugar, String nombre, String ciudad, String descripcion, int puntuacion) {
        listaDoble.editar(idLugar, nombre, ciudad, descripcion, puntuacion);
        guardarLugares();
    }

    public Lugar obtenerLugar(int idLugar) {
        return listaDoble.obtener(idLugar);
    }

    private void guardarLugares() {
    File directorio = new File("data");
    if (!directorio.exists()) {
        boolean creado = directorio.mkdirs();
        if (creado) {
            System.out.println("Directorio 'data' creado correctamente.");
        } else {
            System.err.println("No se pudo crear el directorio 'data'.");
            return;
        }
    }

    // Ahora guarda los lugares en el archivo 'lugares.txt'
    try (BufferedWriter writer = new BufferedWriter(new FileWriter("data/lugares.txt"))) {
        for (Lugar lugar : listarLugares()) {
            String linea = lugar.getIdLugar() + "|" + lugar.getNombre() + "|" +
                           lugar.getCiudad() + "|" + lugar.getDescripcion() + "|" +
                           lugar.getPuntuacion();
            writer.write(linea);
            writer.newLine();
        }
    } catch (IOException e) {
        System.err.println("Error al guardar los lugares: " + e.getMessage());
    }
}



    private void cargarLugares() {
        // Verifica si el archivo existe en el directorio 'data'
        File archivo = new File("data/lugares.txt");
        if (!archivo.exists()) {
            System.out.println("El archivo 'lugares.txt' no existe.");
            return; // Si no existe el archivo, no hace nada
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                String[] partes = linea.split("\\|");
                int idLugar = Integer.parseInt(partes[0]);
                String nombre = partes[1];
                String ciudad = partes[2];
                String descripcion = partes[3];
                int puntuacion = Integer.parseInt(partes[4]);

                Lugar lugar = new Lugar(idLugar, nombre, ciudad, descripcion, puntuacion);
                listaDoble.agregar(lugar);
            }
        } catch (Exception e) {
            System.err.println("Error al cargar los lugares: " + e.getMessage());
        }
    }

}
