/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Principal;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author CORE I7
 */
public class Persona implements Serializable{

    private String nombre;
    private LocalDate fechaNacimiento;
    private String genero;
    private String reservacion;
    private String tecnoConoc;
    private String nivelEduc;
    private String ubicacion;
    
    public Persona(){};

    public Persona(String nombre, LocalDate fechaNacimiento, String genero, String reservacion, String tecnoConoc, String nivelEduc, String ubicacion) {
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.genero = genero;
        this.reservacion = reservacion;
        this.tecnoConoc = tecnoConoc;
        this.nivelEduc = nivelEduc;
        this.ubicacion = ubicacion;
    }
    
    public Persona(String linea){
        
        String [] datos = linea.split("|");
        
        nombre = datos[0];
        fechaNacimiento = LocalDate.parse(datos[1]);
        genero = datos[2];
        reservacion = datos[3];
        tecnoConoc = datos[4];
        nivelEduc = datos[5];
        ubicacion = datos[6];
        
    }

    @Override
    public String toString(){
        
        String s = this.nombre + "|" + this.fechaNacimiento + "|" +  this.genero + "|" + 
                this.reservacion + "|" +  this.tecnoConoc + "|" + this.nivelEduc + "|" + 
                   this.ubicacion;
        
        return s;

    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getReservacion() {
        return reservacion;
    }

    public void setReservacion(String reservacion) {
        this.reservacion = reservacion;
    }

    public String getTecnoConoc() {
        return tecnoConoc;
    }

    public void setTecnoConoc(String tecnoConoc) {
        this.tecnoConoc = tecnoConoc;
    }

    public String getNivelEduc() {
        return nivelEduc;
    }

    public void setNivelEduc(String nivelEduc) {
        this.nivelEduc = nivelEduc;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

}
