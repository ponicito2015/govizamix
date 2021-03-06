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
public class StockProductoTiendaOrigenPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "ID_PRODUCTO")
    private int idProducto;
    @Basic(optional = false)
    @Column(name = "ID_TIENDA_ORIGEN")
    private int idTiendaOrigen;

    public StockProductoTiendaOrigenPK() {
    }

    public StockProductoTiendaOrigenPK(int idProducto, int idTiendaOrigen) {
        this.idProducto = idProducto;
        this.idTiendaOrigen = idTiendaOrigen;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdTiendaOrigen() {
        return idTiendaOrigen;
    }

    public void setIdTiendaOrigen(int idTiendaOrigen) {
        this.idTiendaOrigen = idTiendaOrigen;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) idProducto;
        hash += (int) idTiendaOrigen;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockProductoTiendaOrigenPK)) {
            return false;
        }
        StockProductoTiendaOrigenPK other = (StockProductoTiendaOrigenPK) object;
        if (this.idProducto != other.idProducto) {
            return false;
        }
        if (this.idTiendaOrigen != other.idTiendaOrigen) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.StockProductoTiendaOrigenPK[idProducto=" + idProducto + ", idTiendaOrigen=" + idTiendaOrigen + "]";
    }

}
