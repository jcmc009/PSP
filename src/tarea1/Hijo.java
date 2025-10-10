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

        String mensajeRecibido = "";
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        try {
            mensajeRecibido = br.readLine();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        try {
            if (br != null) {
                br.close();

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println(mensajeRecibido + "\nVaaaaale");

    }

}
