/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "salida_producto_tienda")
@NamedQueries({
    @NamedQuery(name = "SalidaProductoTienda.findAll", query = "SELECT s FROM SalidaProductoTienda s"),
    @NamedQuery(name = "SalidaProductoTienda.findByIdSalidaProductoTienda", query = "SELECT s FROM SalidaProductoTienda s WHERE s.idSalidaProductoTienda = :idSalidaProductoTienda"),
    @NamedQuery(name = "SalidaProductoTienda.findByCantidad", query = "SELECT s FROM SalidaProductoTienda s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "SalidaProductoTienda.findByFechaSalida", query = "SELECT s FROM SalidaProductoTienda s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "SalidaProductoTienda.findByMotivo", query = "SELECT s FROM SalidaProductoTienda s WHERE s.motivo = :motivo")})
public class SalidaProductoTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SALIDA_PRODUCTO_TIENDA")
    private Integer idSalidaProductoTienda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "MOTIVO")
    private String motivo;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;

    public SalidaProductoTienda() {
    }

    public SalidaProductoTienda(Integer idSalidaProductoTienda) {
        this.idSalidaProductoTienda = idSalidaProductoTienda;
    }

    public SalidaProductoTienda(Integer idSalidaProductoTienda, int cantidad, Date fechaSalida, String motivo) {
        this.idSalidaProductoTienda = idSalidaProductoTienda;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
    }

    public Integer getIdSalidaProductoTienda() {
        return idSalidaProductoTienda;
    }

    public void setIdSalidaProductoTienda(Integer idSalidaProductoTienda) {
        this.idSalidaProductoTienda = idSalidaProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idSalidaProductoTienda != null ? idSalidaProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaProductoTienda)) {
            return false;
        }
        SalidaProductoTienda other = (SalidaProductoTienda) object;
        if ((this.idSalidaProductoTienda == null && other.idSalidaProductoTienda != null) || (this.idSalidaProductoTienda != null && !this.idSalidaProductoTienda.equals(other.idSalidaProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SalidaProductoTienda[idSalidaProductoTienda=" + idSalidaProductoTienda + "]";
    }

}
