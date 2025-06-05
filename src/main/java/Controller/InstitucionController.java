/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Services.InstitucionServices;
import entity.Institucion;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
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
@Path("institucion")
public class InstitucionController {
    InstitucionServices institucionServices = new InstitucionServices();

    @GET
    @Path("consultar")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultar() {
        List<Institucion> instituciones = institucionServices.consultar();
        return Response
                .ok(instituciones)
                .build();
    }

    @GET
    @Path("institucion/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response consultarID(@PathParam("codigo") String codigo){
        Institucion institucion = new Institucion(codigo);
        return Response
                .ok()
                .entity(institucionServices.consultarId(institucion))
                .build();
        
    }
    @DELETE
    @Path("institucion/{codigo}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response eliminar(@PathParam("codigo") String codigo){
        Institucion institucion = new Institucion(codigo);
        int registro = institucionServices.eliminar(institucion);
        if (registro==0){
        return Response
                .status(Response.Status.NOT_FOUND)
                .build();
                }
        else {
            return Response
                    .status(Response.Status.OK)
                    .build();
            
        }
    }
    
    @POST
    @Path("crear")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response crear(Institucion institucion){
        try{
            institucionServices.insertar(institucion);
            return Response.status(Response.Status.CREATED).entity(institucion).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    } 
    
    @Path("actualizar")
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response actualizar(Institucion institucion) {
       try{
            institucionServices.actualizar(institucion);
            return Response.status(Response.Status.CREATED).entity(institucion).build();
        }
        catch(Exception ex)
        {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(ex.getMessage()).build();
        } 
    }
}
