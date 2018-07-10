/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.dao;

import ec.edu.espe.arquitectura.espacios.model.Ubicacion;
import java.util.List;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 */
@Stateless
@LocalBean
public class UbicacionFacade extends AbstractFacade<Ubicacion> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.espacios_EspaciosFisicos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UbicacionFacade() {
        super(Ubicacion.class);
    }
    public List<Ubicacion> obtenerPorPadre(String codPadre)
    {
        System.out.println(codPadre);
        Query q;
        if("c".equals(codPadre))
        {
            q=this.em.createQuery("SELECT obj FROM Ubicacion obj WHERE obj.codUbicacionPadre IS NULL");
        }
        else
        {
            q = this.em.createQuery("SELECT obj FROM Ubicacion obj WHERE obj.codUbicacionPadre = ?1");
            q.setParameter(1, codPadre);
        }
        
        return q.getResultList();
    }
    
}
