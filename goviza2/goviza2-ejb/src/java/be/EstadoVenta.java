/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
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
@Table(name = "estado_venta")
@NamedQueries({
    @NamedQuery(name = "EstadoVenta.findAll", query = "SELECT e FROM EstadoVenta e"),
    @NamedQuery(name = "EstadoVenta.findByIdEstadoVenta", query = "SELECT e FROM EstadoVenta e WHERE e.idEstadoVenta = :idEstadoVenta"),
    @NamedQuery(name = "EstadoVenta.findByNombreTestadoVenta", query = "SELECT e FROM EstadoVenta e WHERE e.nombreTestadoVenta = :nombreTestadoVenta"),
    @NamedQuery(name = "EstadoVenta.findByDescripcion", query = "SELECT e FROM EstadoVenta e WHERE e.descripcion = :descripcion")})
public class EstadoVenta implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_ESTADO_VENTA")
    private Integer idEstadoVenta;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TESTADO_VENTA")
    private String nombreTestadoVenta;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "estadoVenta", fetch = FetchType.EAGER)
    private List<FacturaVenta> facturaVentaList;
    @OneToMany(mappedBy = "estadoVenta", fetch = FetchType.EAGER)
    private List<Venta> ventaList;

    public EstadoVenta() {
    }

    public EstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }

    public EstadoVenta(Integer idEstadoVenta, String nombreTestadoVenta, String descripcion) {
        this.idEstadoVenta = idEstadoVenta;
        this.nombreTestadoVenta = nombreTestadoVenta;
        this.descripcion = descripcion;
    }

    public Integer getIdEstadoVenta() {
        return idEstadoVenta;
    }

    public void setIdEstadoVenta(Integer idEstadoVenta) {
        this.idEstadoVenta = idEstadoVenta;
    }

    public String getNombreTestadoVenta() {
        return nombreTestadoVenta;
    }

    public void setNombreTestadoVenta(String nombreTestadoVenta) {
        this.nombreTestadoVenta = nombreTestadoVenta;
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
        hash += (idEstadoVenta != null ? idEstadoVenta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EstadoVenta)) {
            return false;
        }
        EstadoVenta other = (EstadoVenta) object;
        if ((this.idEstadoVenta == null && other.idEstadoVenta != null) || (this.idEstadoVenta != null && !this.idEstadoVenta.equals(other.idEstadoVenta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.EstadoVenta[idEstadoVenta=" + idEstadoVenta + "]";
    }

}
