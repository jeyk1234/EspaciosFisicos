/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.ws;

import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
import ec.edu.espe.arquitectura.espacios.services.FranjaHorariaService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("franja")
public class FranjaRest {
    @EJB(beanName = "FranjaHorariaService")
    private FranjaHorariaService service;
            
    @GET
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getFranjas()
    {
        
       return Response.ok(service.obtenerTodos()).build();
    }
    
    @PUT
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response guardarFranja(FranjaHoraria franja)
    {
        try
        {
            this.service.guardar(franja);
            return Response.ok().build();
        }catch(Exception ex)
        {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }


}
