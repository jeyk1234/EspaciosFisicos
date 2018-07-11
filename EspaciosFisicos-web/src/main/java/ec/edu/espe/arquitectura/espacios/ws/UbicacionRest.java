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
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("ubicacion")
public class UbicacionRest {

    @EJB(beanName = "UbicacionService")
    private UbicacionService service;

    @GET
    @Produces({MediaType.APPLICATION_JSON + ";charset=utf-8"})
    public Response getUbicaciones() {

        return Response.ok(service.obtenerTodos()).build();
    }

    @PUT
    @Produces({MediaType.APPLICATION_JSON})
    @Consumes({MediaType.APPLICATION_JSON})
    public Response guardar(Ubicacion ubicacion) {
        try {

            Ubicacion ub = new Ubicacion();
            ub.setCodUbicacion(ubicacion.getCodUbicacion());
            ub.setCodUbicacionPadre(ubicacion.getCodUbicacionPadre());
            ub.setDescripcion(ubicacion.getDescripcion());

            this.service.guardar(ub);
            return Response.ok().build();
        } catch (Exception ex) {
            System.out.println("Error" + ex.getMessage());
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GET
    @Path("/filtro/{codPadre}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUbicacionPadre(@PathParam("codPadre") String codPadre) {
        try {
            List<Ubicacion> ls = service.obterPorPadre(codPadre);
            return ls.size() > 0 ? Response.ok(ls).build() : Response.ok().build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();
        }

    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modificaUbicacion(@PathParam("ubicacion") Ubicacion u) {
        try {

            this.service.modificar(u);
            return Response.status(Response.Status.OK).build();

        } catch (Exception ex) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).build();

        }
    }

}
