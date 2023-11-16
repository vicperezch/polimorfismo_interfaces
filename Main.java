import java.util.InputMismatchException;
import java.lang.Math;
import java.util.Scanner;

/**
 * @author Victor Pérez
 * @creationDate 14/11/2023
 * @modificationDate 15/11/2023
 * @description Encargada de la interacción con el usuario
 */
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean menuKayak = true;
        Usuario usuarioEnSesion;

        // Línea a modificar
        IKayak kayak = new Kayak();

        // Lee los csv
        kayak.leerUsuario();
        kayak.leerReserva();

        while (menuKayak) {

            // Menú de inicio
            System.out.println("--- KAYAK ---");
            System.out.println("1. Registrarse\n2. Iniciar sesión\n3. Salir");
            System.out.print("Seleccione una opción: ");

            try {
                int opcion = input.nextInt();
                input.nextLine();

                switch (opcion) {

                    // Opción de registrarse
                    case 1:
                        System.out.println("\nREGISTRO");
                        System.out.print("Nombre de usuario: ");
                        String nombreUsuario = input.nextLine();

                        System.out.print("Contraseña: ");
                        String passwordRegistro = input.nextLine();

                        System.out.print("Tipo de plan\n1. Base\n2. Premium\nOpción: ");
                        int plan = input.nextInt();
                        input.nextLine();

                        // Agrega el usuario de acuerdo con el plan elegido
                        if (plan == 1) {
                            kayak.registroUsuario(nombreUsuario, passwordRegistro, "base");

                        } else if (plan == 2) {
                            kayak.registroUsuario(nombreUsuario, passwordRegistro, "premium");

                        } else {
                            System.out.println("Ingrese una opción válida");
                        }

                        break;
                    
                    // Opción de iniciar sesión
                    case 2:
                        System.out.println("\nINICIO DE SESION");
                        System.out.print("Nombre de usuaro: ");
                        String nombre = input.nextLine();

                        System.out.print("Contraseña: ");
                        String password = input.nextLine();

                        if (kayak.login(nombre, password) != null) {
                            usuarioEnSesion = kayak.login(nombre, password);
                            boolean menuPrincipal = true;
                            
                            // Sesión iniciada
                            while (menuPrincipal) {
                                System.out.println("\n--- MENU PRINCIPAL ---");
                                System.out.println("1. Modo reservas\n2. Modo confirmacion\n3. Modo perfil\n4. Cerrar sesión");
                                System.out.print("Seleccione una opción: ");

                                try {
                                    opcion = input.nextInt();
                                    input.nextLine();

                                    switch (opcion) {
                                        // Modo reserva
                                        case 1:
                                            System.out.print("Fecha (dd/MM/yyyy): ");
                                            String fecha = input.nextLine();

                                            System.out.print("Tipo de vuelo\n1. Ida y vuelta\n2. Ida\nOpción: ");
                                            int tipoVuelo = input.nextInt();
                                            input.nextLine();

                                            System.out.print("Cantidad de boletos: ");
                                            int boletos = input.nextInt();
                                            input.nextLine();

                                            System.out.print("Aerolínea: ");
                                            String aerolinea = input.nextLine();

                                            if (tipoVuelo == 1) {
                                                kayak.reservacion(fecha, true, boletos, aerolinea, usuarioEnSesion.getNombre());

                                            } else {
                                                kayak.reservacion(fecha, false, boletos, aerolinea, usuarioEnSesion.getNombre());
                                            }

                                            break;

                                        // Modo confirmación
                                        case 2:
                                            System.out.print("Número de tarjeta: ");
                                            String numTarjeta = input.nextLine();
                                            
                                            if (usuarioEnSesion.getPlan().toLowerCase().equals("base")) {
                                                System.out.print("Cantidad de cuotas: ");
                                                int cuotas = input.nextInt();
                                                input.nextLine();

                                                System.out.print("Clase\n1. Coach\n2. Primera clase\nOpción: ");
                                                int opClase = input.nextInt();
                                                input.nextLine();

                                                String asiento = "" + Math.random() * 50;

                                                if (opClase == 1) {
                                                    kayak.confirmacion(numTarjeta, cuotas, "coach", asiento, 1);
                                                    System.out.println(kayak.itinerario());

                                                } else if (opClase == 2) {
                                                    kayak.confirmacion(numTarjeta, cuotas, "primera clase", asiento, 1);
                                                    System.out.println(kayak.itinerario());

                                                } else {
                                                    System.out.println("Ingrese una opción válida");
                                                }

                                            } else {
                                                System.out.print("Numero de asiento: ");
                                                String numAsiento = input.nextLine();

                                                System.out.print("Número de maletas: ");
                                                int numMaletas = input.nextInt();
                                                input.nextLine();

                                                kayak.confirmacion(numTarjeta, 1, "primera clase", numAsiento, numMaletas);
                                                System.out.println(kayak.itinerario());
                                            }

                                            break;

                                        // Modo perfil
                                        case 3:
                                            System.out.println("\nMODO PERFIL");

                                            if (usuarioEnSesion.getPlan().toLowerCase().equals("base")) {
                                                System.out.println("1. Cambiar a premium\n2. Aplicar cupón de 10% de descuento\n3. Cambiar contraseña");
                                                System.out.print("Seleccione una opción: ");
                                                opcion = input.nextInt();
                                                input.nextLine();

                                                switch (opcion) {

                                                    // Cambiar a plan premium
                                                    case 1:
                                                        kayak.cambiarTipoUsuario();
                                                        System.out.println("Ha cambiado a plan premium");
                                                        break;

                                                    // Aplicar cupón de descuento
                                                    case 2:
                                                        System.out.println("Se ha aplicado un 10% de descuento");
                                                        break;

                                                    // Cambiar contraseña
                                                    case 3:
                                                        System.out.print("Nueva contraseña: ");
                                                        String nuevaPassword = input.nextLine();

                                                        kayak.cambiarPassword(nuevaPassword);
                                                        break;
                                                }

                                            } else {
                                                    System.out.println("¿Desea cambiar su contraseña?");
                                                    System.out.println("1. Sí\n2. No");
                                                    System.out.print("Seleccione una opción: ");
                                                    opcion = input.nextInt();
                                                    input.nextLine();

                                                    if (opcion == 1) {
                                                        System.out.print("Nueva contraseña: ");
                                                        String nuevaPass = input.nextLine();

                                                        kayak.cambiarPassword(nuevaPass);
                                                    }
                                                }

                                            break;

                                        // Cerrar sesión
                                        case 4:
                                            menuPrincipal = false;
                                            kayak.guardarReserva();
                                            System.out.println("Ha cerrado su sesión\n");
                                    }

                                } catch (InputMismatchException e) {
                                    input.nextLine();
                                    System.out.println("\nIngreso inválido (solo los números están permitidos)\n");
                                }
                            }

                        // Fallo al iniciar sesión
                        } else {
                            System.out.println("El nombre o la contraseña son incorrectos\n");
                        }

                        break;
                    
                    // Opción de salir
                    case 3:
                        kayak.guardarUsuario();
                        menuKayak = false;
                }

            } catch (InputMismatchException e) {
                input.nextLine();
                System.out.println("\nIngreso inválido (solo los números están permitidos)\n");
            }
        }

        input.close();
    }
}