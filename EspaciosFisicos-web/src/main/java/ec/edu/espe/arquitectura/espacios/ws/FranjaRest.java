/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.ws;

import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
<<<<<<< HEAD
import ec.edu.espe.arquitectura.espacios.model.Horario;
import ec.edu.espe.arquitectura.espacios.services.FranjaHorariaService;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
=======
import ec.edu.espe.arquitectura.espacios.services.FranjaHorariaService;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

<<<<<<< HEAD
/**
 *
 * @author edmarin
 */
=======
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe
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
<<<<<<< HEAD
    @GET
    @Path("dia/{dia}")
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getFranjasDia(@PathParam("dia") String dia)
    {
        
       return Response.ok(service.obtenerTodosDia(dia)).build();
    }
    /*@POST
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response getFranjasHora()
    {
        
       return Response.ok(service.obtenerTodos()).build();
    }
    */
=======
    
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe
    @PUT
    @Produces({MediaType.APPLICATION_JSON+";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON+";charset=utf-8"})
    public Response guardarFranja(FranjaHoraria franja)
    {
        try
        {
            this.service.guardar(franja);
<<<<<<< HEAD
            return Response.ok(Response.Status.CREATED).build();
=======
            return Response.ok().build();
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe
        }catch(Exception ex)
        {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }
<<<<<<< HEAD
    
    @POST
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    @Consumes({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response obtenerHorario(List<Horario> data) {
        try {

           return Response.ok(this.service.obtenerHorario(data)).build();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return Response.serverError().build();
        }
    }

=======
>>>>>>> dfb52bae4296eff024309488203978b9beaa92fe


}
