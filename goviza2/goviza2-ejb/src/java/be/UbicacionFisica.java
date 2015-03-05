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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author argos
 */
@Entity
@Table(name = "ubicacion_fisica")
@NamedQueries({
    @NamedQuery(name = "UbicacionFisica.findAll", query = "SELECT u FROM UbicacionFisica u"),
    @NamedQuery(name = "UbicacionFisica.findByIdUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.idUbicacionFisica = :idUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByNombreUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.nombreUbicacionFisica = :nombreUbicacionFisica"),
    @NamedQuery(name = "UbicacionFisica.findByDescripcionUbicacionFisica", query = "SELECT u FROM UbicacionFisica u WHERE u.descripcionUbicacionFisica = :descripcionUbicacionFisica")})
public class UbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_UBICACION_FISICA")
    private Integer idUbicacionFisica;
    @Basic(optional = false)
    @Column(name = "NOMBRE_UBICACION_FISICA")
    private String nombreUbicacionFisica;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_UBICACION_FISICA")
    private String descripcionUbicacionFisica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.EAGER)
    private List<DetalleAlmacenProductos> detalleAlmacenProductosList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.EAGER)
    private List<IngresoProductoTienda> ingresoProductoTiendaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "ubicacionFisica", fetch = FetchType.EAGER)
    private List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList;

    public UbicacionFisica() {
    }

    public UbicacionFisica(Integer idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public UbicacionFisica(Integer idUbicacionFisica, String nombreUbicacionFisica, String descripcionUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
        this.nombreUbicacionFisica = nombreUbicacionFisica;
        this.descripcionUbicacionFisica = descripcionUbicacionFisica;
    }

    public Integer getIdUbicacionFisica() {
        return idUbicacionFisica;
    }

    public void setIdUbicacionFisica(Integer idUbicacionFisica) {
        this.idUbicacionFisica = idUbicacionFisica;
    }

    public String getNombreUbicacionFisica() {
        return nombreUbicacionFisica;
    }

    public void setNombreUbicacionFisica(String nombreUbicacionFisica) {
        this.nombreUbicacionFisica = nombreUbicacionFisica;
    }

    public String getDescripcionUbicacionFisica() {
        return descripcionUbicacionFisica;
    }

    public void setDescripcionUbicacionFisica(String descripcionUbicacionFisica) {
        this.descripcionUbicacionFisica = descripcionUbicacionFisica;
    }

    public List<DetalleAlmacenProductos> getDetalleAlmacenProductosList() {
        return detalleAlmacenProductosList;
    }

    public void setDetalleAlmacenProductosList(List<DetalleAlmacenProductos> detalleAlmacenProductosList) {
        this.detalleAlmacenProductosList = detalleAlmacenProductosList;
    }

    public List<IngresoProductoTienda> getIngresoProductoTiendaList() {
        return ingresoProductoTiendaList;
    }

    public void setIngresoProductoTiendaList(List<IngresoProductoTienda> ingresoProductoTiendaList) {
        this.ingresoProductoTiendaList = ingresoProductoTiendaList;
    }

    public List<DetalleInventarioUbicacionFisica> getDetalleInventarioUbicacionFisicaList() {
        return detalleInventarioUbicacionFisicaList;
    }

    public void setDetalleInventarioUbicacionFisicaList(List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList) {
        this.detalleInventarioUbicacionFisicaList = detalleInventarioUbicacionFisicaList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idUbicacionFisica != null ? idUbicacionFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UbicacionFisica)) {
            return false;
        }
        UbicacionFisica other = (UbicacionFisica) object;
        if ((this.idUbicacionFisica == null && other.idUbicacionFisica != null) || (this.idUbicacionFisica != null && !this.idUbicacionFisica.equals(other.idUbicacionFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.UbicacionFisica[idUbicacionFisica=" + idUbicacionFisica + "]";
    }

}
