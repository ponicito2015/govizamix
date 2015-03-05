/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "ingreso_producto_tienda")
@NamedQueries({
    @NamedQuery(name = "IngresoProductoTienda.findAll", query = "SELECT i FROM IngresoProductoTienda i"),
    @NamedQuery(name = "IngresoProductoTienda.findByIdIngresoProductoTienda", query = "SELECT i FROM IngresoProductoTienda i WHERE i.idIngresoProductoTienda = :idIngresoProductoTienda"),
    @NamedQuery(name = "IngresoProductoTienda.findByCantidad", query = "SELECT i FROM IngresoProductoTienda i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaIngreso", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "IngresoProductoTienda.findByFechaVencimiento", query = "SELECT i FROM IngresoProductoTienda i WHERE i.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "IngresoProductoTienda.findByMotivo", query = "SELECT i FROM IngresoProductoTienda i WHERE i.motivo = :motivo"),
    @NamedQuery(name = "IngresoProductoTienda.findByCostoUnitario", query = "SELECT i FROM IngresoProductoTienda i WHERE i.costoUnitario = :costoUnitario")})
public class IngresoProductoTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INGRESO_PRODUCTO_TIENDA")
    private Integer idIngresoProductoTienda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Basic(optional = false)
    @Column(name = "MOTIVO")
    private String motivo;
    @Basic(optional = false)
    @Column(name = "COSTO_UNITARIO")
    private BigDecimal costoUnitario;
    @JoinColumn(name = "ID_UBICACION_FISICA", referencedColumnName = "ID_UBICACION_FISICA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UbicacionFisica ubicacionFisica;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;

    public IngresoProductoTienda() {
    }

    public IngresoProductoTienda(Integer idIngresoProductoTienda) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
    }

    public IngresoProductoTienda(Integer idIngresoProductoTienda, int cantidad, Date fechaIngreso, Date fechaVencimiento, String motivo, BigDecimal costoUnitario) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
        this.cantidad = cantidad;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
        this.motivo = motivo;
        this.costoUnitario = costoUnitario;
    }

    public Integer getIdIngresoProductoTienda() {
        return idIngresoProductoTienda;
    }

    public void setIdIngresoProductoTienda(Integer idIngresoProductoTienda) {
        this.idIngresoProductoTienda = idIngresoProductoTienda;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
    }

    public BigDecimal getCostoUnitario() {
        return costoUnitario;
    }

    public void setCostoUnitario(BigDecimal costoUnitario) {
        this.costoUnitario = costoUnitario;
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
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
        hash += (idIngresoProductoTienda != null ? idIngresoProductoTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IngresoProductoTienda)) {
            return false;
        }
        IngresoProductoTienda other = (IngresoProductoTienda) object;
        if ((this.idIngresoProductoTienda == null && other.idIngresoProductoTienda != null) || (this.idIngresoProductoTienda != null && !this.idIngresoProductoTienda.equals(other.idIngresoProductoTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.IngresoProductoTienda[idIngresoProductoTienda=" + idIngresoProductoTienda + "]";
    }

}
