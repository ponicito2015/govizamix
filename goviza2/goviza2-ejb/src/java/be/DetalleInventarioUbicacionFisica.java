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
@Table(name = "detalle_inventario_ubicacion_fisica")
@NamedQueries({
    @NamedQuery(name = "DetalleInventarioUbicacionFisica.findAll", query = "SELECT d FROM DetalleInventarioUbicacionFisica d"),
    @NamedQuery(name = "DetalleInventarioUbicacionFisica.findByIdDetalleInventarioUbicacionFisica", query = "SELECT d FROM DetalleInventarioUbicacionFisica d WHERE d.idDetalleInventarioUbicacionFisica = :idDetalleInventarioUbicacionFisica")})
public class DetalleInventarioUbicacionFisica implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_DETALLE_INVENTARIO_UBICACION_FISICA")
    private Integer idDetalleInventarioUbicacionFisica;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "detalleInventarioUbicacionFisica", fetch = FetchType.EAGER)
    private List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList;
    @JoinColumn(name = "ID_UBICACION_FISICA", referencedColumnName = "ID_UBICACION_FISICA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private UbicacionFisica ubicacionFisica;
    @JoinColumn(name = "ID_INVENTARIO_FISICO", referencedColumnName = "ID_INVENTARIO_FISICO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private InventarioFisico inventarioFisico;

    public DetalleInventarioUbicacionFisica() {
    }

    public DetalleInventarioUbicacionFisica(Integer idDetalleInventarioUbicacionFisica) {
        this.idDetalleInventarioUbicacionFisica = idDetalleInventarioUbicacionFisica;
    }

    public Integer getIdDetalleInventarioUbicacionFisica() {
        return idDetalleInventarioUbicacionFisica;
    }

    public void setIdDetalleInventarioUbicacionFisica(Integer idDetalleInventarioUbicacionFisica) {
        this.idDetalleInventarioUbicacionFisica = idDetalleInventarioUbicacionFisica;
    }

    public List<DetalleUbicacionFisicaProducto> getDetalleUbicacionFisicaProductoList() {
        return detalleUbicacionFisicaProductoList;
    }

    public void setDetalleUbicacionFisicaProductoList(List<DetalleUbicacionFisicaProducto> detalleUbicacionFisicaProductoList) {
        this.detalleUbicacionFisicaProductoList = detalleUbicacionFisicaProductoList;
    }

    public UbicacionFisica getUbicacionFisica() {
        return ubicacionFisica;
    }

    public void setUbicacionFisica(UbicacionFisica ubicacionFisica) {
        this.ubicacionFisica = ubicacionFisica;
    }

    public InventarioFisico getInventarioFisico() {
        return inventarioFisico;
    }

    public void setInventarioFisico(InventarioFisico inventarioFisico) {
        this.inventarioFisico = inventarioFisico;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDetalleInventarioUbicacionFisica != null ? idDetalleInventarioUbicacionFisica.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleInventarioUbicacionFisica)) {
            return false;
        }
        DetalleInventarioUbicacionFisica other = (DetalleInventarioUbicacionFisica) object;
        if ((this.idDetalleInventarioUbicacionFisica == null && other.idDetalleInventarioUbicacionFisica != null) || (this.idDetalleInventarioUbicacionFisica != null && !this.idDetalleInventarioUbicacionFisica.equals(other.idDetalleInventarioUbicacionFisica))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleInventarioUbicacionFisica[idDetalleInventarioUbicacionFisica=" + idDetalleInventarioUbicacionFisica + "]";
    }

}
