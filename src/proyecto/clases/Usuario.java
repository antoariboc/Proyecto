/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.clases;

import java.util.ArrayList;
import static proyecto.util.Utilidades.*;

/**
 *
 * @author antonio
 */
public class Usuario {

    private String nombre;
    private String contrasena;
    private ArrayList<Mensaje> mensajes;

    public Usuario(String nombre, String contrasena) {
        this.nombre = nombre;
        this.contrasena = contrasena;
        this.mensajes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", contrasena=" + contrasena + '}';
    }

    /**
     * Metodo para crear un usuario y guardarlo en el arraylist que se pasa como parametro
     * @param a arrayList de la clase Usuario que contiene todos los usuarios
     */
    public static void crearUsuario(ArrayList<Usuario> a) {
        String nombre;
        String contrasena;
        boolean nombreUsuarioRepetido;
        Usuario usu = new Usuario("", "");
        do {
            nombreUsuarioRepetido = false;
            nombre = pedirString("Introduzca su nombre de usuario: ");
            for (Usuario usuario : a) {
                if (nombre.equals(usuario.getNombre())) {
                    System.out.println("Ese nombre de usuario ya existe.");
                    nombreUsuarioRepetido = true;
                    break;
                }
            }
            if (!nombreUsuarioRepetido) {
                do {
                    contrasena = pedirString("Introduzca la contrasena('0' como contrasena sera considerada no valida): ");
                    if (contrasena.equals("0") || contrasena.equals("")) {
                        System.out.println("Contrasena no valida.");
                    }
                } while (contrasena.equals("0") || contrasena.equals(""));
                usu = new Usuario(nombre, contrasena);
            }
            if ((!usu.getNombre().equals("") || !usu.getContrasena().equals("")) && !nombreUsuarioRepetido) {
                a.add(usu);
                System.out.println("Usuario creado.");
            }
        } while (nombreUsuarioRepetido);
    }

    /**
     * Metodo para hacer login con un usuario existente
     * @param a arrayList de la clase Usuario que contiene todos los usuarios
     * @return numero int de la posicion del usuario que hace login, o -1 si no existe
     */
    public static int hacerLogin(ArrayList<Usuario> a) {
        boolean nombreUsuarioRepetido;
        do {
            nombreUsuarioRepetido = false;
            String nombre = pedirString("Introduzca su nombre de usuario: ");
            for (Usuario usuario : a) {
                if (nombre.equals(usuario.getNombre())) {
                    nombreUsuarioRepetido = true;
                }
                if (nombreUsuarioRepetido) {
                    boolean contrasenaError= false;
                    String contrasena;
                    do {
                        if (contrasenaError) {
                            System.out.println("Contrasena erronea.Intente de nuevo o introduzca '0' para retroceder");
                        }
                        contrasenaError = false;                        
                        contrasena = pedirString("Introduzca su contrasena: ");
                        if (contrasena.equals(usuario.getContrasena())) {//si la contrasena es correcta, hacemos login
                            System.out.println("!Login con exito!");
                            return a.indexOf(usuario);
                        } else {
                            contrasenaError = true;
                                                        
                        }
                    } while (contrasenaError && !contrasena.equals("0"));
                    if (contrasena.equals("0")) {
                        break;
                    }
                }
            }
            if (!nombreUsuarioRepetido) {
                System.out.println("El usuario introducido no existe");
            }
        } while (!nombreUsuarioRepetido);
        return -1;
    }
    
    /**
     * Metodo para rellenar los mensajes de usuarios existentes con cadenas string aleatorias
     * @param a arrayList de la clase Usuario que contiene todos los usuarios
     */
    public static void rellenarMensajesAleatorios(ArrayList<Usuario> a){
        //cadena de caracteres para crear random strings
        String caracteres = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm0123456789,. ";
        int numRandom = 0;
        //bucle para rellenar mensajes con cadenas generadas aleatoriamente
        for (int i = 0; i < a.size(); i++) {//<3 porque son los usarios que existen ahora mismo
            for (int j = 0; j < 3; j++) {        
                String cadena = "";
                for (int k = 0; k < (int) (Math.random() * 100); k++) {//for de duracion aleatoria asta 99
                    numRandom = (int) (Math.random() * caracteres.length());                   
                    cadena += caracteres.charAt(numRandom);//concatenamos los valores a la cadena
                }
                a.get(i).getMensajes().add(new Mensaje(a.get(i).getMensajes().size(),cadena));//guardamos la cadena
            }
        }
    }
}
