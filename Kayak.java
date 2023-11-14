import java.util.ArrayList;

/**
 * @author Victor Pérez
 * @creationDate 11/11/2023
 * @modificationDate 11/11/2023
 * @description Controlador que implementa la interfaz principal
 */
public class Kayak implements IKayak {
    private ArrayList<Usuario> usuarios;
    private ArrayList<Reserva> reservas;
    private Archivo archivo;
    private Usuario usuarioActual;
    private Reserva reservaActual;


    /**
     * Constructor de clase
     */
    public Kayak() {
        this.usuarios = new ArrayList<>();
        this.reservas = new ArrayList<>();
        this.archivo = new Archivo();
    }


    /**
     * Permite el inicio de sesión con una cuenta creada
     * @param nombreUsuario Nombre de la cuenta
     * @param password Contraseña del usuario
     */
    public Usuario login(String nombreUsuario, String password) {
        for (Usuario usuario: usuarios) {

            if (usuario.getNombre().equals(nombreUsuario) && usuario.getPassword().equals(password)) {
                this.usuarioActual = usuario;
                return usuario;
            }
        }

        return null;
    }


    /**
     * Registra un usuario del programa
     * @param nombreUsuario Nombre de la cuenta
     * @param password Contraseña del usuario
     * @param plan Tipo de plan (premium o no premium)
     */
    public void registroUsuario(String nombreUsuario, String password, String plan) {
        usuarios.add(new Usuario(nombreUsuario, password, plan));
    }


    /**
     * Cambia la contraseña de un usuario existente
     * @param nuevaPassword Nueva contraseña
     */
    public void cambiarPassword(String nuevaPassword) {
        usuarioActual.setPassword(nuevaPassword);
    }


    /**
     * Cambia el plan de un usuario
     */
    public void cambiarTipoUsuario() {
        usuarioActual.setPlan("premium");
    }


    /**
     * Crea una nueva reservación
     * @param fecha Fecha del vuelo
     * @param idaVuelta Indica si el vuelo es ida y vuelta (true) o solo ida (false)
     * @param boletos Cantidad de boletos a comprar
     * @param aerolinea Aerolínea encargada
     * @param nombreUsuario Nombre del usuario que hace la reservación
     */
    public void reservacion(String fecha, boolean idaVuelta, int boletos, String aerolinea, String nombreUsuario) {
        this.reservaActual = new Reserva(fecha, idaVuelta, boletos, aerolinea, "", 0, "", "", 0);
    }

    
    /**
     * Confirma una reservación existente
     * @param numTarjeta Número de la tarjeta para hacer el pago
     * @param cuotas Número de cuotas del pago
     * @param clase Clase del vuelo (primera clase o coach)
     * @param asiento Nümero de asiento
     * @param maletas Cantidad de maletas
     */
    public void confirmacion(String numTarjeta, int cuotas, String clase, String asiento, int maletas) {
        reservaActual.setNumTarjeta(numTarjeta);
        reservaActual.setCuotas(cuotas);
        reservaActual.setClase(clase);
        reservaActual.setNumAsiento(asiento);
        reservaActual.setMaletas(maletas);

        reservas.add(reservaActual);
    }


    /**
     * Permite mostrar el itinerario de una reservacion
     * @return String formateada con el itinerario
     */
    public String itinerario(){
        String itinerario = "";


        return itinerario;
    }


    /**
     * 
     */
    public void guardarUsuario() {

    }


    /**
     * 
     */
    public void leerUsuario() {

    }


    /**
     * 
     */
    public void guardarReserva(){

    }


    /**
     * 
     */
    public void leerReserva() {

    }
}
