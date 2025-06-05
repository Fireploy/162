/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Services;

import Repository.TipoDocumentoRepository;
import entity.TipoDocumento;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class TipoDocumentoServices {
    //Solo es un puerto de entrada y salida las clases de este paquete
    TipoDocumentoRepository tipoDocumentoRepository = new TipoDocumentoRepository();
    
    public List<TipoDocumento> consultar(){
        return tipoDocumentoRepository.consultar();
    }
    
    public TipoDocumento consultarId(TipoDocumento tipoDocumento){
        return tipoDocumentoRepository.consultarId(tipoDocumento);
    }
    
    public int insertar(TipoDocumento tipoDocumento){
        return tipoDocumentoRepository.insertar(tipoDocumento);
    }
    
    public int eliminar(TipoDocumento tipoDocumento){
        return tipoDocumentoRepository.eliminar(tipoDocumento);
    }
    
    public int actualizar(TipoDocumento tipoDocumento){
        return tipoDocumentoRepository.actualizar(tipoDocumento);
    }
    
}
