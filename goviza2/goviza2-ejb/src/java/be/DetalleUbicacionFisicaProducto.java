/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "detalle_ubicacion_fisica_producto")
@NamedQueries({
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findAll", query = "SELECT d FROM DetalleUbicacionFisicaProducto d"),
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findByIdDetalleUbicacionFisicaProducto", query = "SELECT d FROM DetalleUbicacionFisicaProducto d WHERE d.idDetalleUbicacionFisicaProducto = :idDetalleUbicacionFisicaProducto"),
    @NamedQuery(name = "DetalleUbicacionFisicaProducto.findByCantidad", query = "SELECT d FROM DetalleUbicacionFisicaProducto d WHERE d.cantidad = :cantidad")})
public class DetalleUbicacionFisicaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_UBICACION_FISICA_PRODUCTO")
    private Integer idDetalleUbicacionFisicaProducto;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "ID_DETALLE_INVENTARIO_UBICACION_FISICA", referencedColumnName = "ID_DETALLE_INVENTARIO_UBICACION_FISICA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica;

    public DetalleUbicacionFisicaProducto() {
    }

    public DetalleUbicacionFisicaProducto(Integer idDetalleUbicacionFisicaProducto) {
        this.idDetalleUbicacionFisicaProducto = idDetalleUbicacionFisicaProducto;
    }

    public DetalleUbicacionFisicaProducto(Integer idDetalleUbicacionFisicaProducto, int cantidad) {
        this.idDetalleUbicacionFisicaProducto = idDetalleUbicacionFisicaProducto;
        this.cantidad = cantidad;
    }

    public Integer getIdDetalleUbicacionFisicaProducto() {
        return idDetalleUbicacionFisicaProducto;
    }

    public void setIdDetalleUbicacionFisicaProducto(Integer idDetalleUbicacionFisicaProducto) {
        this.idDetalleUbicacionFisicaProducto = idDetalleUbicacionFisicaProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public DetalleInventarioUbicacionFisica getDetalleInventarioUbicacionFisica() {
        return detalleInventarioUbicacionFisica;
    }

    public void setDetalleInventarioUbicacionFisica(DetalleInventarioUbicacionFisica detalleInventarioUbicacionFisica) {
        this.detalleInventarioUbicacionFisica = detalleInventarioUbicacionFisica;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleUbicacionFisicaProducto != null ? idDetalleUbicacionFisicaProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleUbicacionFisicaProducto)) {
            return false;
        }
        DetalleUbicacionFisicaProducto other = (DetalleUbicacionFisicaProducto) object;
        if ((this.idDetalleUbicacionFisicaProducto == null && other.idDetalleUbicacionFisicaProducto != null) || (this.idDetalleUbicacionFisicaProducto != null && !this.idDetalleUbicacionFisicaProducto.equals(other.idDetalleUbicacionFisicaProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleUbicacionFisicaProducto[idDetalleUbicacionFisicaProducto=" + idDetalleUbicacionFisicaProducto + "]";
    }

}
