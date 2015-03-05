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
@Table(name = "venta")
@NamedQueries({
    @NamedQuery(name = "Venta.findAll", query = "SELECT v FROM Venta v"),
    @NamedQuery(name = "Venta.findByIdVenta", query = "SELECT v FROM Venta v WHERE v.idVenta = :idVenta"),
    @NamedQuery(name = "Venta.findByBloqueVenta", query = "SELECT v FROM Venta v WHERE v.bloqueVenta = :bloqueVenta"),
    @NamedQuery(name = "Venta.findByNumeroVenta", query = "SELECT v FROM Venta v WHERE v.numeroVenta = :numeroVenta"),
    @NamedQuery(name = "Venta.findByFechaVenta", query = "SELECT v FROM Venta v WHERE v.fechaVenta = :fechaVenta"),
    @NamedQuery(name = "Venta.findByFechaVentaEmision", query = "SELECT v FROM Venta v WHERE v.fechaVentaEmision = :fechaVentaEmision"),
    @NamedQuery(name = "Venta.findByTotalVenta", query = "SELECT v FROM Venta v WHERE v.totalVenta = :totalVenta"),
    @NamedQuery(name = "Venta.findByObservaciones", query = "SELECT v FROM Venta v WHERE v.observaciones = :observaciones"),
    @NamedQuery(name = "Venta.findByTotalPagosCredito", query = "SELECT v FROM Venta v WHERE v.totalPagosCredito = :totalPagosCredito"),
    @NamedQuery(name = "Venta.findByFacturaRelacionada", query = "SELECT v FROM Venta v WHERE v.facturaRelacionada = :facturaRelacionada")})
public class Venta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_VENTA")
    private Integer idVenta;
    @Basic(optional = false)
    @Column(name = "BLOQUE_VENTA")
    private int bloqueVenta;
    @Basic(optional = false)
    @Column(name = "NUMERO_VENTA")
    private int numeroVenta;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA")
    @Temporal(TemporalType.DATE)
    private Date fechaVenta;
    @Basic(optional = false)
    @Column(name = "FECHA_VENTA_EMISION")
    @Temporal(TemporalType.DATE)
    private Date fechaVentaEmision;
    @Basic(optional = false)
    @Column(name = "TOTAL_VENTA")
    private BigDecimal totalVenta;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @Basic(optional = false)
    @Column(name = "TOTAL_PAGOS_CREDITO")
    private BigDecimal totalPagosCredito;
    @Column(name = "FACTURA_RELACIONADA")
    private String facturaRelacionada;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.EAGER)
    private List<ContratoFumigacion> contratoFumigacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.EAGER)
    private List<Cambio> cambioList;
    @OneToMany(mappedBy = "venta", fetch = FetchType.EAGER)
    private List<PagoVentaCredito> pagoVentaCreditoList;
    @JoinColumn(name = "ID_ESTADO_VENTA", referencedColumnName = "ID_ESTADO_VENTA")
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoVenta estadoVenta;
    @JoinColumn(name = "ID_CLIENTE", referencedColumnName = "ID_CLIENTE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Cliente cliente;
    @JoinColumn(name = "ID_TIPO_VENTA", referencedColumnName = "ID_TIPO_VENTA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoVenta tipoVenta;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "venta", fetch = FetchType.EAGER)
    private List<DetalleVentaProducto> detalleVentaProductoList;
    @OneToMany(mappedBy = "venta", fetch = FetchType.EAGER)
    private List<NotaCredito> notaCreditoList;

    public Venta() {
    }

    public Venta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public Venta(Integer idVenta, int bloqueVenta, int numeroVenta, Date fechaVenta, Date fechaVentaEmision, BigDecimal totalVenta, String observaciones, BigDecimal totalPagosCredito) {
        this.idVenta = idVenta;
        this.bloqueVenta = bloqueVenta;
        this.numeroVenta = numeroVenta;
        this.fechaVenta = fechaVenta;
        this.fechaVentaEmision = fechaVentaEmision;
        this.totalVenta = totalVenta;
        this.observaciones = observaciones;
        this.totalPagosCredito = totalPagosCredito;
    }

    public Integer getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(Integer idVenta) {
        this.idVenta = idVenta;
    }

    public int getBloqueVenta() {
        return bloqueVenta;
    }

    public void setBloqueVenta(int bloqueVenta) {
        this.bloqueVenta = bloqueVenta;
    }

    public int getNumeroVenta() {
        return numeroVenta;
    }

    public void setNumeroVenta(int numeroVenta) {
        this.numeroVenta = numeroVenta;
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

    public BigDecimal getTotalVenta() {
        return totalVenta;
    }

    public void setTotalVenta(BigDecimal totalVenta) {
        this.totalVenta = totalVenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public BigDecimal getTotalPagosCredito() {
        return totalPagosCredito;
    }

    public void setTotalPagosCredito(BigDecimal totalPagosCredito) {
        this.totalPagosCredito = totalPagosCredito;
    }

    public String getFacturaRelacionada() {
        return facturaRelacionada;
    }

    public void setFacturaRelacionada(String facturaRelacionada) {
        this.facturaRelacionada = facturaRelacionada;
    }

    public List<ContratoFumigacion> getContratoFumigacionList() {
        return contratoFumigacionList;
    }

    public void setContratoFumigacionList(List<ContratoFumigacion> contratoFumigacionList) {
        this.contratoFumigacionList = contratoFumigacionList;
    }

    public List<Cambio> getCambioList() {
        return cambioList;
    }

    public void setCambioList(List<Cambio> cambioList) {
        this.cambioList = cambioList;
    }

    public List<PagoVentaCredito> getPagoVentaCreditoList() {
        return pagoVentaCreditoList;
    }

    public void setPagoVentaCreditoList(List<PagoVentaCredito> pagoVentaCreditoList) {
        this.pagoVentaCreditoList = pagoVentaCreditoList;
    }

    public EstadoVenta getEstadoVenta() {
        return estadoVenta;
    }

    public void setEstadoVenta(EstadoVenta estadoVenta) {
        this.estadoVenta = estadoVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public TipoVenta getTipoVenta() {
        return tipoVenta;
    }

    public void setTipoVenta(TipoVenta tipoVenta) {
        this.tipoVenta = tipoVenta;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public List<DetalleVentaProducto> getDetalleVentaProductoList() {
        return detalleVentaProductoList;
    }

    public void setDetalleVentaProductoList(List<DetalleVentaProducto> detalleVentaProductoList) {
        this.detalleVentaProductoList = detalleVentaProductoList;
    }

    public List<NotaCredito> getNotaCreditoList() {
        return notaCreditoList;
    }

    public void setNotaCreditoList(List<NotaCredito> notaCreditoList) {
        this.notaCreditoList = notaCreditoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idVenta != null ? idVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Venta)) {
            return false;
        }
        Venta other = (Venta) object;
        if ((this.idVenta == null && other.idVenta != null) || (this.idVenta != null && !this.idVenta.equals(other.idVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Venta[idVenta=" + idVenta + "]";
    }

}
