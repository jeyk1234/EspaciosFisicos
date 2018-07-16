/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.services;

import ec.edu.espe.arquitectura.espacios.dao.FranjaHorariaFacade;
import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
import ec.edu.espe.arquitectura.espacios.model.Horario;
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
public class FranjaHorariaService {

    @EJB(beanName = "FranjaHorariaFacade")
    private FranjaHorariaFacade franjaFacade;

    public List<FranjaHoraria> obtenerTodos() {
        return franjaFacade.findAll();
    }

    public void guardar(FranjaHoraria f) {
        franjaFacade.create(f);
    }

    public List<FranjaHoraria> obtenerTodosDia(String dia) {
        return franjaFacade.obtenerTodosDia(dia);
    }

    public List<FranjaHoraria> obtenerHorario(List<Horario> horarios) {
        List<FranjaHoraria> f=new ArrayList<>();
        for(Horario h: horarios)
        {
            f.add(franjaFacade.find(h.getCodFranjaMatricula()));
        }
        return f;

    }

}
