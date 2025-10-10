package tarea2;

import java.util.Random;

/**
 * Simulación de pescador y gatos usando hilos. El pescador pesca peces y los
 * coloca en su cesta. Los gatos intentan tomar peces de la cesta del pescador.
 *
 * @author José Carlos Manjón Carrasco
 */
public class Tarea1 implements Runnable {

    private int cestaPescador = 0;
    private final int VALOR_MAXIMO_CESTA_PESCADOR = 10;
    private final int VALOR_MAXIMO_CESTA_GATOS = 2;
    private final String tipo;

    public Tarea1(String tipo) {
        this.tipo = tipo;
    }

    public static void main(String[] args) {
        Tarea pescador = new Tarea("pescador");
        Tarea gatoUno = new Tarea("gato");
        Tarea gatoDos = new Tarea("gato");
        Tarea gatoTres = new Tarea("gato");

        Thread hiloPescador = new Thread(pescador);
        Thread hiloGatoUno = new Thread(gatoUno);
        Thread hiloGatoDos = new Thread(gatoDos);
        Thread hiloGatoTres = new Thread(gatoTres);

        hiloPescador.start();
        hiloGatoUno.start();
        hiloGatoDos.start();
        hiloGatoTres.start();
    }

    public static int tiempoEsperaAleatoria() {
        Random random = new Random();
        return random.nextInt(5) + 1; // genera un número entre 1 y 5
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(tiempoEsperaAleatoria() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }

            synchronized (this) {
                if (tipo.equals("pescador")) {
                    if (cestaPescador < VALOR_MAXIMO_CESTA_PESCADOR) {
                        cestaPescador++;
                        System.out.println("Pescador ha pescado un pez. Total en cesta: " + cestaPescador);
                    } else {
                        System.out.println("Cesta del pescador llena. Esperando...");
                    }
                } else if (tipo.equals("gato")) {
                    if (cestaPescador > 0) {
                        cestaPescador--;
                        System.out.println("Un gato ha tomado un pez. Quedan: " + cestaPescador);
                    } else {
                        System.out.println("No hay peces para los gatos. Esperando...");
                    }
                }
            }
        }
    }
}
