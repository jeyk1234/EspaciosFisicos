/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.ws;

//import ec.edu.espe.arquitectura.espacios.services.UbicacionService;
import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
import ec.edu.espe.arquitectura.espacios.model.Ubicacion;
import ec.edu.espe.arquitectura.espacios.services.UbicacionService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.DELETE;

import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author edmarin
 */
@Path("ubicacion")
public class UbicacionRest {
    @EJB(beanName = "UbicacionService")
    private UbicacionService service;
            
    @GET
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getUbicaciones()
    {
        
       return Response.ok(service.obtenerTodos()).build();
    }
    
    @GET
    @Path("/filtro/{codPadre}")
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getUbicacionesPadre(@PathParam("codPadre") String codPadre)
    {
        try
        {
            List<Ubicacion> u=this.service.obterPorPadre(codPadre);
            return u.size()>0?Response.ok(u).build():Response.ok().build();
          
            
        }catch(Exception ex)
        {
            return Response.ok().build();
        }
        
        
    }
     @PUT
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response guardar(Ubicacion ubicacion)
    {
        try
        {
            this.service.guardar(ubicacion);
            return Response.ok().build();
        }catch(Exception ex)
        {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }
    
    
    @POST
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response modificar(Ubicacion ubicacion)
    {
        try
        {
            this.service.modificar(ubicacion);
            return Response.ok().build();
        }catch(Exception ex)
        {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }
    @DELETE
    @Path("{cod}")
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response eliminar(@PathParam("cod") String cod)
    {
        try
        {
            Ubicacion ubicacion = this.service.buscar(cod);
            this.service.eliminar(ubicacion);
            return Response.ok().build();
        }catch(Exception ex)
        {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }
   /* @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAulas()
    {  
        return Response.ok(service.obtenerAulas()).build();
    }
    */
    
}
