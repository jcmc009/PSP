/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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


        } catch (IOException | InterruptedException e) {
            e.printStackTrace();

        }*/
            // Método principal que inicia el proceso

            llamarOtroMetodo();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // Método que utiliza ProcessBuilder para llamar a otro método

    public static void llamarOtroMetodo() throws IOException {
        ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", ".", "Hola");
        Process proceso = processBuilder.start();
    }

    private static String read(Process proceso) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (IOException e) {
            System.out.println("Error al leer la salida del proceso hijo: " + e.getMessage());
        }

        return builder.toString();
    }

}
