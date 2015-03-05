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
@Table(name = "tipo_venta")
@NamedQueries({
    @NamedQuery(name = "TipoVenta.findAll", query = "SELECT t FROM TipoVenta t"),
    @NamedQuery(name = "TipoVenta.findByIdTipoVenta", query = "SELECT t FROM TipoVenta t WHERE t.idTipoVenta = :idTipoVenta"),
    @NamedQuery(name = "TipoVenta.findByNombreTipoVenta", query = "SELECT t FROM TipoVenta t WHERE t.nombreTipoVenta = :nombreTipoVenta"),
    @NamedQuery(name = "TipoVenta.findByDescripcion", query = "SELECT t FROM TipoVenta t WHERE t.descripcion = :descripcion")})
public class TipoVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_VENTA")
    private Integer idTipoVenta;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_VENTA")
    private String nombreTipoVenta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVenta", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoVenta", fetch = FetchType.EAGER)
    private List<Venta> ventaList;

    public TipoVenta() {
    }

    public TipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public TipoVenta(Integer idTipoVenta, String nombreTipoVenta, String descripcion) {
        this.idTipoVenta = idTipoVenta;
        this.nombreTipoVenta = nombreTipoVenta;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoVenta() {
        return idTipoVenta;
    }

    public void setIdTipoVenta(Integer idTipoVenta) {
        this.idTipoVenta = idTipoVenta;
    }

    public String getNombreTipoVenta() {
        return nombreTipoVenta;
    }

    public void setNombreTipoVenta(String nombreTipoVenta) {
        this.nombreTipoVenta = nombreTipoVenta;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoVenta != null ? idTipoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoVenta)) {
            return false;
        }
        TipoVenta other = (TipoVenta) object;
        if ((this.idTipoVenta == null && other.idTipoVenta != null) || (this.idTipoVenta != null && !this.idTipoVenta.equals(other.idTipoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoVenta[idTipoVenta=" + idTipoVenta + "]";
    }

}
