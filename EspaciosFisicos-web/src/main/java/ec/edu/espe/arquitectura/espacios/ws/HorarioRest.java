/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.ws;

<<<<<<< HEAD
import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
import ec.edu.espe.arquitectura.espacios.model.Horario;
import ec.edu.espe.arquitectura.espacios.services.HorarioService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
=======
import ec.edu.espe.arquitectura.espacios.services.HorarioService;
import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

<<<<<<< HEAD
/**
 *
 * @author edmarin
 */
@Path("horario")

public class HorarioRest {

    @EJB(beanName = "HorarioService")
    private HorarioService service;

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response getHorarios() {

        return Response.ok(service.obtenerTodos()).build();
    }
    

    @GET
    @Path("{nrc}")
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response getHorariosPorNRC(@PathParam("nrc") String nrc) {
        
        System.out.println(nrc);
        return Response.ok(service.obtenerPorNrc(nrc)).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response guardar(List<Horario> data) {
        try {
            this.service.eliminarPorNrc(data.get(0).getCodNrc());
            List<Horario> temp= this.service.obtenerTodos();
            Integer ultCod=(this.service.cod(temp)+1);
            for (Horario h : data) {
                String cod=ultCod+++"";
                h.setCodHorario("H-"+cod);
                this.service.crear(h);
            }

            return Response.ok().build();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }

=======
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
    
    
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe
}
