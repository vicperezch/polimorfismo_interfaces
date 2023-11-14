/**
 * @author Victor Pérez
 * @creationDate 11/11/2023
 * @modificationDate 11/11/2023
 * @description Modela un usuario del programa y contiene su información
 */
public class Usuario {
    private String nombre;
    private String password;
    private String plan;

    /**
     * Constructor de clase
     * @param nombre Nombre del usuario
     * @param password Contraseña del usuariop
     * @param plan Plan (premium o no premium)
     */
    public Usuario(String nombre, String password, String plan) {
        this.nombre = nombre;
        this.password = password;
        this.plan = plan;
    }


    // Setters y getters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPlan() {
        return plan;
    }

    public void setPlan(String plan) {
        this.plan = plan;
    }
}
