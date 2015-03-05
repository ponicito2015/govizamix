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
@Table(name = "estado_orden_compra")
@NamedQueries({
    @NamedQuery(name = "EstadoOrdenCompra.findAll", query = "SELECT e FROM EstadoOrdenCompra e"),
    @NamedQuery(name = "EstadoOrdenCompra.findByIdEstadoOrdenCompra", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.idEstadoOrdenCompra = :idEstadoOrdenCompra"),
    @NamedQuery(name = "EstadoOrdenCompra.findByNombre", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoOrdenCompra.findByDescripcion", query = "SELECT e FROM EstadoOrdenCompra e WHERE e.descripcion = :descripcion")})
public class EstadoOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_ORDEN_COMPRA")
    private Integer idEstadoOrdenCompra;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoOrdenCompra", fetch = FetchType.EAGER)
    private List<OrdenCompra> ordenCompraList;

    public EstadoOrdenCompra() {
    }

    public EstadoOrdenCompra(Integer idEstadoOrdenCompra) {
        this.idEstadoOrdenCompra = idEstadoOrdenCompra;
    }

    public EstadoOrdenCompra(Integer idEstadoOrdenCompra, String nombre, String descripcion) {
        this.idEstadoOrdenCompra = idEstadoOrdenCompra;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoOrdenCompra() {
        return idEstadoOrdenCompra;
    }

    public void setIdEstadoOrdenCompra(Integer idEstadoOrdenCompra) {
        this.idEstadoOrdenCompra = idEstadoOrdenCompra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<OrdenCompra> getOrdenCompraList() {
        return ordenCompraList;
    }

    public void setOrdenCompraList(List<OrdenCompra> ordenCompraList) {
        this.ordenCompraList = ordenCompraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOrdenCompra != null ? idEstadoOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrdenCompra)) {
            return false;
        }
        EstadoOrdenCompra other = (EstadoOrdenCompra) object;
        if ((this.idEstadoOrdenCompra == null && other.idEstadoOrdenCompra != null) || (this.idEstadoOrdenCompra != null && !this.idEstadoOrdenCompra.equals(other.idEstadoOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoOrdenCompra[idEstadoOrdenCompra=" + idEstadoOrdenCompra + "]";
    }

}
