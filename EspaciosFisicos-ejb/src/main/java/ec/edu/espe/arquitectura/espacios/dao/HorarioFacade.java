/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.dao;

import ec.edu.espe.arquitectura.espacios.model.Horario;
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
public class HorarioFacade extends AbstractFacade<Horario> {

    @PersistenceContext(unitName = "ec.edu.espe.arquitectura.espacios_EspaciosFisicos-ejb_ejb_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public HorarioFacade() {
        super(Horario.class);
    }
    public List<Horario> listarHorarioPorNrc(String codNrc) {
        Query q = this.em.createQuery("SELECT obj FROM Horario obj WHERE obj.codNrc = ?1");
        q.setParameter(1, codNrc);
          System.out.println(codNrc);
        return q.getResultList();
    }
    
     public List<Horario> verificarHorario(String codFranja, String codUbicacion, String codPeriodo) {
        Query q = this.em.createQuery("SELECT obj FROM Horario obj WHERE obj.codFranjaMatricula = ?1 AND obj.codUbicacion=?2 AND obj.codPeriodo=?3");
        q.setParameter(1, codFranja);
        q.setParameter(2, codUbicacion);
        q.setParameter(3, codPeriodo);
        return q.getResultList();
    }
    
     public Integer eliminarTodos(String codNrc)
     {
       Query query = this.em.createQuery("DELETE FROM Horario c WHERE c.codNrc = ?1");
          return query.setParameter(1, codNrc).executeUpdate();  
     }
}
