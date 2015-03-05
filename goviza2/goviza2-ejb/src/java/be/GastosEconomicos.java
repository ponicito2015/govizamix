/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "gastos_economicos")
@NamedQueries({
    @NamedQuery(name = "GastosEconomicos.findAll", query = "SELECT g FROM GastosEconomicos g"),
    @NamedQuery(name = "GastosEconomicos.findByIdGastosEconomicos", query = "SELECT g FROM GastosEconomicos g WHERE g.idGastosEconomicos = :idGastosEconomicos"),
    @NamedQuery(name = "GastosEconomicos.findByMotivo", query = "SELECT g FROM GastosEconomicos g WHERE g.motivo = :motivo"),
    @NamedQuery(name = "GastosEconomicos.findByNota", query = "SELECT g FROM GastosEconomicos g WHERE g.nota = :nota"),
    @NamedQuery(name = "GastosEconomicos.findByFechaCreacion", query = "SELECT g FROM GastosEconomicos g WHERE g.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "GastosEconomicos.findByTotal", query = "SELECT g FROM GastosEconomicos g WHERE g.total = :total")})
public class GastosEconomicos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_GASTOS_ECONOMICOS")
    private Integer idGastosEconomicos;
    @Basic(optional = false)
    @Column(name = "MOTIVO")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "NOTA")
    private String nota;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @Column(name = "TOTAL")
    private BigDecimal total;

    public GastosEconomicos() {
    }

    public GastosEconomicos(Integer idGastosEconomicos) {
        this.idGastosEconomicos = idGastosEconomicos;
    }

    public GastosEconomicos(Integer idGastosEconomicos, String motivo, String nota, Date fechaCreacion, BigDecimal total) {
        this.idGastosEconomicos = idGastosEconomicos;
        this.motivo = motivo;
        this.nota = nota;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
    }

    public Integer getIdGastosEconomicos() {
        return idGastosEconomicos;
    }

    public void setIdGastosEconomicos(Integer idGastosEconomicos) {
        this.idGastosEconomicos = idGastosEconomicos;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public String getNota() {
        return nota;
    }

    public void setNota(String nota) {
        this.nota = nota;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idGastosEconomicos != null ? idGastosEconomicos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GastosEconomicos)) {
            return false;
        }
        GastosEconomicos other = (GastosEconomicos) object;
        if ((this.idGastosEconomicos == null && other.idGastosEconomicos != null) || (this.idGastosEconomicos != null && !this.idGastosEconomicos.equals(other.idGastosEconomicos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.GastosEconomicos[idGastosEconomicos=" + idGastosEconomicos + "]";
    }

}
