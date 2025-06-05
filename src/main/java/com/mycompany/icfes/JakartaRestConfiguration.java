package com.mycompany.icfes;

import Controller.CorsFilter;
import Controller.InstitucionController;
import Controller.TipoDocumentoController;
import jakarta.ws.rs.ApplicationPath;
import jakarta.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

/**
 * Configures Jakarta RESTful Web Services for the application.
 * @author Juneau
 */
@ApplicationPath("resources")
public class JakartaRestConfiguration extends Application {
    @Override
    public Set<Class<?>> getClasses(){
        Set<Class<?>> classes = new HashSet<>();
        classes.add(CorsFilter.class);
        //Añadimos a todos los controladores a los que les queramos aplicar filtros. Nivel de seguridad 
        //básico. Todo el Controller que no este aquí no funciona 
        classes.add(TipoDocumentoController.class);
        classes.add(InstitucionController.class);
        return classes;
    }
}
