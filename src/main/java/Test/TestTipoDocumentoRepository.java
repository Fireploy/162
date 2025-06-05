/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Test;

import Repository.TipoDocumentoRepository;
import entity.TipoDocumento;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author estudiante
 */
public class TestTipoDocumentoRepository {
    public static void main(String[] args) {
        TipoDocumentoRepository rp = new TipoDocumentoRepository();
        List<TipoDocumento> tipos = new ArrayList();
        tipos = rp.consultar();
        System.out.println(tipos);
        
        //Creo un objeto solo con el nombre para hacer la consulta
        TipoDocumento tp = rp.consultarId(new TipoDocumento(5));
        System.out.println("Objeto unico: " + tp);
        
        //Ojo que cada vez que ejecuta inserta
        //System.out.println(rp.insertar(new TipoDocumento(0, "Registro Civil")));
        
        //Ojo que borra
        //System.out.println("Borrar: " + rp.eliminar(tp));
        
        TipoDocumento tipo = new TipoDocumento(1,"Cedula");
        System.out.println("Actualizar " + rp.actualizar(tipo));
        
    }
}
