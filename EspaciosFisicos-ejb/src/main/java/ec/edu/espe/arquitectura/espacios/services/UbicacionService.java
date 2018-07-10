/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.services;


import ec.edu.espe.arquitectura.espacios.dao.UbicacionFacade;
import ec.edu.espe.arquitectura.espacios.model.Ubicacion;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
@LocalBean
public class UbicacionService {

    @EJB(beanName = "UbicacionFacade")
    
    private UbicacionFacade ubicacionFacade;
    
    public List<Ubicacion> obtenerTodos(){
        return ubicacionFacade.findAll();
    }
    
    public List<Ubicacion> obtenerAulas(){
        return ubicacionFacade.findAll();
    }
    public void guardar(Ubicacion u)
    {
        List<Ubicacion> a= new ArrayList<>();
        a = ubicacionFacade.findAll();
        String code="U"+(Integer.parseInt(a.get(a.size()-1).getCodUbicacion().substring(1))+1);
        u.setCodUbicacion(code);
        ubicacionFacade.create(u);
    }
    
    public List<Ubicacion> obterPorPadre(String codPadre)
    {
       return  ubicacionFacade.obtenerPorPadre(codPadre);
    }
    public void modificar(Ubicacion u)
    {
        
        this.ubicacionFacade.modif(u);
    }
    public Ubicacion buscar(String c)
    {
        return this.ubicacionFacade.find(c);
    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
