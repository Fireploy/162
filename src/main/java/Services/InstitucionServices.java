/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repository.InstitucionRepository;
import entity.Institucion;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class InstitucionServices {
    InstitucionRepository institucionRepository = new InstitucionRepository();
    
    public List<Institucion> consultar(){
        return institucionRepository.consultar();
    }
    
    public Institucion consultarId(Institucion institucion){
        return institucionRepository.consultarId(institucion);
    }
    
    public int insertar(Institucion institucion){
        return institucionRepository.insertar(institucion);
    }
    
    public int eliminar(Institucion institucion){
        return institucionRepository.eliminar(institucion);
    }
    
    public int actualizar(Institucion institucion){
        return institucionRepository.actualizar(institucion);
    }
}
