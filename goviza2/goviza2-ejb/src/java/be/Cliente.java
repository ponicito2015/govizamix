/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
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

/**
 *
 * @author argos
 */
@Entity
@Table(name = "cliente")
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    @NamedQuery(name = "Cliente.findByIdCliente", query = "SELECT c FROM Cliente c WHERE c.idCliente = :idCliente"),
    @NamedQuery(name = "Cliente.findByNombreCliente", query = "SELECT c FROM Cliente c WHERE c.nombreCliente = :nombreCliente"),
    @NamedQuery(name = "Cliente.findByRazonSocial", query = "SELECT c FROM Cliente c WHERE c.razonSocial = :razonSocial"),
    @NamedQuery(name = "Cliente.findByGiroRubro", query = "SELECT c FROM Cliente c WHERE c.giroRubro = :giroRubro"),
    @NamedQuery(name = "Cliente.findByContacto", query = "SELECT c FROM Cliente c WHERE c.contacto = :contacto"),
    @NamedQuery(name = "Cliente.findByRucCliente", query = "SELECT c FROM Cliente c WHERE c.rucCliente = :rucCliente"),
    @NamedQuery(name = "Cliente.findByDireccion", query = "SELECT c FROM Cliente c WHERE c.direccion = :direccion"),
    @NamedQuery(name = "Cliente.findByTelefono", query = "SELECT c FROM Cliente c WHERE c.telefono = :telefono"),
    @NamedQuery(name = "Cliente.findByCelular", query = "SELECT c FROM Cliente c WHERE c.celular = :celular"),
    @NamedQuery(name = "Cliente.findByNextel", query = "SELECT c FROM Cliente c WHERE c.nextel = :nextel"),
    @NamedQuery(name = "Cliente.findByCorreo", query = "SELECT c FROM Cliente c WHERE c.correo = :correo")})
public class Cliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_CLIENTE")
    private Integer idCliente;
    @Basic(optional = false)
    @Column(name = "NOMBRE_CLIENTE")
    private String nombreCliente;
    @Basic(optional = false)
    @Column(name = "RAZON_SOCIAL")
    private String razonSocial;
    @Basic(optional = false)
    @Column(name = "GIRO_RUBRO")
    private String giroRubro;
    @Basic(optional = false)
    @Column(name = "CONTACTO")
    private String contacto;
    @Basic(optional = false)
    @Column(name = "RUC_CLIENTE")
    private String rucCliente;
    @Basic(optional = false)
    @Column(name = "DIRECCION")
    private String direccion;
    @Basic(optional = false)
    @Column(name = "TELEFONO")
    private String telefono;
    @Basic(optional = false)
    @Column(name = "CELULAR")
    private String celular;
    @Basic(optional = false)
    @Column(name = "NEXTEL")
    private String nextel;
    @Basic(optional = false)
    @Column(name = "CORREO")
    private String correo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Actividad> actividadList;
    @JoinColumn(name = "ID_ZONA_CIUDAD", referencedColumnName = "ID_ZONA_CIUDAD")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ZonaCiudad zonaCiudad;
    @JoinColumn(name = "ID_TIPO_CLIENTE", referencedColumnName = "ID_TIPO_CLIENTE")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private TipoCliente tipoCliente;
    @JoinColumn(name = "ID_MERCADO", referencedColumnName = "ID_MERCADO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Mercado mercado;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<Venta> ventaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente", fetch = FetchType.EAGER)
    private List<OrdenSalidaDetalleAlmacenProductos> ordenSalidaDetalleAlmacenProductosList;

    public Cliente() {
    }

    public Cliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Cliente(Integer idCliente, String nombreCliente, String razonSocial, String giroRubro, String contacto, String rucCliente, String direccion, String telefono, String celular, String nextel, String correo) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.razonSocial = razonSocial;
        this.giroRubro = giroRubro;
        this.contacto = contacto;
        this.rucCliente = rucCliente;
        this.direccion = direccion;
        this.telefono = telefono;
        this.celular = celular;
        this.nextel = nextel;
        this.correo = correo;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getGiroRubro() {
        return giroRubro;
    }

    public void setGiroRubro(String giroRubro) {
        this.giroRubro = giroRubro;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getRucCliente() {
        return rucCliente;
    }

    public void setRucCliente(String rucCliente) {
        this.rucCliente = rucCliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNextel() {
        return nextel;
    }

    public void setNextel(String nextel) {
        this.nextel = nextel;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public List<Actividad> getActividadList() {
        return actividadList;
    }

    public void setActividadList(List<Actividad> actividadList) {
        this.actividadList = actividadList;
    }

    public ZonaCiudad getZonaCiudad() {
        return zonaCiudad;
    }

    public void setZonaCiudad(ZonaCiudad zonaCiudad) {
        this.zonaCiudad = zonaCiudad;
    }

    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public Mercado getMercado() {
        return mercado;
    }

    public void setMercado(Mercado mercado) {
        this.mercado = mercado;
    }

    public List<DetalleVentaRapidaProducto> getDetalleVentaRapidaProductoList() {
        return detalleVentaRapidaProductoList;
    }

    public void setDetalleVentaRapidaProductoList(List<DetalleVentaRapidaProducto> detalleVentaRapidaProductoList) {
        this.detalleVentaRapidaProductoList = detalleVentaRapidaProductoList;
    }

    public List<OrdenSalidaDetalleAlmacenProductosCostos> getOrdenSalidaDetalleAlmacenProductosCostosList() {
        return ordenSalidaDetalleAlmacenProductosCostosList;
    }

    public void setOrdenSalidaDetalleAlmacenProductosCostosList(List<OrdenSalidaDetalleAlmacenProductosCostos> ordenSalidaDetalleAlmacenProductosCostosList) {
        this.ordenSalidaDetalleAlmacenProductosCostosList = ordenSalidaDetalleAlmacenProductosCostosList;
    }

    public List<FacturaVenta> getFacturaVentaList() {
        return facturaVentaList;
    }

    public void setFacturaVentaList(List<FacturaVenta> facturaVentaList) {
        this.facturaVentaList = facturaVentaList;
    }

    public List<Venta> getVentaList() {
        return ventaList;
    }

    public void setVentaList(List<Venta> ventaList) {
        this.ventaList = ventaList;
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
        hash += (idCliente != null ? idCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Cliente)) {
            return false;
        }
        Cliente other = (Cliente) object;
        if ((this.idCliente == null && other.idCliente != null) || (this.idCliente != null && !this.idCliente.equals(other.idCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Cliente[idCliente=" + idCliente + "]";
    }

}
