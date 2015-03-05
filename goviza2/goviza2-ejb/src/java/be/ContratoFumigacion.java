/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
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
@Table(name = "contrato_fumigacion")
@NamedQueries({
    @NamedQuery(name = "ContratoFumigacion.findAll", query = "SELECT c FROM ContratoFumigacion c"),
    @NamedQuery(name = "ContratoFumigacion.findByIdContratoFumigacion", query = "SELECT c FROM ContratoFumigacion c WHERE c.idContratoFumigacion = :idContratoFumigacion"),
    @NamedQuery(name = "ContratoFumigacion.findByFechaVenta", query = "SELECT c FROM ContratoFumigacion c WHERE c.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "ContratoFumigacion.findByFechaVentaEmision", query = "SELECT c FROM ContratoFumigacion c WHERE c.fechaVentaEmision = :fechaVentaEmision"),
    @NamedQuery(name = "ContratoFumigacion.findByFechaHoraFumigacion", query = "SELECT c FROM ContratoFumigacion c WHERE c.fechaHoraFumigacion = :fechaHoraFumigacion"),
    @NamedQuery(name = "ContratoFumigacion.findByPlaga", query = "SELECT c FROM ContratoFumigacion c WHERE c.plaga = :plaga"),
    @NamedQuery(name = "ContratoFumigacion.findByDescripcion", query = "SELECT c FROM ContratoFumigacion c WHERE c.descripcion = :descripcion"),
    @NamedQuery(name = "ContratoFumigacion.findByTotalServicio", query = "SELECT c FROM ContratoFumigacion c WHERE c.totalServicio = :totalServicio"),
    @NamedQuery(name = "ContratoFumigacion.findByCuenta", query = "SELECT c FROM ContratoFumigacion c WHERE c.cuenta = :cuenta"),
    @NamedQuery(name = "ContratoFumigacion.findBySaldo", query = "SELECT c FROM ContratoFumigacion c WHERE c.saldo = :saldo")})
public class ContratoFumigacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CONTRATO_FUMIGACION")
    private Integer idContratoFumigacion;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA_EMISION")
    @Temporal(TemporalType.DATE)
    private Date fechaVentaEmision;
    @Basic(optional = false)
    @Column(name = "FECHA_HORA_FUMIGACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaHoraFumigacion;
    @Basic(optional = false)
    @Column(name = "PLAGA")
    private String plaga;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @Basic(optional = false)
    @Column(name = "TOTAL_SERVICIO")
    private BigDecimal totalServicio;
    @Basic(optional = false)
    @Column(name = "CUENTA")
    private BigDecimal cuenta;
    @Basic(optional = false)
    @Column(name = "SALDO")
    private BigDecimal saldo;
    @JoinColumn(name = "ID_VENTA", referencedColumnName = "ID_VENTA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Venta venta;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoFumigacion", fetch = FetchType.EAGER)
    private List<ReporteDesratizacion> reporteDesratizacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoFumigacion", fetch = FetchType.EAGER)
    private List<DetalleFumigacionProducto> detalleFumigacionProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "contratoFumigacion", fetch = FetchType.EAGER)
    private List<ReporteFumigacion> reporteFumigacionList;

    public ContratoFumigacion() {
    }

    public ContratoFumigacion(Integer idContratoFumigacion) {
        this.idContratoFumigacion = idContratoFumigacion;
    }

    public ContratoFumigacion(Integer idContratoFumigacion, Date fechaVenta, Date fechaVentaEmision, Date fechaHoraFumigacion, String plaga, String descripcion, BigDecimal totalServicio, BigDecimal cuenta, BigDecimal saldo) {
        this.idContratoFumigacion = idContratoFumigacion;
        this.fechaVenta = fechaVenta;
        this.fechaVentaEmision = fechaVentaEmision;
        this.fechaHoraFumigacion = fechaHoraFumigacion;
        this.plaga = plaga;
        this.descripcion = descripcion;
        this.totalServicio = totalServicio;
        this.cuenta = cuenta;
        this.saldo = saldo;
    }

    public Integer getIdContratoFumigacion() {
        return idContratoFumigacion;
    }

    public void setIdContratoFumigacion(Integer idContratoFumigacion) {
        this.idContratoFumigacion = idContratoFumigacion;
    }

    public Date getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(Date fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Date getFechaVentaEmision() {
        return fechaVentaEmision;
    }

    public void setFechaVentaEmision(Date fechaVentaEmision) {
        this.fechaVentaEmision = fechaVentaEmision;
    }

    public Date getFechaHoraFumigacion() {
        return fechaHoraFumigacion;
    }

    public void setFechaHoraFumigacion(Date fechaHoraFumigacion) {
        this.fechaHoraFumigacion = fechaHoraFumigacion;
    }

    public String getPlaga() {
        return plaga;
    }

    public void setPlaga(String plaga) {
        this.plaga = plaga;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public BigDecimal getTotalServicio() {
        return totalServicio;
    }

    public void setTotalServicio(BigDecimal totalServicio) {
        this.totalServicio = totalServicio;
    }

    public BigDecimal getCuenta() {
        return cuenta;
    }

    public void setCuenta(BigDecimal cuenta) {
        this.cuenta = cuenta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public Venta getVenta() {
        return venta;
    }

    public void setVenta(Venta venta) {
        this.venta = venta;
    }

    public List<ReporteDesratizacion> getReporteDesratizacionList() {
        return reporteDesratizacionList;
    }

    public void setReporteDesratizacionList(List<ReporteDesratizacion> reporteDesratizacionList) {
        this.reporteDesratizacionList = reporteDesratizacionList;
    }

    public List<DetalleFumigacionProducto> getDetalleFumigacionProductoList() {
        return detalleFumigacionProductoList;
    }

    public void setDetalleFumigacionProductoList(List<DetalleFumigacionProducto> detalleFumigacionProductoList) {
        this.detalleFumigacionProductoList = detalleFumigacionProductoList;
    }

    public List<ReporteFumigacion> getReporteFumigacionList() {
        return reporteFumigacionList;
    }

    public void setReporteFumigacionList(List<ReporteFumigacion> reporteFumigacionList) {
        this.reporteFumigacionList = reporteFumigacionList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idContratoFumigacion != null ? idContratoFumigacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContratoFumigacion)) {
            return false;
        }
        ContratoFumigacion other = (ContratoFumigacion) object;
        if ((this.idContratoFumigacion == null && other.idContratoFumigacion != null) || (this.idContratoFumigacion != null && !this.idContratoFumigacion.equals(other.idContratoFumigacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ContratoFumigacion[idContratoFumigacion=" + idContratoFumigacion + "]";
    }

}
