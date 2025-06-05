/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author estudiante
 */
public class TipoDocumento {
    private int id;
    private String nombre;

    public TipoDocumento() {
    }

    public TipoDocumento(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public TipoDocumento(int id) {
        this.id = id;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "TipoDocumento{" + "id=" + id + ", nombre=" + nombre + '}';
    }
    
    
    
}
