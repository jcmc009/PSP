package tarea1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PadreDos {

    public static void main(String[] args) {
        try {
            // Leer desde la entrada estándar
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String mensaje = reader.readLine();

            if (mensaje != null && mensaje.contains("Mario")) {
                System.out.println(mensaje);
                System.out.println("(Despertando a Mario)");
            } else {
                System.out.println("Mensaje no reconocido");
            }

            // Obtener el classpath actual
            String rutaClase = System.getProperty("java.class.path");

            // Crear el proceso para ejecutar la clase Hijo
            ProcessBuilder processBuilder = new ProcessBuilder("java", "-cp", rutaClase, "tarea1.Hijo");
            processBuilder.redirectErrorStream(true);

            Process proceso = processBuilder.start();

            // Leer la salida del proceso hijo
            String resultado = read(proceso);
            System.out.println("Dice Mario que: " + resultado);

            // Esperar a que el proceso termine
            proceso.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static String read(Process proceso) throws IOException {
        StringBuilder builder = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line).append(System.lineSeparator());
            }
        } catch (Exception e) {
            System.out.println("Error al leer la salida del proceso hijo: " + e.getMessage());
        }

        return builder.toString();
    }
}