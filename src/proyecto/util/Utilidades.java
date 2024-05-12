/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto.util;

import java.util.Scanner;

/**
 *
 * @author antonio
 */
public class Utilidades {
    
    /**
     * Metodo para mostrar un menu segun las opciones introducidas
     *
     * @param b array de string que contiene las opciones a mostrar en el menu
     */
    public static void mostrarMenu(String[] b) {
        System.out.println("\n---------------------------------------------");
        System.out.println("MENU");
        System.out.println("---------------------------------------------");
        for (int i = 0; i < b.length; i++) {
            System.out.println(i + "." + b[i]);
        }
        System.out.println("---------------------------------------------");
    }
    
    /**
     * Metodo para mostrar un menu segun las opciones introducidas
     * @param b array de string que contiene las opciones a mostrar en el menu
     * @param a String para la cabecera del menu
     */
    public static void mostrarMenu(String[] b,String a) {
        System.out.println("\n---------------------------------------------");
        System.out.println(a);
        System.out.println("---------------------------------------------");
        for (int i = 0; i < b.length; i++) {
            System.out.println(i + "." + b[i]);
        }
        System.out.println("---------------------------------------------");
    }
    
    
    /**
     * Metodo para pedir un numero por teclado
     *
     * @param s String para mostrar al usuario e indicarle que tiene que introducir
     * @return el numero int que el usuario ha introducido
     */
    public static int pedirNumero(String s) {
        int a;
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        return a;
    }
    
    /**
     * Metodos para pedir un numero por teclado
     *
     * @return el numero int que el usuario ha introducido
     */
    public static int pedirNumero() {
        int a;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextInt();
        return a;
    }
    
    /**
     * Metodos para pedir una cadena por teclado
     *
     * @return el numero int que el usuario ha introducido
     */
    public static String pedirString() {
        String a;
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine();
        return a;
    }
    
    /**
     * Metodos para pedir un numero por teclado
     *
     * @param s String para mostrar al usuario e indicarle que tiene que introducir
     * @return el numero int que el usuario ha introducido
     */
    public static String pedirString(String s) {
        String a;
        System.out.println(s);
        Scanner scanner = new Scanner(System.in);
        a = scanner.nextLine();
        return a;
    }
    
    /**
     * Metodo para generar arrays int bidimensionales con dimensiones y rango de valores especificados para generar valores aleatorios
     * @param x numero filas
     * @param y numero columnas
     * @param valorMinimo valor minimo que puede haber en el array
     * @param valorMaximo valor maximo que puede haber en el array
     * @return array int bidimensional 
     */
    public static int[][] generaArrayBiInt(int x,int y, int valorMinimo, int valorMaximo) {
        int[][] arrayNum = new int[x][y];
        for (int i = 0; i < arrayNum.length; i++) {
            for (int j = 0; j < arrayNum[i].length; j++) {
                arrayNum[i][j] = (int) (Math.random() * (valorMaximo - valorMinimo + 1)) + valorMinimo;
            }            
        }
        return arrayNum;
    }
    
    /**
     * MEtodo para recorrer y mostrar un array int bidimensional
     * @param arrayNumBi array bidimensional que se quiere imprimir por pantalla
     */
    public static void mostrarArrayBiInt(int[][] arrayNumBi) {
        for (int[] is : arrayNumBi) {
            System.out.println("");
            for (int i : is) {
                System.out.printf("%d \t| ", i);
            }
        }       
    } 
}
