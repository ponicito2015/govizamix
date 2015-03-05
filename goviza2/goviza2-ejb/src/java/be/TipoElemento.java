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
@Table(name = "tipo_elemento")
@NamedQueries({
    @NamedQuery(name = "TipoElemento.findAll", query = "SELECT t FROM TipoElemento t"),
    @NamedQuery(name = "TipoElemento.findByIdTipoElemento", query = "SELECT t FROM TipoElemento t WHERE t.idTipoElemento = :idTipoElemento"),
    @NamedQuery(name = "TipoElemento.findByNombreTipoElemento", query = "SELECT t FROM TipoElemento t WHERE t.nombreTipoElemento = :nombreTipoElemento"),
    @NamedQuery(name = "TipoElemento.findByDescripcion", query = "SELECT t FROM TipoElemento t WHERE t.descripcion = :descripcion")})
public class TipoElemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_ELEMENTO")
    private Integer idTipoElemento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_ELEMENTO")
    private String nombreTipoElemento;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoElemento", fetch = FetchType.EAGER)
    private List<CuentaContable> cuentaContableList;

    public TipoElemento() {
    }

    public TipoElemento(Integer idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public TipoElemento(Integer idTipoElemento, String nombreTipoElemento, String descripcion) {
        this.idTipoElemento = idTipoElemento;
        this.nombreTipoElemento = nombreTipoElemento;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoElemento() {
        return idTipoElemento;
    }

    public void setIdTipoElemento(Integer idTipoElemento) {
        this.idTipoElemento = idTipoElemento;
    }

    public String getNombreTipoElemento() {
        return nombreTipoElemento;
    }

    public void setNombreTipoElemento(String nombreTipoElemento) {
        this.nombreTipoElemento = nombreTipoElemento;
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
        hash += (idTipoElemento != null ? idTipoElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoElemento)) {
            return false;
        }
        TipoElemento other = (TipoElemento) object;
        if ((this.idTipoElemento == null && other.idTipoElemento != null) || (this.idTipoElemento != null && !this.idTipoElemento.equals(other.idTipoElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoElemento[idTipoElemento=" + idTipoElemento + "]";
    }

}
