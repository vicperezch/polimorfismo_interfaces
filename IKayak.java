/**
 * @author Victor Pérez
 * @creationDate 11/11/2023
 * @modificationDate 11/11/2023
 * @description Interfaz que contiene todos los métodos necesarios para las funcionalidades del programa
 */
public interface IKayak {
    
    public Usuario login(String nombreUsuario, String password);

    public void registroUsuario(String nombreUsuario, String password, String plan);

    public void cambiarPassword(String nuevaPassword);

    public void cambiarTipoUsuario();

    public void reservacion(String fecha, boolean idaVuelta, int boletos, String aerolinea, String nombreUsuario);
    
    public void confirmacion(String numTarjeta, int cuotas, String clase, String asiento, int maletas);

    public String itinerario();

    public void guardarUsuario();

    public void leerUsuario();

    public void guardarReserva();

    public void leerReserva();
}
