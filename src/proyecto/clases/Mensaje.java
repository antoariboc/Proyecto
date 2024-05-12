/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.clases;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import proyecto.util.Utilidades;

/**
 *
 * @author antonio
 */
public class Mensaje {
    private int mensajeId;
    private String mensajeCuerpo;
    private Date fecha;

    public Mensaje(int mensajeId, String mensajeCuerpo) {
        this.mensajeId = mensajeId;
        this.mensajeCuerpo = mensajeCuerpo;
        this.fecha = GregorianCalendar.getInstance().getTime();
    }

    public int getMensajeId() {
        return mensajeId;
    }

    public void setMensajeId(int mensajeId) {
        this.mensajeId = mensajeId;
    }

    public String getMensajeCuerpo() {
        return mensajeCuerpo;
    }

    public void setMensajeCuerpo(String mensajeCuerpo) {
        this.mensajeCuerpo = mensajeCuerpo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        
        return "\nMensaje "+mensajeId+"\t\t\t"+fecha+"\n"+mensajeCuerpo+"\n------------------------------------------------------";
    }
    
    /**
     * Metodo crear y añadir un mensaje al arraylist de mensajes del usuario actualmente logeado
     * @param listaUsuarios arrayList de la clase Usuario que contiene todos los usuarios
     * @param usuarioLogeado numero int de la posicion del usuario actualmente logeado en el arraylist
     */
    public static void crearMensaje(ArrayList<Usuario> listaUsuarios, int usuarioLogeado){
        listaUsuarios.get(usuarioLogeado).getMensajes().add(new Mensaje(listaUsuarios.get(usuarioLogeado).getMensajes().size(),Utilidades.pedirString("Introduzca su mensaje: ")));
    }
    
    /**
     * Metodo para ver todos los mensajes por consola del usuario actualmente logeado
     * @param listaUsuarios arrayList de la clase Usuario que contiene todos los usuarios
     * @param usuarioLogeado numero int de la posicion del usuario actualmente logeado en el arraylist
     */
    public static void verTodosLosMensajes(ArrayList<Usuario> listaUsuarios, int usuarioLogeado){
        System.out.println("Estos son los mensajes actualmente guardados en su cuenta: ");
        for (Mensaje m : listaUsuarios.get(usuarioLogeado).getMensajes()) {
            System.out.println(m.toString());
        }
    }
    
}
