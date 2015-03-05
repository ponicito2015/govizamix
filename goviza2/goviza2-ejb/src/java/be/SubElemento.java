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
@Table(name = "sub_elemento")
@NamedQueries({
    @NamedQuery(name = "SubElemento.findAll", query = "SELECT s FROM SubElemento s"),
    @NamedQuery(name = "SubElemento.findByIdSubElemento", query = "SELECT s FROM SubElemento s WHERE s.idSubElemento = :idSubElemento"),
    @NamedQuery(name = "SubElemento.findByNombreSubElemento", query = "SELECT s FROM SubElemento s WHERE s.nombreSubElemento = :nombreSubElemento"),
    @NamedQuery(name = "SubElemento.findByDescripcion", query = "SELECT s FROM SubElemento s WHERE s.descripcion = :descripcion")})
public class SubElemento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SUB_ELEMENTO")
    private Integer idSubElemento;
    @Basic(optional = false)
    @Column(name = "NOMBRE_SUB_ELEMENTO")
    private String nombreSubElemento;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subElemento", fetch = FetchType.EAGER)
    private List<CuentaContable> cuentaContableList;

    public SubElemento() {
    }

    public SubElemento(Integer idSubElemento) {
        this.idSubElemento = idSubElemento;
    }

    public SubElemento(Integer idSubElemento, String nombreSubElemento, String descripcion) {
        this.idSubElemento = idSubElemento;
        this.nombreSubElemento = nombreSubElemento;
        this.descripcion = descripcion;
    }

    public Integer getIdSubElemento() {
        return idSubElemento;
    }

    public void setIdSubElemento(Integer idSubElemento) {
        this.idSubElemento = idSubElemento;
    }

    public String getNombreSubElemento() {
        return nombreSubElemento;
    }

    public void setNombreSubElemento(String nombreSubElemento) {
        this.nombreSubElemento = nombreSubElemento;
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
        hash += (idSubElemento != null ? idSubElemento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SubElemento)) {
            return false;
        }
        SubElemento other = (SubElemento) object;
        if ((this.idSubElemento == null && other.idSubElemento != null) || (this.idSubElemento != null && !this.idSubElemento.equals(other.idSubElemento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SubElemento[idSubElemento=" + idSubElemento + "]";
    }

}
