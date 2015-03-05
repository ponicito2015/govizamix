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
@Table(name = "detalle_almacen_productos")
@NamedQueries({
    @NamedQuery(name = "DetalleAlmacenProductos.findAll", query = "SELECT d FROM DetalleAlmacenProductos d"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByIdDetalleAlmacenProductos", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.idDetalleAlmacenProductos = :idDetalleAlmacenProductos"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByCosto", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.costo = :costo"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByCantidad", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.cantidad = :cantidad"),
    @NamedQuery(name = "DetalleAlmacenProductos.findBySalieron", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.salieron = :salieron"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByQuedaron", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.quedaron = :quedaron"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByFechaIngreso", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.fechaIngreso = :fechaIngreso"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByFechaVencimiento", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.fechaVencimiento = :fechaVencimiento"),
    @NamedQuery(name = "DetalleAlmacenProductos.findByDescripcionMotivo", query = "SELECT d FROM DetalleAlmacenProductos d WHERE d.descripcionMotivo = :descripcionMotivo")})
public class DetalleAlmacenProductos implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_ALMACEN_PRODUCTOS")
    private Integer idDetalleAlmacenProductos;
    @Basic(optional = false)
    @Column(name = "COSTO")
    private BigDecimal costo;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private int cantidad;
    @Basic(optional = false)
    @Column(name = "SALIERON")
    private int salieron;
    @Basic(optional = false)
    @Column(name = "QUEDARON")
    private int quedaron;
    @Basic(optional = false)
    @Column(name = "FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date fechaIngreso;
    @Basic(optional = false)
    @Column(name = "FECHA_VENCIMIENTO")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @Column(name = "DESCRIPCION_MOTIVO")
    private String descripcionMotivo;
    @JoinColumn(name = "ID_UBICACION_FISICA", referencedColumnName = "ID_UBICACION_FISICA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UbicacionFisica ubicacionFisica;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "ID_PROCEDENCIA_PRODUCTO_ALMACEN", referencedColumnName = "ID_PROCEDENCIA_PRODUCTO_ALMACEN")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ProcedenciaProductoAlmacen procedenciaProductoAlmacen;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @JoinColumn(name = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN", referencedColumnName = "ID_ESTADO_PRODUCTO_COSTO_ALMACEN")
    @ManyToOne(fetch = FetchType.EAGER)
    private EstadoProductoCostoAlmacen estadoProductoCostoAlmacen;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleAlmacenProductos", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;

    public DetalleAlmacenProductos() {
    }

    public DetalleAlmacenProductos(Integer idDetalleAlmacenProductos) {
        this.idDetalleAlmacenProductos = idDetalleAlmacenProductos;
    }

    public DetalleAlmacenProductos(Integer idDetalleAlmacenProductos, BigDecimal costo, int cantidad, int salieron, int quedaron, Date fechaIngreso, Date fechaVencimiento) {
        this.idDetalleAlmacenProductos = idDetalleAlmacenProductos;
        this.costo = costo;
        this.cantidad = cantidad;
        this.salieron = salieron;
        this.quedaron = quedaron;
        this.fechaIngreso = fechaIngreso;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getIdDetalleAlmacenProductos() {
        return idDetalleAlmacenProductos;
    }

    public void setIdDetalleAlmacenProductos(Integer idDetalleAlmacenProductos) {
        this.idDetalleAlmacenProductos = idDetalleAlmacenProductos;
    }

    public BigDecimal getCosto() {
        return costo;
    }

    public void setCosto(BigDecimal costo) {
        this.costo = costo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getSalieron() {
        return salieron;
    }

    public void setSalieron(int salieron) {
        this.salieron = salieron;
    }

    public int getQuedaron() {
        return quedaron;
    }

    public void setQuedaron(int quedaron) {
        this.quedaron = quedaron;
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

    public String getDescripcionMotivo() {
        return descripcionMotivo;
    }

    public void setDescripcionMotivo(String descripcionMotivo) {
        this.descripcionMotivo = descripcionMotivo;
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
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

    public EstadoProductoCostoAlmacen getEstadoProductoCostoAlmacen() {
        return estadoProductoCostoAlmacen;
    }

    public void setEstadoProductoCostoAlmacen(EstadoProductoCostoAlmacen estadoProductoCostoAlmacen) {
        this.estadoProductoCostoAlmacen = estadoProductoCostoAlmacen;
    }

    public List<OrdenSalidaDetalleAlmacenProductos> getOrdenSalidaDetalleAlmacenProductosList() {
        return ordenSalidaDetalleAlmacenProductosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosList(List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList) {
        this.ordenSalidaDetalleAlmacenProductosList = ordenSalidaDetalleAlmacenProductosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleAlmacenProductos != null ? idDetalleAlmacenProductos.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleAlmacenProductos)) {
            return false;
        }
        DetalleAlmacenProductos other = (DetalleAlmacenProductos) object;
        if ((this.idDetalleAlmacenProductos == null && other.idDetalleAlmacenProductos != null) || (this.idDetalleAlmacenProductos != null && !this.idDetalleAlmacenProductos.equals(other.idDetalleAlmacenProductos))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleAlmacenProductos[idDetalleAlmacenProductos=" + idDetalleAlmacenProductos + "]";
    }

}
