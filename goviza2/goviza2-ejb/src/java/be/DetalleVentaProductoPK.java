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
public class DetalleVentaProductoPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_VENTA")
    private int idVenta;
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;

    public DetalleVentaProductoPK() {
    }

    public DetalleVentaProductoPK(int idVenta, int idProducto) {
        this.idVenta = idVenta;
        this.idProducto = idProducto;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
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
        hash += (int) idVenta;
        hash += (int) idProducto;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleVentaProductoPK)) {
            return false;
        }
        DetalleVentaProductoPK other = (DetalleVentaProductoPK) object;
        if (this.idVenta != other.idVenta) {
            return false;
        }
        if (this.idProducto != other.idProducto) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleVentaProductoPK[idVenta=" + idVenta + ", idProducto=" + idProducto + "]";
    }

}
