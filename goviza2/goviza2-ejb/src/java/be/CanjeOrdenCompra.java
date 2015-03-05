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
@Table(name = "canje_orden_compra")
@NamedQueries({
    @NamedQuery(name = "CanjeOrdenCompra.findAll", query = "SELECT c FROM CanjeOrdenCompra c"),
    @NamedQuery(name = "CanjeOrdenCompra.findByIdCanjeOrdenCompra", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.idCanjeOrdenCompra = :idCanjeOrdenCompra"),
    @NamedQuery(name = "CanjeOrdenCompra.findByFechaCreacionCanje", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.fechaCreacionCanje = :fechaCreacionCanje"),
    @NamedQuery(name = "CanjeOrdenCompra.findByFechaPago", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.fechaPago = :fechaPago"),
    @NamedQuery(name = "CanjeOrdenCompra.findByMontoCanje", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.montoCanje = :montoCanje"),
    @NamedQuery(name = "CanjeOrdenCompra.findByNumeroCuotas", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.numeroCuotas = :numeroCuotas"),
    @NamedQuery(name = "CanjeOrdenCompra.findByNombreBancoPagar", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.nombreBancoPagar = :nombreBancoPagar"),
    @NamedQuery(name = "CanjeOrdenCompra.findByNumeroCuenta", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.numeroCuenta = :numeroCuenta"),
    @NamedQuery(name = "CanjeOrdenCompra.findByObservaciones", query = "SELECT c FROM CanjeOrdenCompra c WHERE c.observaciones = :observaciones")})
public class CanjeOrdenCompra implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CANJE_ORDEN_COMPRA")
    private Integer idCanjeOrdenCompra;
    @Basic(optional = false)
    @Column(name = "FECHA_CREACION_CANJE")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacionCanje;
    @Basic(optional = false)
    @Column(name = "FECHA_PAGO")
    @Temporal(TemporalType.DATE)
    private Date fechaPago;
    @Basic(optional = false)
    @Column(name = "MONTO_CANJE")
    private BigDecimal montoCanje;
    @Basic(optional = false)
    @Column(name = "NUMERO_CUOTAS")
    private int numeroCuotas;
    @Basic(optional = false)
    @Column(name = "NOMBRE_BANCO_PAGAR")
    private String nombreBancoPagar;
    @Basic(optional = false)
    @Column(name = "NUMERO_CUENTA")
    private String numeroCuenta;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "canjeOrdenCompra", fetch = FetchType.EAGER)
    private List<LetrasPagoCanje> letrasPagoCanjeList;
    @JoinColumn(name = "ID_ESTADO_CANJE_ORDEN_COMPRA", referencedColumnName = "ID_ESTADO_CANJE_ORDEN_COMPRA")
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoCanjeOrdenCompra estadoCanjeOrdenCompra;
    @JoinColumn(name = "ID_ORDEN_COMPRA", referencedColumnName = "ID_ORDEN_COMPRA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private OrdenCompra ordenCompra;

    public CanjeOrdenCompra() {
    }

    public CanjeOrdenCompra(Integer idCanjeOrdenCompra) {
        this.idCanjeOrdenCompra = idCanjeOrdenCompra;
    }

    public CanjeOrdenCompra(Integer idCanjeOrdenCompra, Date fechaCreacionCanje, Date fechaPago, BigDecimal montoCanje, int numeroCuotas, String nombreBancoPagar, String numeroCuenta, String observaciones) {
        this.idCanjeOrdenCompra = idCanjeOrdenCompra;
        this.fechaCreacionCanje = fechaCreacionCanje;
        this.fechaPago = fechaPago;
        this.montoCanje = montoCanje;
        this.numeroCuotas = numeroCuotas;
        this.nombreBancoPagar = nombreBancoPagar;
        this.numeroCuenta = numeroCuenta;
        this.observaciones = observaciones;
    }

    public Integer getIdCanjeOrdenCompra() {
        return idCanjeOrdenCompra;
    }

    public void setIdCanjeOrdenCompra(Integer idCanjeOrdenCompra) {
        this.idCanjeOrdenCompra = idCanjeOrdenCompra;
    }

    public Date getFechaCreacionCanje() {
        return fechaCreacionCanje;
    }

    public void setFechaCreacionCanje(Date fechaCreacionCanje) {
        this.fechaCreacionCanje = fechaCreacionCanje;
    }

    public Date getFechaPago() {
        return fechaPago;
    }

    public void setFechaPago(Date fechaPago) {
        this.fechaPago = fechaPago;
    }

    public BigDecimal getMontoCanje() {
        return montoCanje;
    }

    public void setMontoCanje(BigDecimal montoCanje) {
        this.montoCanje = montoCanje;
    }

    public int getNumeroCuotas() {
        return numeroCuotas;
    }

    public void setNumeroCuotas(int numeroCuotas) {
        this.numeroCuotas = numeroCuotas;
    }

    public String getNombreBancoPagar() {
        return nombreBancoPagar;
    }

    public void setNombreBancoPagar(String nombreBancoPagar) {
        this.nombreBancoPagar = nombreBancoPagar;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public List<LetrasPagoCanje> getLetrasPagoCanjeList() {
        return letrasPagoCanjeList;
    }

    public void setLetrasPagoCanjeList(List<LetrasPagoCanje> letrasPagoCanjeList) {
        this.letrasPagoCanjeList = letrasPagoCanjeList;
    }

    public EstadoCanjeOrdenCompra getEstadoCanjeOrdenCompra() {
        return estadoCanjeOrdenCompra;
    }

    public void setEstadoCanjeOrdenCompra(EstadoCanjeOrdenCompra estadoCanjeOrdenCompra) {
        this.estadoCanjeOrdenCompra = estadoCanjeOrdenCompra;
    }

    public OrdenCompra getOrdenCompra() {
        return ordenCompra;
    }

    public void setOrdenCompra(OrdenCompra ordenCompra) {
        this.ordenCompra = ordenCompra;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCanjeOrdenCompra != null ? idCanjeOrdenCompra.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CanjeOrdenCompra)) {
            return false;
        }
        CanjeOrdenCompra other = (CanjeOrdenCompra) object;
        if ((this.idCanjeOrdenCompra == null && other.idCanjeOrdenCompra != null) || (this.idCanjeOrdenCompra != null && !this.idCanjeOrdenCompra.equals(other.idCanjeOrdenCompra))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.CanjeOrdenCompra[idCanjeOrdenCompra=" + idCanjeOrdenCompra + "]";
    }

}
