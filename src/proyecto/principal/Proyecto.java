/*
    https://stackoverflow.com/questions/18852059/java-list-containsobject-with-field-value-equal-to-x
    link para en un futuro comprobar los usuarios haciendo override de equals
    Programa que permite crear un usuario
    Despues de hacer login, podra ver los mensajes que tiene almacenados o escribir mensajes y almacenarlos.
 */
package proyecto.principal;

/**
 *
 * @author antonio arias bocero
 */
import java.util.ArrayList;
import proyecto.clases.Mensaje;
import proyecto.clases.Usuario;
import proyecto.util.Utilidades;

public class Proyecto {

    public static void main(String[] args) {
        
        String[] menuPrincipal = {"Salir", "Hacer login", "Crear usuario"};
        //creamos un arraylist de tipo Usuario almacenar los usuarios
        ArrayList<Usuario> arraylistCuentas = new ArrayList<Usuario>();
        //metemos valores para que ya haya algunos usuarios
        arraylistCuentas.add(new Usuario("admin", "admin"));
        arraylistCuentas.add(new Usuario("asd", "asd"));
        arraylistCuentas.add(new Usuario("zxc", "zxc"));
        //añadimos a los usuarios algunos mensajes creados de manera aleatoria
        Usuario.rellenarMensajesAleatorios(arraylistCuentas);
        String opcion;
        boolean error;
        boolean salir = false;
        do {
            error = false;
            //mostramos el menu principal por pantalla
            Utilidades.mostrarMenu(menuPrincipal);
            //pedimos la opcion al usuario
            opcion = Utilidades.pedirString("Introduzca opcion a realizar: ");
            System.out.println("");
            //comprobamos que la opcion esta dentro de los valores permitido
            if (opcion.equals("1") || opcion.equals("2") || opcion.equals("0")) {
                switch (opcion) {
                    case "1"://opcion de entrar con tu usuario
                        int usuarioConectado = Usuario.hacerLogin(arraylistCuentas);
                        //si se ha hecho login correcto, se pasa al segundo menu
                        if (usuarioConectado > 0) {
                            String opcion2;
                            do {                                
                                String[] menuUsuario = {"Log out", "Escribir mensaje", "Leer mensajes previamente escritos"};
                                Utilidades.mostrarMenu(menuUsuario, "Logeado como " + arraylistCuentas.get(usuarioConectado).getNombre());
                                opcion2 = Utilidades.pedirString("Introduzca opcion a realizar");
                                switch (opcion2) {
                                    case "1":
                                        //crear mensaje
                                        Mensaje.crearMensaje(arraylistCuentas, usuarioConectado);
                                        break;
                                    case "2":
                                        //ver todos los mensajes
                                        Mensaje.verTodosLosMensajes(arraylistCuentas, usuarioConectado);
                                        break;
                                    case "0":
                                        System.out.println("Haciendo logout. ");
                                        break;
                                    default:
                                        System.out.println("\nPor favor introduzca una opcion valida. ");
                                        break;
                                }
                            } while (!opcion2.equals("0"));
                        }
                        break;
                    case "2"://opcion de crear un usuario
                        Usuario.crearUsuario(arraylistCuentas);
                        break;
                    case "0":
                        salir = true;//opcion de salir
                        break;
                }
            } else {
                System.out.println("Por favor introduzca una opcion correcta.");
                error = true;
            }
        } while (error || !salir);
        //indicamos al usuario que el programa se termina
        System.out.println("");
        System.out.println("Cerrando el programa.");

    }

}
