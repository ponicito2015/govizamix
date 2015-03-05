/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "desarrollador")
@NamedQueries({
    @NamedQuery(name = "Desarrollador.findAll", query = "SELECT d FROM Desarrollador d"),
    @NamedQuery(name = "Desarrollador.findByIdDesarrollador", query = "SELECT d FROM Desarrollador d WHERE d.idDesarrollador = :idDesarrollador"),
    @NamedQuery(name = "Desarrollador.findByNombre", query = "SELECT d FROM Desarrollador d WHERE d.nombre = :nombre")})
public class Desarrollador implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DESARROLLADOR")
    private Integer idDesarrollador;
    @Column(name = "NOMBRE")
    private String nombre;

    public Desarrollador() {
    }

    public Desarrollador(Integer idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public Integer getIdDesarrollador() {
        return idDesarrollador;
    }

    public void setIdDesarrollador(Integer idDesarrollador) {
        this.idDesarrollador = idDesarrollador;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDesarrollador != null ? idDesarrollador.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desarrollador)) {
            return false;
        }
        Desarrollador other = (Desarrollador) object;
        if ((this.idDesarrollador == null && other.idDesarrollador != null) || (this.idDesarrollador != null && !this.idDesarrollador.equals(other.idDesarrollador))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Desarrollador[idDesarrollador=" + idDesarrollador + "]";
    }

}
