/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author argos
 */
@Embeddable
public class DetalleFacturaVentaProductoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_FACTURA_VENTA")
    private int idFacturaVenta;
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;

    public DetalleFacturaVentaProductoPK() {
    }

    public DetalleFacturaVentaProductoPK(int idFacturaVenta, int idProducto) {
        this.idFacturaVenta = idFacturaVenta;
        this.idProducto = idProducto;
    }

    public int getIdFacturaVenta() {
        return idFacturaVenta;
    }

    public void setIdFacturaVenta(int idFacturaVenta) {
        this.idFacturaVenta = idFacturaVenta;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idFacturaVenta;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFacturaVentaProductoPK)) {
            return false;
        }
        DetalleFacturaVentaProductoPK other = (DetalleFacturaVentaProductoPK) object;
        if (this.idFacturaVenta != other.idFacturaVenta) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFacturaVentaProductoPK[idFacturaVenta=" + idFacturaVenta + ", idProducto=" + idProducto + "]";
    }

}
