/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "detalle_venta_producto")
@NamedQueries({
    @NamedQuery(name = "DetalleVentaProducto.findAll", query = "SELECT d FROM DetalleVentaProducto d"),
    @NamedQuery(name = "DetalleVentaProducto.findByIdVenta", query = "SELECT d FROM DetalleVentaProducto d WHERE d.detalleVentaProductoPK.idVenta = :idVenta"),
    @NamedQuery(name = "DetalleVentaProducto.findByIdProducto", query = "SELECT d FROM DetalleVentaProducto d WHERE d.detalleVentaProductoPK.idProducto = :idProducto"),
    @NamedQuery(name = "DetalleVentaProducto.findByCantidad", query = "SELECT d FROM DetalleVentaProducto d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleVentaProducto.findByPrecioVenta", query = "SELECT d FROM DetalleVentaProducto d WHERE d.precioVenta = :precioVenta"),
    @NamedQuery(name = "DetalleVentaProducto.findByDescuento", query = "SELECT d FROM DetalleVentaProducto d WHERE d.descuento = :descuento"),
    @NamedQuery(name = "DetalleVentaProducto.findBySubTotal", query = "SELECT d FROM DetalleVentaProducto d WHERE d.subTotal = :subTotal")})
public class DetalleVentaProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleVentaProductoPK detalleVentaProductoPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "PRECIO_VENTA")
    private BigDecimal precioVenta;
    @Basic(optional = false)
    @Column(name = "DESCUENTO")
    private BigDecimal descuento;
    @Basic(optional = false)
    @Column(name = "SUB_TOTAL")
    private BigDecimal subTotal;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Venta venta;

    public DetalleVentaProducto() {
    }

    public DetalleVentaProducto(DetalleVentaProductoPK detalleVentaProductoPK) {
        this.detalleVentaProductoPK = detalleVentaProductoPK;
    }

    public DetalleVentaProducto(DetalleVentaProductoPK detalleVentaProductoPK, int cantidad, BigDecimal precioVenta, BigDecimal descuento, BigDecimal subTotal) {
        this.detalleVentaProductoPK = detalleVentaProductoPK;
        this.cantidad = cantidad;
        this.precioVenta = precioVenta;
        this.descuento = descuento;
        this.subTotal = subTotal;
    }

    public DetalleVentaProducto(int idVenta, int idProducto) {
        this.detalleVentaProductoPK = new DetalleVentaProductoPK(idVenta, idProducto);
    }

    public DetalleVentaProductoPK getDetalleVentaProductoPK() {
        return detalleVentaProductoPK;
    }

    public void setDetalleVentaProductoPK(DetalleVentaProductoPK detalleVentaProductoPK) {
        this.detalleVentaProductoPK = detalleVentaProductoPK;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public BigDecimal getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(BigDecimal precioVenta) {
        this.precioVenta = precioVenta;
    }

    public BigDecimal getDescuento() {
        return descuento;
    }

    public void setDescuento(BigDecimal descuento) {
        this.descuento = descuento;
    }

    public BigDecimal getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(BigDecimal subTotal) {
        this.subTotal = subTotal;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleVentaProductoPK != null ? detalleVentaProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaProducto)) {
            return false;
        }
        DetalleVentaProducto other = (DetalleVentaProducto) object;
        if ((this.detalleVentaProductoPK == null && other.detalleVentaProductoPK != null) || (this.detalleVentaProductoPK != null && !this.detalleVentaProductoPK.equals(other.detalleVentaProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleVentaProducto[detalleVentaProductoPK=" + detalleVentaProductoPK + "]";
    }

}
