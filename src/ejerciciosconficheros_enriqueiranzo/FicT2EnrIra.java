/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ejerciciosconficheros_enriqueiranzo;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author enriq
 */
public class FicT2EnrIra {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
Scanner teclado = new Scanner (System.in);
    System.out.println("\nDime el primer fichero");
    String fic1 = teclado.nextLine();
    File fic1_f = new File (fic1);

    System.out.println("Dime el segundo fichero");
    String fic2 = teclado.nextLine();
    File fic2_f = new File (fic2);

    
    unirFicheros(fic1_f,fic2_f);
    
    }
    public static void unirFicheros(File fichero1,File fichero2){
        String f = fichero1.getName();
        String f1 = f.substring(0,(f.length())-4);
        File destino_f = new File ("./"+f1+"_"+fichero2.getName());
        Scanner teclado = new Scanner (System.in);
        try {
            while (!destino_f.exists()){
                System.out.println ("El destino no existe, creándolo");
                destino_f.createNewFile();
            }
                
                FileReader fic1 = new FileReader (fichero1);
                FileReader fic2 = new FileReader (fichero2);  
                
                BufferedReader flujo2 = new BufferedReader(fic1);
                BufferedReader flujo3 = new BufferedReader(fic2);

                FileWriter flujo=null;
                
                System.out.println("El fichero de destino existe, quieres sobreescribirlo? S/N");
                char respuesta = Character.toUpperCase(teclado.nextLine().charAt(0));
                
                if (respuesta == 'S'){
                    flujo = new FileWriter(destino_f);
                }
                else if (respuesta == 'N'){
                    flujo = new FileWriter (destino_f,true);
                }
                
                BufferedWriter bw=new BufferedWriter (flujo);
                
                copia (bw, flujo2);
                copia (bw, flujo3);
                bw.close();
                flujo2.close();
                flujo3.close();
        }
        catch (EOFException eofe) {System.out.println(eofe.getMessage());}
        catch (FileNotFoundException fnfe) {System.out.println(fnfe.getMessage());}        
        catch (IOException ioe ) {ioe.printStackTrace();}
    }
    
    private static void copia (BufferedWriter escribe, BufferedReader lee) throws IOException {
        String texto = lee.readLine();
        while (texto!=null){
            texto = texto + "\n\r"; 
            escribe.write(texto);
            texto= lee.readLine();
        }
    }   
}
