/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import entity.Alumno;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IAlumno {
    public List<Alumno> consultar();
    public Alumno consultarId(Alumno alumno);
    public int insertar(Alumno alumno);
    public int eliminar(Alumno alumno);
    public int actualizar(Alumno alumno); 
}
