/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosconficheros_enriqueiranzo;
import java.io.*;
import java.util.*;
/**
 *
 * @author enriq
 */
public class FicT1EnrIra {

/**
 * 
 * @param args
 * @throws IOException 
 */
    public static void main(String[] args)throws IOException{
        FileReader fichero = new FileReader ("./src/ejerciciosconficheros_enriqueiranzo/texto.txt");
        BufferedReader flujo = new BufferedReader (fichero);
        String texto = flujo.readLine();
        while (texto !=null){
            for (int i = texto.length() - 1; i >= 0 ; i --){
                if (texto.charAt(i)!=' '){
                    System.out.print(texto.charAt(i));
                }
            }
            texto = flujo.readLine();
        }
        flujo.close();

    
    
    } 
}
