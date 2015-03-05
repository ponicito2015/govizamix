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
@Table(name = "pago_factura_venta_credito")
@NamedQueries({
    @NamedQuery(name = "PagoFacturaVentaCredito.findAll", query = "SELECT p FROM PagoFacturaVentaCredito p"),
    @NamedQuery(name = "PagoFacturaVentaCredito.findByIdPagoFacturaVentaCredito", query = "SELECT p FROM PagoFacturaVentaCredito p WHERE p.idPagoFacturaVentaCredito = :idPagoFacturaVentaCredito"),
    @NamedQuery(name = "PagoFacturaVentaCredito.findByFechaIngreso", query = "SELECT p FROM PagoFacturaVentaCredito p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PagoFacturaVentaCredito.findByObservaciones", query = "SELECT p FROM PagoFacturaVentaCredito p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PagoFacturaVentaCredito.findByCantidad", query = "SELECT p FROM PagoFacturaVentaCredito p WHERE p.cantidad = :cantidad")})
public class PagoFacturaVentaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAGO_FACTURA_VENTA_CREDITO")
    private Integer idPagoFacturaVentaCredito;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "ID_FACTURA_VENTA", referencedColumnName = "ID_FACTURA_VENTA")
    @ManyToOne(fetch = FetchType.EAGER)
    private FacturaVenta facturaVenta;

    public PagoFacturaVentaCredito() {
    }

    public PagoFacturaVentaCredito(Integer idPagoFacturaVentaCredito) {
        this.idPagoFacturaVentaCredito = idPagoFacturaVentaCredito;
    }

    public PagoFacturaVentaCredito(Integer idPagoFacturaVentaCredito, Date fechaIngreso, String observaciones, BigDecimal cantidad) {
        this.idPagoFacturaVentaCredito = idPagoFacturaVentaCredito;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
    }

    public Integer getIdPagoFacturaVentaCredito() {
        return idPagoFacturaVentaCredito;
    }

    public void setIdPagoFacturaVentaCredito(Integer idPagoFacturaVentaCredito) {
        this.idPagoFacturaVentaCredito = idPagoFacturaVentaCredito;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public FacturaVenta getFacturaVenta() {
        return facturaVenta;
    }

    public void setFacturaVenta(FacturaVenta facturaVenta) {
        this.facturaVenta = facturaVenta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoFacturaVentaCredito != null ? idPagoFacturaVentaCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoFacturaVentaCredito)) {
            return false;
        }
        PagoFacturaVentaCredito other = (PagoFacturaVentaCredito) object;
        if ((this.idPagoFacturaVentaCredito == null && other.idPagoFacturaVentaCredito != null) || (this.idPagoFacturaVentaCredito != null && !this.idPagoFacturaVentaCredito.equals(other.idPagoFacturaVentaCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PagoFacturaVentaCredito[idPagoFacturaVentaCredito=" + idPagoFacturaVentaCredito + "]";
    }

}
