/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Hijo {

    public static void main(String[] args) {

        // Usamos StringBuilder para acumular múltiples líneas del mensaje recibido
        StringBuilder mensajeRecibido = new StringBuilder();

        // Creamos el BufferedReader para leer la entrada
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String linea;

            // Leemos línea por línea hasta que se recibe una línea vacía o fin de flujo
            while ((linea = br.readLine()) != null && !linea.isEmpty()) {
                mensajeRecibido.append(linea).append("\n");
            }

        } catch (Exception e) {
            System.out.println("Error al leer el mensaje: " + e.getMessage());
        }

        // Mostramos el mensaje completo recibido seguido de una respuesta
        System.out.println(mensajeRecibido.toString() + "Vaaaaale");
    }
}
