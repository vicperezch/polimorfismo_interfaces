/**
 * @author Victor Pérez
 * @creationDate 11/11/2023
 * @modificationDate 11/11/2023
 * @description Modela una reserva realizada por un usuario y almacena la información
 */
public class Reserva {
    private String fecha;
    private boolean idaVuelta;
    private int boletos;
    private String aerolinea;
    private String numTarjeta;
    private int cuotas;
    private String clase;
    private String numAsiento;
    private int maletas;


    /**
     * Constructor de clase
     * @param fecha Fecha del vuelo
     * @param idaVuelta true si el vuelo es ida y vuelta, false si es ida
     * @param boletos Cantidad de boletos a comprar
     * @param aerolinea Aerolínea encargada
     * @param numTarjeta Número de tarjeta para realizar el pago
     * @param cuotas Número de cuotas
     * @param clase Clase del vuelo (Primera Clase o Coach)
     * @param numAsiento Número del asiento
     * @param maletas Número de maletas
     */
    public Reserva(String fecha, boolean idaVuelta, int boletos, String aerolinea, String numTarjeta, int cuotas, String clase, String numAsiento, int maletas) {
        this.fecha = fecha;
        this.idaVuelta = idaVuelta;
        this.boletos = boletos;
        this.aerolinea = aerolinea;
        this.numTarjeta = numTarjeta;
        this.cuotas = cuotas;
        this.clase = clase;
        this.numAsiento = numAsiento;
        this.maletas = maletas;
    }


    // Setters y getters
    public String getFecha() {
        return fecha;
    }


    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public boolean isIdaVuelta() {
        return idaVuelta;
    }


    public void setIdaVuelta(boolean idaVuelta) {
        this.idaVuelta = idaVuelta;
    }


    public int getBoletos() {
        return boletos;
    }


    public void setBoletos(int boletos) {
        this.boletos = boletos;
    }


    public String getAerolinea() {
        return aerolinea;
    }


    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }


    public String getNumTarjeta() {
        return numTarjeta;
    }


    public void setNumTarjeta(String numTarjeta) {
        this.numTarjeta = numTarjeta;
    }


    public int getCuotas() {
        return cuotas;
    }


    public void setCuotas(int cuotas) {
        this.cuotas = cuotas;
    }


    public String getClase() {
        return clase;
    }


    public void setClase(String clase) {
        this.clase = clase;
    }


    public String getNumAsiento() {
        return numAsiento;
    }


    public void setNumAsiento(String numAsiento) {
        this.numAsiento = numAsiento;
    }


    public int getMaletas() {
        return maletas;
    }


    public void setMaletas(int maletas) {
        this.maletas = maletas;
    }


    
}
