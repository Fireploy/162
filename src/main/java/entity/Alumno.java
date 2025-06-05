/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

import java.util.Date;

/**
 *
 * @author estudiante POR CADA ENTITY, SE CONSTRUYE UN DAO
 */
public class Alumno extends Persona{
    
    private int grado;
    
    public Alumno() {
    }

    public Alumno(int grado, String nombre, String apellido, int tipoDocumento, String correo, String telefono, Date fechaNacimiento, Institucion institucion) {
        super(nombre, apellido, tipoDocumento, correo, telefono, fechaNacimiento, institucion);
        this.grado = grado;
    }

    public int getGrado() {
        return grado;
    }

    public void setGrado(int grado) {
        this.grado = grado;
    }

}
