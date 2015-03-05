/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "venta_rapida")
@NamedQueries({
    @NamedQuery(name = "VentaRapida.findAll", query = "SELECT v FROM VentaRapida v"),
    @NamedQuery(name = "VentaRapida.findByIdVentaRapida", query = "SELECT v FROM VentaRapida v WHERE v.idVentaRapida = :idVentaRapida"),
    @NamedQuery(name = "VentaRapida.findByFechaVenta", query = "SELECT v FROM VentaRapida v WHERE v.fechaVenta = :fechaVenta")})
public class VentaRapida implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENTA_RAPIDA")
    private Integer idVentaRapida;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ventaRapida", fetch = FetchType.EAGER)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;

    public VentaRapida() {
    }

    public VentaRapida(Integer idVentaRapida) {
        this.idVentaRapida = idVentaRapida;
    }

    public VentaRapida(Integer idVentaRapida, Date fechaVenta) {
        this.idVentaRapida = idVentaRapida;
        this.fechaVenta = fechaVenta;
    }

    public Integer getIdVentaRapida() {
        return idVentaRapida;
    }

    public void setIdVentaRapida(Integer idVentaRapida) {
        this.idVentaRapida = idVentaRapida;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
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
        hash += (idVentaRapida != null ? idVentaRapida.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VentaRapida)) {
            return false;
        }
        VentaRapida other = (VentaRapida) object;
        if ((this.idVentaRapida == null && other.idVentaRapida != null) || (this.idVentaRapida != null && !this.idVentaRapida.equals(other.idVentaRapida))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.VentaRapida[idVentaRapida=" + idVentaRapida + "]";
    }

}
