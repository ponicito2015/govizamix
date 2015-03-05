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
@Table(name = "formulacion")
@NamedQueries({
    @NamedQuery(name = "Formulacion.findAll", query = "SELECT f FROM Formulacion f"),
    @NamedQuery(name = "Formulacion.findByIdFormulacion", query = "SELECT f FROM Formulacion f WHERE f.idFormulacion = :idFormulacion"),
    @NamedQuery(name = "Formulacion.findByFechaRegistro", query = "SELECT f FROM Formulacion f WHERE f.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "Formulacion.findByPalabraClave", query = "SELECT f FROM Formulacion f WHERE f.palabraClave = :palabraClave"),
    @NamedQuery(name = "Formulacion.findByDescripcion", query = "SELECT f FROM Formulacion f WHERE f.descripcion = :descripcion")})
public class Formulacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_FORMULACION")
    private Integer idFormulacion;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "PALABRA_CLAVE")
    private String palabraClave;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_PRODUCTO", referencedColumnName = "ID_PRODUCTO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto producto;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formulacion", fetch = FetchType.EAGER)
    private List<DetalleFormulacionInsumos> detalleFormulacionInsumosList;
    @OneToMany(mappedBy = "formulacion", fetch = FetchType.EAGER)
    private List<ProduccionAlmacen> produccionAlmacenList;

    public Formulacion() {
    }

    public Formulacion(Integer idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public Formulacion(Integer idFormulacion, Date fechaRegistro, String palabraClave, String descripcion) {
        this.idFormulacion = idFormulacion;
        this.fechaRegistro = fechaRegistro;
        this.palabraClave = palabraClave;
        this.descripcion = descripcion;
    }

    public Integer getIdFormulacion() {
        return idFormulacion;
    }

    public void setIdFormulacion(Integer idFormulacion) {
        this.idFormulacion = idFormulacion;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getPalabraClave() {
        return palabraClave;
    }

    public void setPalabraClave(String palabraClave) {
        this.palabraClave = palabraClave;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public List<DetalleFormulacionInsumos> getDetalleFormulacionInsumosList() {
        return detalleFormulacionInsumosList;
    }

    public void setDetalleFormulacionInsumosList(List<DetalleFormulacionInsumos> detalleFormulacionInsumosList) {
        this.detalleFormulacionInsumosList = detalleFormulacionInsumosList;
    }

    public List<ProduccionAlmacen> getProduccionAlmacenList() {
        return produccionAlmacenList;
    }

    public void setProduccionAlmacenList(List<ProduccionAlmacen> produccionAlmacenList) {
        this.produccionAlmacenList = produccionAlmacenList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFormulacion != null ? idFormulacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Formulacion)) {
            return false;
        }
        Formulacion other = (Formulacion) object;
        if ((this.idFormulacion == null && other.idFormulacion != null) || (this.idFormulacion != null && !this.idFormulacion.equals(other.idFormulacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.Formulacion[idFormulacion=" + idFormulacion + "]";
    }

}
