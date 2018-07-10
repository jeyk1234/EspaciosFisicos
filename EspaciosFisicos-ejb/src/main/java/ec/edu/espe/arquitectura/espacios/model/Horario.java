/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.espacios.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 */
@Entity
@Table(name = "horario")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Horario.findAll", query = "SELECT h FROM Horario h")
    , @NamedQuery(name = "Horario.findByCodHorario", query = "SELECT h FROM Horario h WHERE h.codHorario = :codHorario")
    , @NamedQuery(name = "Horario.findByCodNrc", query = "SELECT h FROM Horario h WHERE h.codNrc = :codNrc")
    , @NamedQuery(name = "Horario.findByCodPeriodo", query = "SELECT h FROM Horario h WHERE h.codPeriodo = :codPeriodo")
    , @NamedQuery(name = "Horario.findByCodUbicacion", query = "SELECT h FROM Horario h WHERE h.codUbicacion = :codUbicacion")
    , @NamedQuery(name = "Horario.findByCodFranjaMatricula", query = "SELECT h FROM Horario h WHERE h.codFranjaMatricula = :codFranjaMatricula")})
public class Horario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "COD_HORARIO")
    private String codHorario;
    @Size(max = 5)
    @Column(name = "COD_NRC")
    private String codNrc;
    @Size(max = 6)
    @Column(name = "COD_PERIODO")
    private String codPeriodo;
    @Size(max = 3)
    @Column(name = "COD_UBICACION")
    private String codUbicacion;
    @Size(max = 5)
    @Column(name = "COD_FRANJA_MATRICULA")
    private String codFranjaMatricula;

    public Horario() {
    }

    public Horario(String codHorario) {
        this.codHorario = codHorario;
    }

    public String getCodHorario() {
        return codHorario;
    }

    public void setCodHorario(String codHorario) {
        this.codHorario = codHorario;
    }

    public String getCodNrc() {
        return codNrc;
    }

    public void setCodNrc(String codNrc) {
        this.codNrc = codNrc;
    }

    public String getCodPeriodo() {
        return codPeriodo;
    }

    public void setCodPeriodo(String codPeriodo) {
        this.codPeriodo = codPeriodo;
    }

    public String getCodUbicacion() {
        return codUbicacion;
    }

    public void setCodUbicacion(String codUbicacion) {
        this.codUbicacion = codUbicacion;
    }

    public String getCodFranjaMatricula() {
        return codFranjaMatricula;
    }

    public void setCodFranjaMatricula(String codFranjaMatricula) {
        this.codFranjaMatricula = codFranjaMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codHorario != null ? codHorario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Horario)) {
            return false;
        }
        Horario other = (Horario) object;
        if ((this.codHorario == null && other.codHorario != null) || (this.codHorario != null && !this.codHorario.equals(other.codHorario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.espacios.model.Horario[ codHorario=" + codHorario + " ]";
    }
    
}
