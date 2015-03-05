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
@Table(name = "tipo_plaga")
@NamedQueries({
    @NamedQuery(name = "TipoPlaga.findAll", query = "SELECT t FROM TipoPlaga t"),
    @NamedQuery(name = "TipoPlaga.findByIdTipoPlaga", query = "SELECT t FROM TipoPlaga t WHERE t.idTipoPlaga = :idTipoPlaga"),
    @NamedQuery(name = "TipoPlaga.findByNombreTipoPlaga", query = "SELECT t FROM TipoPlaga t WHERE t.nombreTipoPlaga = :nombreTipoPlaga"),
    @NamedQuery(name = "TipoPlaga.findByDescripcion", query = "SELECT t FROM TipoPlaga t WHERE t.descripcion = :descripcion")})
public class TipoPlaga implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_PLAGA")
    private Integer idTipoPlaga;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_PLAGA")
    private String nombreTipoPlaga;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;

    public TipoPlaga() {
    }

    public TipoPlaga(Integer idTipoPlaga) {
        this.idTipoPlaga = idTipoPlaga;
    }

    public TipoPlaga(Integer idTipoPlaga, String nombreTipoPlaga, String descripcion) {
        this.idTipoPlaga = idTipoPlaga;
        this.nombreTipoPlaga = nombreTipoPlaga;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoPlaga() {
        return idTipoPlaga;
    }

    public void setIdTipoPlaga(Integer idTipoPlaga) {
        this.idTipoPlaga = idTipoPlaga;
    }

    public String getNombreTipoPlaga() {
        return nombreTipoPlaga;
    }

    public void setNombreTipoPlaga(String nombreTipoPlaga) {
        this.nombreTipoPlaga = nombreTipoPlaga;
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
        hash += (idTipoPlaga != null ? idTipoPlaga.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoPlaga)) {
            return false;
        }
        TipoPlaga other = (TipoPlaga) object;
        if ((this.idTipoPlaga == null && other.idTipoPlaga != null) || (this.idTipoPlaga != null && !this.idTipoPlaga.equals(other.idTipoPlaga))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoPlaga[idTipoPlaga=" + idTipoPlaga + "]";
    }

}
