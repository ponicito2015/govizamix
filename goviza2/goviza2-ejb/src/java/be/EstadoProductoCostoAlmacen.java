/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "estado_producto_costo_almacen")
@NamedQueries({
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findAll", query = "SELECT e FROM EstadoProductoCostoAlmacen e"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByIdEstadoProductoCostoAlmacen", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.idEstadoProductoCostoAlmacen = :idEstadoProductoCostoAlmacen"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByNombre", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.nombre = :nombre"),
    @NamedQuery(name = "EstadoProductoCostoAlmacen.findByDescripcion", query = "SELECT e FROM EstadoProductoCostoAlmacen e WHERE e.descripcion = :descripcion")})
public class EstadoProductoCostoAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN")
    private Integer idEstadoProductoCostoAlmacen;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "estadoProductoCostoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(mappedBy = "estadoProductoCostoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;

    public EstadoProductoCostoAlmacen() {
    }

    public EstadoProductoCostoAlmacen(Integer idEstadoProductoCostoAlmacen) {
        this.idEstadoProductoCostoAlmacen = idEstadoProductoCostoAlmacen;
    }

    public EstadoProductoCostoAlmacen(Integer idEstadoProductoCostoAlmacen, String nombre, String descripcion) {
        this.idEstadoProductoCostoAlmacen = idEstadoProductoCostoAlmacen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoProductoCostoAlmacen() {
        return idEstadoProductoCostoAlmacen;
    }

    public void setIdEstadoProductoCostoAlmacen(Integer idEstadoProductoCostoAlmacen) {
        this.idEstadoProductoCostoAlmacen = idEstadoProductoCostoAlmacen;
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

    public List<DetalleAlmacenProductosCostos> getDetalleAlmacenProductosCostosList() {
        return detalleAlmacenProductosCostosList;
    }

    public void setDetalleAlmacenProductosCostosList(List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList) {
        this.detalleAlmacenProductosCostosList = detalleAlmacenProductosCostosList;
    }

    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoProductoCostoAlmacen != null ? idEstadoProductoCostoAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoProductoCostoAlmacen)) {
            return false;
        }
        EstadoProductoCostoAlmacen other = (EstadoProductoCostoAlmacen) object;
        if ((this.idEstadoProductoCostoAlmacen == null && other.idEstadoProductoCostoAlmacen != null) || (this.idEstadoProductoCostoAlmacen != null && !this.idEstadoProductoCostoAlmacen.equals(other.idEstadoProductoCostoAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoProductoCostoAlmacen[idEstadoProductoCostoAlmacen=" + idEstadoProductoCostoAlmacen + "]";
    }

}
