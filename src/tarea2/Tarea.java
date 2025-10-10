/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package tarea2;

import java.util.Random;

/**
 *
 * @author José Carlos Manjón Carrasco
 */
public class Tarea implements Runnable {

    /**
     * @param args the command line arguments
     */
    private int cestaPescador = 0, cestaGatos = 0;
    private final int VALOR_MAXIMO_CESTA_PESCADOR = 10;
    private final int VALOR_MAXIMO_CESTA_GATOS = 2;
    private final int TIEMPO_ESPERA_COMIDA_GATO = 25;
    private final String tipo;

//constructor del tipo, nos permitirá diferenciar entre los gatos y el pescador
    public Tarea(String tipo) {
        this.tipo = tipo;
    }

    public static void main(String[] args) {
        //definimos tipo
        Tarea pescador = new Tarea("pescador");
        Tarea gatoUno = new Tarea("gato");
        Tarea gatoDos = new Tarea("gato");
        Tarea gatoTres = new Tarea("gato");
        //se crean los hilos
        Thread hiloPescador = new Thread(pescador);
        Thread hiloGatoUno = new Thread(gatoUno);
        Thread hiloGatoDos = new Thread(gatoDos);
        Thread hiloGatoTres = new Thread(gatoTres);
        // se inician los hilos
        hiloPescador.start();
        hiloGatoUno.start();
        hiloGatoDos.start();
        hiloGatoTres.start();
    }
//obtenemos el tiempo de espera entre 1 y 5

    public static int tiempoEsperaAleatoria() {
        Random random = new Random();
        return random.nextInt(5) + 1; // genera un número entre 1 y 5
    }

    @Override
    public void run() {
        while (cestaPescador < VALOR_MAXIMO_CESTA_PESCADOR) {
            try {
                Thread.sleep(tiempoEsperaAleatoria() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        System.out.println("El valor de la cesta es de" + cestaPescador);
    }
}
