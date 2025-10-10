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

    public static void main(String[] args) {
        // declaramos los hilos

        Thread gatoUno = new Thread();
        Thread gatoDos = new Thread();
        Thread gatoTres = new Thread();
        Thread pescador = new Thread();

        //los iniciamos
        gatoUno.start();
        gatoDos.start();
        gatoTres.start();
        pescador.start();
        //System.out.println(tiempoEsperaAleatoria());
        tiempoEsperaAleatoria();

    }

    public static int tiempoEsperaAleatoria() {
        Random random = new Random();
        return random.nextInt(5) + 1; // genera un número entre 1 y 5
    }

    Tarea(String pescador) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void comprobarCestaPescador(int cestaComprobar) {
        if (cestaComprobar == VALOR_MAXIMO_CESTA_PESCADOR) {
//esperar
        } else {
            cestaPescador++;
        }
    }

    public void comprobarCestaGatos(int cestaComprobar) {
        if (cestaComprobar == VALOR_MAXIMO_CESTA_GATOS) {
//esperar
        } else {
            cestaGatos++;
        }
    }

    public void pescar() {
        cestaPescador++;
    }

}
