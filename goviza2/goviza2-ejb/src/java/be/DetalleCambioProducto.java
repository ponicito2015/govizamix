/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
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
@Table(name = "detalle_cambio_producto")
@NamedQueries({
    @NamedQuery(name = "DetalleCambioProducto.findAll", query = "SELECT d FROM DetalleCambioProducto d"),
    @NamedQuery(name = "DetalleCambioProducto.findByIdCambio", query = "SELECT d FROM DetalleCambioProducto d WHERE d.detalleCambioProductoPK.idCambio = :idCambio"),
    @NamedQuery(name = "DetalleCambioProducto.findByIdProductoCambio", query = "SELECT d FROM DetalleCambioProducto d WHERE d.detalleCambioProductoPK.idProductoCambio = :idProductoCambio"),
    @NamedQuery(name = "DetalleCambioProducto.findByIdProductoCambiada", query = "SELECT d FROM DetalleCambioProducto d WHERE d.detalleCambioProductoPK.idProductoCambiada = :idProductoCambiada")})
public class DetalleCambioProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleCambioProductoPK detalleCambioProductoPK;
    @JoinColumn(name = "ID_PRODUCTO_CAMBIADA", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "ID_PRODUCTO_CAMBIO", referencedColumnName = "ID_PRODUCTO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto1;
    @JoinColumn(name = "ID_CAMBIO", referencedColumnName = "ID_CAMBIO", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cambio cambio;

    public DetalleCambioProducto() {
    }

    public DetalleCambioProducto(DetalleCambioProductoPK detalleCambioProductoPK) {
        this.detalleCambioProductoPK = detalleCambioProductoPK;
    }

    public DetalleCambioProducto(int idCambio, int idProductoCambio, int idProductoCambiada) {
        this.detalleCambioProductoPK = new DetalleCambioProductoPK(idCambio, idProductoCambio, idProductoCambiada);
    }

    public DetalleCambioProductoPK getDetalleCambioProductoPK() {
        return detalleCambioProductoPK;
    }

    public void setDetalleCambioProductoPK(DetalleCambioProductoPK detalleCambioProductoPK) {
        this.detalleCambioProductoPK = detalleCambioProductoPK;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Producto getProducto1() {
        return producto1;
    }

    public void setProducto1(Producto producto1) {
        this.producto1 = producto1;
    }

    public Cambio getCambio() {
        return cambio;
    }

    public void setCambio(Cambio cambio) {
        this.cambio = cambio;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (detalleCambioProductoPK != null ? detalleCambioProductoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleCambioProducto)) {
            return false;
        }
        DetalleCambioProducto other = (DetalleCambioProducto) object;
        if ((this.detalleCambioProductoPK == null && other.detalleCambioProductoPK != null) || (this.detalleCambioProductoPK != null && !this.detalleCambioProductoPK.equals(other.detalleCambioProductoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleCambioProducto[detalleCambioProductoPK=" + detalleCambioProductoPK + "]";
    }

}
