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
@Table(name = "ubicacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ubicacion.findAll", query = "SELECT u FROM Ubicacion u")
    , @NamedQuery(name = "Ubicacion.findByCodUbicacion", query = "SELECT u FROM Ubicacion u WHERE u.codUbicacion = :codUbicacion")
    , @NamedQuery(name = "Ubicacion.findByCodUbicacionPadre", query = "SELECT u FROM Ubicacion u WHERE u.codUbicacionPadre = :codUbicacionPadre")
    , @NamedQuery(name = "Ubicacion.findByDescripcion", query = "SELECT u FROM Ubicacion u WHERE u.descripcion = :descripcion")})
public class Ubicacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "COD_UBICACION")
    private String codUbicacion;
    @Size(max = 3)
    @Column(name = "COD_UBICACION_PADRE")
    private String codUbicacionPadre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public Ubicacion() {
    }

    public Ubicacion(String codUbicacion) {
        this.codUbicacion = codUbicacion;
    }

    public Ubicacion(String codUbicacion, String descripcion) {
        this.codUbicacion = codUbicacion;
        this.descripcion = descripcion;
    }

    public String getCodUbicacion() {
        return codUbicacion;
    }

    public void setCodUbicacion(String codUbicacion) {
        this.codUbicacion = codUbicacion;
    }

    public String getCodUbicacionPadre() {
        return codUbicacionPadre;
    }

    public void setCodUbicacionPadre(String codUbicacionPadre) {
        this.codUbicacionPadre = codUbicacionPadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codUbicacion != null ? codUbicacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ubicacion)) {
            return false;
        }
        Ubicacion other = (Ubicacion) object;
        if ((this.codUbicacion == null && other.codUbicacion != null) || (this.codUbicacion != null && !this.codUbicacion.equals(other.codUbicacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ec.edu.espe.arquitectura.espacios.model.Ubicacion[ codUbicacion=" + codUbicacion + " ]";
    }
    
}
