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
@Table(name = "inventario_fisico")
@NamedQueries({
    @NamedQuery(name = "InventarioFisico.findAll", query = "SELECT i FROM InventarioFisico i"),
    @NamedQuery(name = "InventarioFisico.findByIdInventarioFisico", query = "SELECT i FROM InventarioFisico i WHERE i.idInventarioFisico = :idInventarioFisico"),
    @NamedQuery(name = "InventarioFisico.findByObervaciones", query = "SELECT i FROM InventarioFisico i WHERE i.obervaciones = :obervaciones"),
    @NamedQuery(name = "InventarioFisico.findByFechaInicio", query = "SELECT i FROM InventarioFisico i WHERE i.fechaInicio = :fechaInicio"),
    @NamedQuery(name = "InventarioFisico.findByFechaTermino", query = "SELECT i FROM InventarioFisico i WHERE i.fechaTermino = :fechaTermino")})
public class InventarioFisico implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_INVENTARIO_FISICO")
    private Integer idInventarioFisico;
    @Basic(optional = false)
    @Column(name = "OBERVACIONES")
    private String obervaciones;
    @Basic(optional = false)
    @Column(name = "FECHA_INICIO")
    @Temporal(TemporalType.DATE)
    private Date fechaInicio;
    @Basic(optional = false)
    @Column(name = "FECHA_TERMINO")
    @Temporal(TemporalType.DATE)
    private Date fechaTermino;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioFisico", fetch = FetchType.EAGER)
    private List<InventarioInicialSistema> inventarioInicialSistemaList;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "inventarioFisico", fetch = FetchType.EAGER)
    private List<DetalleInventarioUbicacionFisica> detalleInventarioUbicacionFisicaList;

    public InventarioFisico() {
    }

    public InventarioFisico(Integer idInventarioFisico) {
        this.idInventarioFisico = idInventarioFisico;
    }

    public InventarioFisico(Integer idInventarioFisico, String obervaciones, Date fechaInicio, Date fechaTermino) {
        this.idInventarioFisico = idInventarioFisico;
        this.obervaciones = obervaciones;
        this.fechaInicio = fechaInicio;
        this.fechaTermino = fechaTermino;
    }

    public Integer getIdInventarioFisico() {
        return idInventarioFisico;
    }

    public void setIdInventarioFisico(Integer idInventarioFisico) {
        this.idInventarioFisico = idInventarioFisico;
    }

    public String getObervaciones() {
        return obervaciones;
    }

    public void setObervaciones(String obervaciones) {
        this.obervaciones = obervaciones;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaTermino() {
        return fechaTermino;
    }

    public void setFechaTermino(Date fechaTermino) {
        this.fechaTermino = fechaTermino;
    }

    public List<InventarioInicialSistema> getInventarioInicialSistemaList() {
        return inventarioInicialSistemaList;
    }

    public void setInventarioInicialSistemaList(List<InventarioInicialSistema> inventarioInicialSistemaList) {
        this.inventarioInicialSistemaList = inventarioInicialSistemaList;
    }

    public Tienda getTienda() {
        return tienda;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
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
        hash += (idInventarioFisico != null ? idInventarioFisico.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InventarioFisico)) {
            return false;
        }
        InventarioFisico other = (InventarioFisico) object;
        if ((this.idInventarioFisico == null && other.idInventarioFisico != null) || (this.idInventarioFisico != null && !this.idInventarioFisico.equals(other.idInventarioFisico))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.InventarioFisico[idInventarioFisico=" + idInventarioFisico + "]";
    }

}
