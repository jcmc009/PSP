/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Padre {

    public static void main(String[] args) {
        // Leer desde la entrada estándar (lo que viene por la tubería)
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        // Almacenamos el texto en diversos String
        String mensajeMadre = "", mensajeEnviar = "", respuestaPadre = "";
        String rutaClase = System.getProperty("java.class.path");
        //Recibe el mensaje proveniente de Madre.java y lo guarda en un string
        try {
            mensajeMadre = reader.readLine();
        } catch (IOException ex) {
            ex.getMessage();
        }
        /*Para que se inicie el proceso, el mensaje debe ser distinto de nulo y que contenga la palabra Mario 
        asegurarnos que se envía el mensaje al sitio correcto, en caso contrario se devuelve un mensaje y no se inicia nada*/
        if (mensajeMadre != null && mensajeMadre.contains("Mario")) {
            respuestaPadre = "\n" + "(Despertando a Mario)";
            mensajeEnviar = mensajeMadre + respuestaPadre;

            try {
                ProcessBuilder programa = new ProcessBuilder("java", "Hijo.java");
                //Puede dar fallo por no encontrar fichero
                programa.directory(new File(rutaClase));
                Process iniciar = programa.start();
                // System.out.println("Programa funciona");
                enviarMensaje(iniciar, mensajeEnviar);
                recibirMensaje(iniciar);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Mensaje no reconocido");
        }

    }

    private static void enviarMensaje(Process iniciar, String mensajeAenviar) {
        try (
                BufferedWriter escribir = new BufferedWriter(new OutputStreamWriter(iniciar.getOutputStream()))) {
            escribir.write(mensajeAenviar);
            escribir.newLine(); // Esto añade un salto de línea final para que el hijo sepa que terminó el mensaje
            escribir.flush();   // Asegura que el mensaje se envíe
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void recibirMensaje(Process iniciar) {
        InputStream it = iniciar.getInputStream();
        InputStreamReader itr = new InputStreamReader(it);
        BufferedReader leer = new BufferedReader(itr);
        try {
            String linea = "";
            linea = leer.readLine();
            while (linea != null) {
                System.out.println(linea);
                linea = leer.readLine();

            }
            leer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
