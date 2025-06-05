/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Services.TipoDocumentoServices;
import entity.TipoDocumento;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

/**
 *
 * @author estudiante
 */
@Path("documentos")
public class TipoDocumentoController {

    TipoDocumentoServices tipoDocumentoServices = new TipoDocumentoServices();

    @GET
    @Path("todosdocumentos")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<TipoDocumento> tiposDocumentos = tipoDocumentoServices.consultar();
        return Response
                .ok(tiposDocumentos)
                .build();
    }

    @GET
    @Path("documentoid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarId(@PathParam("id") int id) {
        TipoDocumento tipoDocumento = new TipoDocumento(id);
        return Response
                .ok()
                .entity(tipoDocumentoServices.consultarId(tipoDocumento))
                .build();
    }

    @DELETE
    @Path("documentoid/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("id") int id) {
        TipoDocumento tipoDocumento = new TipoDocumento(id);
        int registro = tipoDocumentoServices.eliminar(tipoDocumento);
        if (registro == 0) {
            return Response
                    .status(Response.Status.NOT_FOUND)
                    .build();
        } else {
            return Response
                    .status(Response.Status.OK)
                    .build();
        }
    }
    
    //Mirando los dao de los otros 

}
