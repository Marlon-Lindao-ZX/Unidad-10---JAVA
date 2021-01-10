/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author CORE I7
 */
public class Archivo {

    private static final File ARCHIVO = new File("src/Fuentes/personas.txt");
    private static final File ARCHIVOPERSONASERIAL = new File("src/Fuentes/personas.bin");

    public static void crearFicheros() {
        try {

            if (!(ARCHIVOPERSONASERIAL.exists())) {
                ARCHIVOPERSONASERIAL.createNewFile();
            }

        } catch (IOException ioe) {
            System.out.println("error!!!");

        }
    }

    public static void escribirFicheros(ArrayList<Persona> personas) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(ARCHIVOPERSONASERIAL, false));
             BufferedWriter bfw = new BufferedWriter(new FileWriter(ARCHIVO))) {
            for (Persona persona : personas) {
                oos.writeObject(persona);
                bfw.write(persona.toString());
            }
            oos.flush();
            System.out.println("lista guardada en archivo binario");
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        }
    }

    public static ArrayList<Persona> leerFicheroSerial() {
        ArrayList<Persona> retorno = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVOPERSONASERIAL))) {
            try {
                while (true) {
                    retorno.add((Persona) ois.readObject());
                }
            } catch (EOFException ex) {
                System.out.println("lista de archivo binario leida");
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        } finally {
            return retorno;
        }
    }
    
     public static ArrayList<Persona> leerFicheroTxt() {
        ArrayList<Persona> retorno = new ArrayList<>();
        try (BufferedReader bfr = new BufferedReader(new FileReader(ARCHIVO))) {
                String linea;
                while((linea = bfr.readLine()) != null){
                    retorno.add(new Persona(linea));
                }
        } catch (FileNotFoundException fnfe) {

        } catch (IOException ioe) {

        } finally {
            return retorno;
        }
    }

    public static File getARCHIVOPERSONASERIAL() {
        return ARCHIVOPERSONASERIAL;
    }

}
