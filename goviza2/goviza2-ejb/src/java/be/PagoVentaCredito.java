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
@Table(name = "pago_venta_credito")
@NamedQueries({
    @NamedQuery(name = "PagoVentaCredito.findAll", query = "SELECT p FROM PagoVentaCredito p"),
    @NamedQuery(name = "PagoVentaCredito.findByIdPagoVentaCredito", query = "SELECT p FROM PagoVentaCredito p WHERE p.idPagoVentaCredito = :idPagoVentaCredito"),
    @NamedQuery(name = "PagoVentaCredito.findByFechaIngreso", query = "SELECT p FROM PagoVentaCredito p WHERE p.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "PagoVentaCredito.findByObservaciones", query = "SELECT p FROM PagoVentaCredito p WHERE p.observaciones = :observaciones"),
    @NamedQuery(name = "PagoVentaCredito.findByCantidad", query = "SELECT p FROM PagoVentaCredito p WHERE p.cantidad = :cantidad")})
public class PagoVentaCredito implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PAGO_VENTA_CREDITO")
    private Integer idPagoVentaCredito;
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
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(fetch = FetchType.EAGER)
    private Venta venta;

    public PagoVentaCredito() {
    }

    public PagoVentaCredito(Integer idPagoVentaCredito) {
        this.idPagoVentaCredito = idPagoVentaCredito;
    }

    public PagoVentaCredito(Integer idPagoVentaCredito, Date fechaIngreso, String observaciones, BigDecimal cantidad) {
        this.idPagoVentaCredito = idPagoVentaCredito;
        this.fechaIngreso = fechaIngreso;
        this.observaciones = observaciones;
        this.cantidad = cantidad;
    }

    public Integer getIdPagoVentaCredito() {
        return idPagoVentaCredito;
    }

    public void setIdPagoVentaCredito(Integer idPagoVentaCredito) {
        this.idPagoVentaCredito = idPagoVentaCredito;
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

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagoVentaCredito != null ? idPagoVentaCredito.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PagoVentaCredito)) {
            return false;
        }
        PagoVentaCredito other = (PagoVentaCredito) object;
        if ((this.idPagoVentaCredito == null && other.idPagoVentaCredito != null) || (this.idPagoVentaCredito != null && !this.idPagoVentaCredito.equals(other.idPagoVentaCredito))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.PagoVentaCredito[idPagoVentaCredito=" + idPagoVentaCredito + "]";
    }

}
