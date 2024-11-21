package mundo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.LinkedList;
import javax.servlet.ServletContext;

public class AgendaContactos implements Serializable {

    private LinkedList<Contacto> misContactos;

    public void agregarContacto(Contacto contacto, ServletContext context) throws IOException {
        cargarContactosDesdeArchivo(context);
        misContactos.add(contacto);
        guardarContactosEnArchivo(context);
    }

    public void eliminarContacto(long telefono, ServletContext context) throws IOException {
        cargarContactosDesdeArchivo(context);
        if (misContactos != null) {
            Contacto contactoEliminar = null;
            for (Contacto ct : misContactos) {
                if (ct.getTelefono() == telefono) {
                    contactoEliminar = ct;
                    break;
                }
            }
            if (contactoEliminar != null) {
                misContactos.remove(contactoEliminar);
                guardarContactosEnArchivo(context);
            }
        }
    }

    public Contacto buscarContacto(long telefono, ServletContext context) {
        cargarContactosDesdeArchivo(context);
        for (Contacto ct : misContactos) {
            if (ct.getTelefono() == telefono) {
                return ct;
            }
        }
        return null;
    }

    public LinkedList<Contacto> getMisContactos(ServletContext context) {
        cargarContactosDesdeArchivo(context);
        return misContactos;
    }

    public void cargarContactosDesdeArchivo(ServletContext context) {
        String relativePath = "/data/contactos.txt";
        String absPath = context.getRealPath(relativePath);

        File archivo = new File(absPath);
        misContactos = new LinkedList<>();

        if (archivo.exists()) {
            try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] datos = linea.split(";");
                    long telefono = Long.parseLong(datos[0]);
                    String nombre = datos[1];
                    String apellido = datos[2];
                    String email = datos[3];
                    String direccion = datos[4];
                    Contacto contacto = new Contacto(nombre, apellido, telefono, email, direccion);
                    misContactos.add(contacto);
                }
            } catch (IOException e) {
                System.err.println("Error al cargar los contactos desde el archivo: " + e.getMessage());
            }
        }
    }

    public void guardarContactosEnArchivo(ServletContext context) {
        String relativePath = "/data/contactos.txt";
        String absPath = context.getRealPath(relativePath);

        File archivo = new File(absPath);
        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
            } catch (IOException e) {
                System.err.println("Error al crear el archivo de contactos: " + e.getMessage());
            }
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(archivo))) {
            for (Contacto ct : misContactos) {
                bw.write(ct.getTelefono() + ";" + ct.getNombre() + ";" + ct.getApellido() + ";" + ct.getEmail() + ";" + ct.getDireccion());
                bw.newLine();
            }
        } catch (IOException e) {
            System.err.println("Error al guardar los contactos en el archivo: " + e.getMessage());
        }
    }

    public void editarContacto(long telefono, String nuevoNombre, String nuevoApellido, String nuevoEmail, String nuevaDireccion, ServletContext context) throws IOException {
        if (nuevoNombre == null || nuevoNombre.isEmpty() || nuevoApellido == null || nuevoApellido.isEmpty()) {
            throw new IllegalArgumentException("Nombre y apellido no pueden ser nulos o vacíos");
        }

        Contacto contacto = buscarContacto(telefono, context);
        if (contacto == null) {
            throw new IllegalArgumentException("No se encontró el contacto con teléfono: " + telefono);
        }

        contacto.setNombre(nuevoNombre);
        contacto.setApellido(nuevoApellido);
        contacto.setEmail(nuevoEmail);
        contacto.setDireccion(nuevaDireccion);

        guardarContactosEnArchivo(context);
    }
}
