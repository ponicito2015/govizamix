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
@Table(name = "procedencia_producto_almacen")
@NamedQueries({
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findAll", query = "SELECT p FROM ProcedenciaProductoAlmacen p"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByIdProcedenciaProductoAlmacen", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.idProcedenciaProductoAlmacen = :idProcedenciaProductoAlmacen"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByNombre", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.nombre = :nombre"),
    @NamedQuery(name = "ProcedenciaProductoAlmacen.findByDescripcion", query = "SELECT p FROM ProcedenciaProductoAlmacen p WHERE p.descripcion = :descripcion")})
public class ProcedenciaProductoAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PROCEDENCIA_PRODUCTO_ALMACEN")
    private Integer idProcedenciaProductoAlmacen;
    @Basic(optional = false)
    @Column(name = "NOMBRE")
    private String nombre;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaProductoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductosCostos> detalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "procedenciaProductoAlmacen", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;

    public ProcedenciaProductoAlmacen() {
    }

    public ProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
    }

    public ProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen, String nombre, String descripcion) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public Integer getIdProcedenciaProductoAlmacen() {
        return idProcedenciaProductoAlmacen;
    }

    public void setIdProcedenciaProductoAlmacen(Integer idProcedenciaProductoAlmacen) {
        this.idProcedenciaProductoAlmacen = idProcedenciaProductoAlmacen;
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
        hash += (idProcedenciaProductoAlmacen != null ? idProcedenciaProductoAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProcedenciaProductoAlmacen)) {
            return false;
        }
        ProcedenciaProductoAlmacen other = (ProcedenciaProductoAlmacen) object;
        if ((this.idProcedenciaProductoAlmacen == null && other.idProcedenciaProductoAlmacen != null) || (this.idProcedenciaProductoAlmacen != null && !this.idProcedenciaProductoAlmacen.equals(other.idProcedenciaProductoAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ProcedenciaProductoAlmacen[idProcedenciaProductoAlmacen=" + idProcedenciaProductoAlmacen + "]";
    }

}
