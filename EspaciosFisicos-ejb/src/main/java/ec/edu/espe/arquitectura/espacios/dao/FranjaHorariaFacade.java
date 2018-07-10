/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.dao;

import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 */
@Stateless
@LocalBean
public class FranjaHorariaFacade extends AbstractFacade<FranjaHoraria> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.espacios_EspaciosFisicos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FranjaHorariaFacade() {
        super(FranjaHoraria.class);
    }
    
}
