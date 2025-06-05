/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Repository;

import entity.TipoDocumento;
import java.util.List;

/**
 *
 * @author estudiante
 */
public interface ITipoDocumentoRepository {
    //Creamos un CRUD 
    
    //Normalmente cuando pasamos parametro el cual es una parte de un objeto, pasamos todo el objeto
    //para no romper el encapsulamiento. Lo abro solo dentro del metodo
    public List<TipoDocumento> consultar();
    public TipoDocumento consultarId(TipoDocumento tipoDocumento);
    public int insertar(TipoDocumento tipoDocumento);
    public int eliminar(TipoDocumento tipoDocumento);
    public int actualizar(TipoDocumento tipoDocumento);
}
