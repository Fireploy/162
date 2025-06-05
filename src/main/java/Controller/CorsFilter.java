/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerResponseContext;
import jakarta.ws.rs.container.ContainerResponseFilter;
import jakarta.ws.rs.core.MultivaluedMap;
import java.io.IOException;

/**
 *
 * @author estudiante
 */
public class CorsFilter implements ContainerResponseFilter{

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext crc1) throws IOException {
        //Vamos a tener un mapa que permite realizar todas las operaciones 
        MultivaluedMap <String, Object> beaders = crc1.getHeaders();
        //Permitir peticiones desde cualquier maquina
        beaders.add("Access-Control-Allow-Origin", "*");
        //Permitir operaciones http
        beaders.add("Access-Control-Allow-Methods", "POST, GET, DELETE, PUT, UPDATE, OPTIONS");
        beaders.add("Access-Control-Allow-Headers", "Content-Type, Authorization");
        beaders.add("Access-Control-Max-Age", "600");
        beaders.add("Access-Control-Allow-Credentials", "true");
        
        
    }
    
}
