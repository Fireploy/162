/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import entity.Institucion;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface IInstitucionRepository {
    public List<Institucion> consultar();
    public Institucion consultarId(Institucion institucion);
    public int insertar(Institucion institucion);
    public int eliminar(Institucion institucion);
    public int actualizar(Institucion institucion);
}
