import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @author Victor Pérez
 * @creationDate 11/11/2023
 * @modificationDate 11/11/2023
 * @description Encargada de la lectura del archivo CSV
 */
public class Archivo {
    private File documentoUsuarios;
    private File documentoReservas;

    /**
     * Constructor de clase
     */
    public Archivo() {
        this.documentoUsuarios = new File("usuarios.csv");
        this.documentoReservas = new File("reservas.csv");
    }


    /**
     * Almacena los usuarios en un archivo CSV
     * @param usuarios ArrayList con los usuarios a guardar
     */
    public void guardarUsuarios(ArrayList<Usuario> usuarios) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(documentoUsuarios));

        // Escribe el encabezado
        escritor.write("nombre,password,plan");
        escritor.newLine();

        for (Usuario usuario: usuarios) {
            escritor.write(usuario.getNombre() + "," + usuario.getPassword() + "," + usuario.getPlan());
            escritor.newLine();
        }

        escritor.close();
    }


    /**
     * Lee los usuarios contenidos en un archivo csv y los convierte en un ArrayList
     * @return ArrayList con los usuarios
     */
    public ArrayList<Usuario> leerUsuarios() throws IOException {
        ArrayList<Usuario> usuarios = new ArrayList<Usuario>();

        // Revisa que existe el CSV
        if (documentoUsuarios.exists()) {
            BufferedReader lector = new BufferedReader(new FileReader(documentoUsuarios));
            String linea = lector.readLine();

            // Lee cada línea del archivo
            while (linea != null) {
                String[] datos = linea.split(",");
                usuarios.add(new Usuario(datos[0], datos[1], datos[2]));

                linea = lector.readLine();
            }

            System.out.println("Se han cargado los usuarios");
            lector.close();
        }

        return usuarios;
    }


    /**
     * Almacena las reservas en un archivo CSV
     * @param reservas ArrayList con las reservas a guardar
     */
    public void guardarReservas(ArrayList<Reserva> reservas) throws IOException {
        BufferedWriter escritor = new BufferedWriter(new FileWriter(documentoReservas));

        // Escribe el encabezado
        escritor.write("fecha,idaVuelta,boletos,aerolinea,numero_tarjeta,cuotas,clase,numero_asiento,maletas");
        escritor.newLine();

        for (Reserva reserva: reservas) {
            escritor.write(reserva.getFecha() + "," + reserva.isIdaVuelta() + "," + reserva.getBoletos() + "," + reserva.getAerolinea() + "," + reserva.getNumTarjeta()
                            + "," + reserva.getCuotas() + "," + reserva.getClase() + "," + reserva.getNumAsiento() + "," + reserva.getMaletas());
            escritor.newLine();
        }

        escritor.close();
    }


    /**
     * Lee las reservas contenidas en un archivo csv y las convierte en un ArrayList
     * @return ArrayList con las reservas
     */
    public ArrayList<Reserva> leerReservas() throws IOException {
        ArrayList<Reserva> reservas = new ArrayList<Reserva>();

        // Revisa que existe el CSV
        if (documentoReservas.exists()) {
            BufferedReader lector = new BufferedReader(new FileReader(documentoReservas));
            String linea = lector.readLine();

            // Lee cada línea del archivo
            while (linea != null) {
                String[] datos = linea.split(",");
                reservas.add(new Reserva(datos[0], Boolean.parseBoolean(datos[1]), Integer.parseInt(datos[2]), datos[3], datos[4], Integer.parseInt(datos[5]), 
                            datos[6], datos[7], Integer.parseInt(datos[8])));

                linea = lector.readLine();
            }

            System.out.println("Se han cargado las reservas");
            lector.close();
        }

        return reservas;
    }
}
