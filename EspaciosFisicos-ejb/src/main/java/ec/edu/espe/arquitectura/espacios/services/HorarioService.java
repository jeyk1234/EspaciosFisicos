/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.services;


//import ec.edu.espe.arquitectura.espacios.HorarioFacade;
import ec.edu.espe.arquitectura.espacios.dao.HorarioFacade;
import ec.edu.espe.arquitectura.espacios.model.FranjaHoraria;
import ec.edu.espe.arquitectura.espacios.model.Horario;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 *
 */
@Stateless
@LocalBean
public class HorarioService {

    @EJB(beanName = "HorarioFacade")
    private HorarioFacade horarioFacade;
    
    public List<Horario> obtenerTodos(){
        return horarioFacade.findAll();
    }
    
    public Horario obtenerPorCodigoHorario(String codigo) {
        return this.horarioFacade.find(codigo);
    }
    
    public List<Horario> obtenerPorNrc(String codigo) {
        return this.horarioFacade.listarHorarioPorNrc(codigo);
    }
    /*
    public List<Horario> validarHorario(List<FranjaHoraria> franjas)
    {
        List<Horario> contains=new ArrayList<>();
        for(FranjaHoraria h: franjas)
        {
            
            if(this.horarioFacade.verificarHorario(h.getCodFranjaHoraria())!=null)
            {
                
            }
        }
    }*/
    
    public void crear(Horario horario) {
        this.horarioFacade.create(horario);
    }
    
    public void modificar(Horario horario) {
        this.horarioFacade.edit(horario);
    }
    
    public void eliminar(String codigo) {
        Horario horario = this.horarioFacade.find(codigo);
        this.horarioFacade.remove(horario);
    }
    public Integer eliminarPorNrc(String codNrc)
    {
        return this.horarioFacade.eliminarTodos(codNrc);
    }
    public Integer cod( List<Horario> a)
    {
        List<Integer> as= new ArrayList<>();
        for(Horario b: a)
        {
            String c= b.getCodHorario().split("-")[1];
            as.add(Integer.parseInt(c));
        }
        Collections.sort(as);
        return as.get(as.size()-1);
    }
}