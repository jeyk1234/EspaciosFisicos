/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.ws;

import ec.edu.espe.arquitectura.espacios.services.HorarioService;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("horario/")

public class HorarioRest {
     @EJB(beanName = "HorarioService")
    private HorarioService service;
            
    @GET
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getHorarios()
    {
        
       return Response.ok(service.obtenerTodos()).build();
    }
    
    
              
    @GET
    @Path("{nrc}")
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getHorariosPorNRC(@QueryParam("nrc") String nrc)
    {     
        
       return Response.ok(service.obtenerPorNrc(nrc)).build();
    }
    
    
}
