package mundo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ManejoArchivos {

    // Método para guardar un usuario en el archivo
    public static void guardarUsuario(Usuario usuario, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(usuario.getNombreUsu() + ","
                    + usuario.getCorreo() + ","
                    + usuario.getContrasena() + "\n");
            System.out.println("Usuario: " + usuario.getNombreUsu() + " guardado correctamente. ");
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al guardar el usuario: " + e.getMessage());
        }
    }

// Método para validar un usuario basado en su correo y contraseña
    public static boolean validarUsuario(String correo, String contrasena, String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] fields = line.split(",");
                // Validamos el correo y la contraseña
                if (fields[1].equals(correo) && fields[2].equals(contrasena)) {
                    return true; // Usuario validado correctamente
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Error al validar el usuario: " + e.getMessage());
        }
        return false; // Correo no encontrado o contraseña incorrecta
    }
    
    // Método para cargar viajes desde el archivo
    public static ListaCircularSimple cargarViajes(String filePath) {
        ListaCircularSimple listaViajes = new ListaCircularSimple();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] campos = line.split(",");
                int idViaje = Integer.parseInt(campos[0]);
                String destino = campos[1];
                String duracion = campos[2];
                double precio = Double.parseDouble(campos[3]);
                listaViajes.agregar(new Viajes(idViaje, destino, duracion, precio));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaViajes;
    }

    public static void guardarFactura(String factura, String filePath) {
        try (FileWriter writer = new FileWriter(filePath, true)) {
            writer.write(factura + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
