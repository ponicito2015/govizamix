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
@Table(name = "estado_orden_salida_detalle_almacen_productos")
@NamedQueries({
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findAll", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e"),
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findByIdEstadoOrdenSalidaDetalleAlmacenProductos", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e WHERE e.idEstadoOrdenSalidaDetalleAlmacenProductos = :idEstadoOrdenSalidaDetalleAlmacenProductos"),
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findByNombreEstado", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e WHERE e.nombreEstado = :nombreEstado"),
    @NamedQuery(name = "EstadoOrdenSalidaDetalleAlmacenProductos.findByDescripcion", query = "SELECT e FROM EstadoOrdenSalidaDetalleAlmacenProductos e WHERE e.descripcion = :descripcion")})
public class EstadoOrdenSalidaDetalleAlmacenProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_ORDEN_SALIDA_DETALLE_ALMACEN_PRODUCTOS")
    private Integer idEstadoOrdenSalidaDetalleAlmacenProductos;
    @Basic(optional = false)
    @Column(name = "NOMBRE_ESTADO")
    private String nombreEstado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "estadoOrdenSalidaDetalleAlmacenProductos", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;

    public EstadoOrdenSalidaDetalleAlmacenProductos() {
    }

    public EstadoOrdenSalidaDetalleAlmacenProductos(Integer idEstadoOrdenSalidaDetalleAlmacenProductos) {
        this.idEstadoOrdenSalidaDetalleAlmacenProductos = idEstadoOrdenSalidaDetalleAlmacenProductos;
    }

    public EstadoOrdenSalidaDetalleAlmacenProductos(Integer idEstadoOrdenSalidaDetalleAlmacenProductos, String nombreEstado, String descripcion) {
        this.idEstadoOrdenSalidaDetalleAlmacenProductos = idEstadoOrdenSalidaDetalleAlmacenProductos;
        this.nombreEstado = nombreEstado;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoOrdenSalidaDetalleAlmacenProductos() {
        return idEstadoOrdenSalidaDetalleAlmacenProductos;
    }

    public void setIdEstadoOrdenSalidaDetalleAlmacenProductos(Integer idEstadoOrdenSalidaDetalleAlmacenProductos) {
        this.idEstadoOrdenSalidaDetalleAlmacenProductos = idEstadoOrdenSalidaDetalleAlmacenProductos;
    }

    public String getNombreEstado() {
        return nombreEstado;
    }

    public void setNombreEstado(String nombreEstado) {
        this.nombreEstado = nombreEstado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList() {
        return ordenSalidaDetalleAlmacenProductosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList) {
        this.ordenSalidaDetalleAlmacenProductosList = ordenSalidaDetalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEstadoOrdenSalidaDetalleAlmacenProductos != null ? idEstadoOrdenSalidaDetalleAlmacenProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoOrdenSalidaDetalleAlmacenProductos)) {
            return false;
        }
        EstadoOrdenSalidaDetalleAlmacenProductos other = (EstadoOrdenSalidaDetalleAlmacenProductos) object;
        if ((this.idEstadoOrdenSalidaDetalleAlmacenProductos == null && other.idEstadoOrdenSalidaDetalleAlmacenProductos != null) || (this.idEstadoOrdenSalidaDetalleAlmacenProductos != null && !this.idEstadoOrdenSalidaDetalleAlmacenProductos.equals(other.idEstadoOrdenSalidaDetalleAlmacenProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoOrdenSalidaDetalleAlmacenProductos[idEstadoOrdenSalidaDetalleAlmacenProductos=" + idEstadoOrdenSalidaDetalleAlmacenProductos + "]";
    }

}
