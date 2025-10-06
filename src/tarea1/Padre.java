/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;

/**
 *
 * @author JCMCarra
 */
public class Padre {

    public static void main(String[] args) {
        try {

            // Leer desde la entrada estándar (lo que viene por la tubería)
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String mensaje = reader.readLine();

            if (mensaje != null && mensaje.contains("Mario")) {
                System.out.println(mensaje);
                System.out.println("(Despertando a Mario)");
            } else {
                System.out.println("Mensaje no reconocido");
            }
            /*
            String rutaClase = System.getProperty("java.class.path");
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", rutaClase, "miPaquete.Hijo");

            Process proceso = processBuilder.start();
            proceso.getInputStream();

            String resultado = read(proceso);
            System.out.println("Dice Mario que  " + resultado);
            // Esperar a que el proceso termine
            int exitCode = proceso.waitFor();
    
            System.out.println("El proceso hijo ha terminado con codigo de salida: " + exitCode);
             */

        } catch (IOException e) {
            e.printStackTrace();

        }
        /*  String rutaClase = System.getProperty("java.class.path");
            File directorio = new File(rutaClase);
            ProcessBuilder pb1 = new ProcessBuilder("javac", "Hijo.java");
            pb1.directory(directorio);
            Process p1 = pb1.start();
            try {
                p1.waitFor();
            } catch (InterruptedException ex) {
                ex.getMessage();
            }
            try {
                OutputStream os = p1.getOutputStream();
                os.write("Hola Mario\n".getBytes());
                os.flush();

                InputStream is = p1.getInputStream();
                int c;
                while ((c = is.read()) != -1) {
                    System.out.print((char) c);
                }
                is.close();
            } catch (Exception e) {
                e.printStackTrace();
            }

            int exitVal;
            try {
                //El proceso actual espera hasta que el subproceso Process finalice
                exitVal = p1.waitFor(); //Recoge la salida de System.exit()
                System.out.println("Valor de salida " + exitVal);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();

        }*/
    }
}
