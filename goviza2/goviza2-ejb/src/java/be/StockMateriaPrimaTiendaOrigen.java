/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "stock_materia_prima_tienda_origen")
@NamedQueries({
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findAll", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByIdMateriaPrima", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.stockMateriaPrimaTiendaOrigenPK.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByIdTiendaOrigen", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.stockMateriaPrimaTiendaOrigenPK.idTiendaOrigen = :idTiendaOrigen"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByCantidad", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByUltimaFechaIngreso", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.ultimaFechaIngreso = :ultimaFechaIngreso"),
    @NamedQuery(name = "StockMateriaPrimaTiendaOrigen.findByDescripcion", query = "SELECT s FROM StockMateriaPrimaTiendaOrigen s WHERE s.descripcion = :descripcion")})
public class StockMateriaPrimaTiendaOrigen implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "ULTIMA_FECHA_INGRESO")
    @Temporal(TemporalType.DATE)
    private Date ultimaFechaIngreso;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @JoinColumn(name = "ID_TIENDA_ORIGEN", referencedColumnName = "ID_TIENDA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "ID_MATERIA_PRIMA", referencedColumnName = "ID_MATERIA_PRIMA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MateriaPrima materiaPrima;

    public StockMateriaPrimaTiendaOrigen() {
    }

    public StockMateriaPrimaTiendaOrigen(StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK) {
        this.stockMateriaPrimaTiendaOrigenPK = stockMateriaPrimaTiendaOrigenPK;
    }

    public StockMateriaPrimaTiendaOrigen(StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK, BigDecimal cantidad, Date ultimaFechaIngreso) {
        this.stockMateriaPrimaTiendaOrigenPK = stockMateriaPrimaTiendaOrigenPK;
        this.cantidad = cantidad;
        this.ultimaFechaIngreso = ultimaFechaIngreso;
    }

    public StockMateriaPrimaTiendaOrigen(int idMateriaPrima, int idTiendaOrigen) {
        this.stockMateriaPrimaTiendaOrigenPK = new StockMateriaPrimaTiendaOrigenPK(idMateriaPrima, idTiendaOrigen);
    }

    public StockMateriaPrimaTiendaOrigenPK getStockMateriaPrimaTiendaOrigenPK() {
        return stockMateriaPrimaTiendaOrigenPK;
    }

    public void setStockMateriaPrimaTiendaOrigenPK(StockMateriaPrimaTiendaOrigenPK stockMateriaPrimaTiendaOrigenPK) {
        this.stockMateriaPrimaTiendaOrigenPK = stockMateriaPrimaTiendaOrigenPK;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getUltimaFechaIngreso() {
        return ultimaFechaIngreso;
    }

    public void setUltimaFechaIngreso(Date ultimaFechaIngreso) {
        this.ultimaFechaIngreso = ultimaFechaIngreso;
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

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (stockMateriaPrimaTiendaOrigenPK != null ? stockMateriaPrimaTiendaOrigenPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StockMateriaPrimaTiendaOrigen)) {
            return false;
        }
        StockMateriaPrimaTiendaOrigen other = (StockMateriaPrimaTiendaOrigen) object;
        if ((this.stockMateriaPrimaTiendaOrigenPK == null && other.stockMateriaPrimaTiendaOrigenPK != null) || (this.stockMateriaPrimaTiendaOrigenPK != null && !this.stockMateriaPrimaTiendaOrigenPK.equals(other.stockMateriaPrimaTiendaOrigenPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.StockMateriaPrimaTiendaOrigen[stockMateriaPrimaTiendaOrigenPK=" + stockMateriaPrimaTiendaOrigenPK + "]";
    }

}
