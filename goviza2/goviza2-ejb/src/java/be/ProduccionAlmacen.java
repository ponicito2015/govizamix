/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
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
@Table(name = "produccion_almacen")
@NamedQueries({
    @NamedQuery(name = "ProduccionAlmacen.findAll", query = "SELECT p FROM ProduccionAlmacen p"),
    @NamedQuery(name = "ProduccionAlmacen.findByIdProduccionAlmacen", query = "SELECT p FROM ProduccionAlmacen p WHERE p.idProduccionAlmacen = :idProduccionAlmacen"),
    @NamedQuery(name = "ProduccionAlmacen.findByFechaRegistro", query = "SELECT p FROM ProduccionAlmacen p WHERE p.fechaRegistro = :fechaRegistro"),
    @NamedQuery(name = "ProduccionAlmacen.findByCantidadProductoTerminado", query = "SELECT p FROM ProduccionAlmacen p WHERE p.cantidadProductoTerminado = :cantidadProductoTerminado"),
    @NamedQuery(name = "ProduccionAlmacen.findByDescripcion", query = "SELECT p FROM ProduccionAlmacen p WHERE p.descripcion = :descripcion")})
public class ProduccionAlmacen implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_PRODUCCION_ALMACEN")
    private Integer idProduccionAlmacen;
    @Basic(optional = false)
    @Column(name = "FECHA_REGISTRO")
    @Temporal(TemporalType.DATE)
    private Date fechaRegistro;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_PRODUCTO_TERMINADO")
    private int cantidadProductoTerminado;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_TIENDA_ORIGEN", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "ID_FORMULACION", referencedColumnName = "ID_FORMULACION")
    @ManyToOne(fetch = FetchType.EAGER)
    private Formulacion formulacion;

    public ProduccionAlmacen() {
    }

    public ProduccionAlmacen(Integer idProduccionAlmacen) {
        this.idProduccionAlmacen = idProduccionAlmacen;
    }

    public ProduccionAlmacen(Integer idProduccionAlmacen, Date fechaRegistro, int cantidadProductoTerminado, String descripcion) {
        this.idProduccionAlmacen = idProduccionAlmacen;
        this.fechaRegistro = fechaRegistro;
        this.cantidadProductoTerminado = cantidadProductoTerminado;
        this.descripcion = descripcion;
    }

    public Integer getIdProduccionAlmacen() {
        return idProduccionAlmacen;
    }

    public void setIdProduccionAlmacen(Integer idProduccionAlmacen) {
        this.idProduccionAlmacen = idProduccionAlmacen;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public int getCantidadProductoTerminado() {
        return cantidadProductoTerminado;
    }

    public void setCantidadProductoTerminado(int cantidadProductoTerminado) {
        this.cantidadProductoTerminado = cantidadProductoTerminado;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public Formulacion getFormulacion() {
        return formulacion;
    }

    public void setFormulacion(Formulacion formulacion) {
        this.formulacion = formulacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idProduccionAlmacen != null ? idProduccionAlmacen.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProduccionAlmacen)) {
            return false;
        }
        ProduccionAlmacen other = (ProduccionAlmacen) object;
        if ((this.idProduccionAlmacen == null && other.idProduccionAlmacen != null) || (this.idProduccionAlmacen != null && !this.idProduccionAlmacen.equals(other.idProduccionAlmacen))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ProduccionAlmacen[idProduccionAlmacen=" + idProduccionAlmacen + "]";
    }

}
