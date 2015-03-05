/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "tipo_cuenta_contable")
@NamedQueries({
    @NamedQuery(name = "TipoCuentaContable.findAll", query = "SELECT t FROM TipoCuentaContable t"),
    @NamedQuery(name = "TipoCuentaContable.findByIdTipoCuentaContable", query = "SELECT t FROM TipoCuentaContable t WHERE t.idTipoCuentaContable = :idTipoCuentaContable"),
    @NamedQuery(name = "TipoCuentaContable.findByNombreTipoCuentaContable", query = "SELECT t FROM TipoCuentaContable t WHERE t.nombreTipoCuentaContable = :nombreTipoCuentaContable"),
    @NamedQuery(name = "TipoCuentaContable.findByDescripcion", query = "SELECT t FROM TipoCuentaContable t WHERE t.descripcion = :descripcion")})
public class TipoCuentaContable implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CUENTA_CONTABLE")
    private Integer idTipoCuentaContable;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_CUENTA_CONTABLE")
    private String nombreTipoCuentaContable;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCuentaContable", fetch = FetchType.EAGER)
    private List<CuentaContable> cuentaContableList;

    public TipoCuentaContable() {
    }

    public TipoCuentaContable(Integer idTipoCuentaContable) {
        this.idTipoCuentaContable = idTipoCuentaContable;
    }

    public TipoCuentaContable(Integer idTipoCuentaContable, String nombreTipoCuentaContable, String descripcion) {
        this.idTipoCuentaContable = idTipoCuentaContable;
        this.nombreTipoCuentaContable = nombreTipoCuentaContable;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoCuentaContable() {
        return idTipoCuentaContable;
    }

    public void setIdTipoCuentaContable(Integer idTipoCuentaContable) {
        this.idTipoCuentaContable = idTipoCuentaContable;
    }

    public String getNombreTipoCuentaContable() {
        return nombreTipoCuentaContable;
    }

    public void setNombreTipoCuentaContable(String nombreTipoCuentaContable) {
        this.nombreTipoCuentaContable = nombreTipoCuentaContable;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<CuentaContable> getCuentaContableList() {
        return cuentaContableList;
    }

    public void setCuentaContableList(List<CuentaContable> cuentaContableList) {
        this.cuentaContableList = cuentaContableList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCuentaContable != null ? idTipoCuentaContable.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCuentaContable)) {
            return false;
        }
        TipoCuentaContable other = (TipoCuentaContable) object;
        if ((this.idTipoCuentaContable == null && other.idTipoCuentaContable != null) || (this.idTipoCuentaContable != null && !this.idTipoCuentaContable.equals(other.idTipoCuentaContable))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoCuentaContable[idTipoCuentaContable=" + idTipoCuentaContable + "]";
    }

}
