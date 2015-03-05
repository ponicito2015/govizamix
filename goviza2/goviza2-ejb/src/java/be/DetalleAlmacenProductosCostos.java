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
@Table(name = "detalle_almacen_productos_costos")
@NamedQueries({
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findAll", query = "SELECT d FROM DetalleAlmacenProductosCostos d"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByIdDetalleAlmacenProductosCostos", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.idDetalleAlmacenProductosCostos = :idDetalleAlmacenProductosCostos"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByCosto", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.costo = :costo"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByFechaEntrada", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.fechaEntrada = :fechaEntrada"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByFechaSalida", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "DetalleAlmacenProductosCostos.findByObservaciones", query = "SELECT d FROM DetalleAlmacenProductosCostos d WHERE d.observaciones = :observaciones")})
public class DetalleAlmacenProductosCostos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_ALMACEN_PRODUCTOS_COSTOS")
    private Integer idDetalleAlmacenProductosCostos;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "FECHA_ENTRADA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaEntrada;
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES")
    private String observaciones;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN", referencedColumnName = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN")
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoProductoCostoAlmacen estadoProductoCostoAlmacen;
    @JoinColumn(name = "ID_PROCEDENCIA_PRODUCTO_ALMACEN", referencedColumnName = "ID_PROCEDENCIA_PRODUCTO_ALMACEN")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProcedenciaProductoAlmacen procedenciaProductoAlmacen;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleAlmacenProductosCostos", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList;

    public DetalleAlmacenProductosCostos() {
    }

    public DetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
    }

    public DetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos, BigDecimal costo, Date fechaEntrada, String observaciones) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
        this.costo = costo;
        this.fechaEntrada = fechaEntrada;
        this.observaciones = observaciones;
    }

    public Integer getIdDetalleAlmacenProductosCostos() {
        return idDetalleAlmacenProductosCostos;
    }

    public void setIdDetalleAlmacenProductosCostos(Integer idDetalleAlmacenProductosCostos) {
        this.idDetalleAlmacenProductosCostos = idDetalleAlmacenProductosCostos;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public Date getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(Date fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public EstadoProductoCostoAlmacen getEstadoProductoCostoAlmacen() {
        return estadoProductoCostoAlmacen;
    }

    public void setEstadoProductoCostoAlmacen(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen) {
        this.estadoProductoCostoAlmacen = estadoProductoCostoAlmacen;
    }

    public ProcedenciaProductoAlmacen getProcedenciaProductoAlmacen() {
        return procedenciaProductoAlmacen;
    }

    public void setProcedenciaProductoAlmacen(ProcedenciaProductoAlmacen procedenciaProductoAlmacen) {
        this.procedenciaProductoAlmacen = procedenciaProductoAlmacen;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<OrdenSalidaDetalleAlmacenProductosCostos> getOrdenSalidaDetalleAlmacenProductosCostosList() {
        return ordenSalidaDetalleAlmacenProductosCostosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosCostosList(List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList) {
        this.ordenSalidaDetalleAlmacenProductosCostosList = ordenSalidaDetalleAlmacenProductosCostosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleAlmacenProductosCostos != null ? idDetalleAlmacenProductosCostos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleAlmacenProductosCostos)) {
            return false;
        }
        DetalleAlmacenProductosCostos other = (DetalleAlmacenProductosCostos) object;
        if ((this.idDetalleAlmacenProductosCostos == null && other.idDetalleAlmacenProductosCostos != null) || (this.idDetalleAlmacenProductosCostos != null && !this.idDetalleAlmacenProductosCostos.equals(other.idDetalleAlmacenProductosCostos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleAlmacenProductosCostos[idDetalleAlmacenProductosCostos=" + idDetalleAlmacenProductosCostos + "]";
    }

}
