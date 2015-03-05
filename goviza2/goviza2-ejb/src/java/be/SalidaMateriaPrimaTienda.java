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
@Table(name = "salida_materia_prima_tienda")
@NamedQueries({
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findAll", query = "SELECT s FROM SalidaMateriaPrimaTienda s"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByIdSalidaMateriaPrimaTienda", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.idSalidaMateriaPrimaTienda = :idSalidaMateriaPrimaTienda"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByCantidad", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.cantidad = :cantidad"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByFechaSalida", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.fechaSalida = :fechaSalida"),
    @NamedQuery(name = "SalidaMateriaPrimaTienda.findByMotivo", query = "SELECT s FROM SalidaMateriaPrimaTienda s WHERE s.motivo = :motivo")})
public class SalidaMateriaPrimaTienda implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_SALIDA_MATERIA_PRIMA_TIENDA")
    private Integer idSalidaMateriaPrimaTienda;
    @Basic(optional = false)
    @Column(name = "CANTIDAD")
    private BigDecimal cantidad;
    @Basic(optional = false)
    @Column(name = "FECHA_SALIDA")
    @Temporal(TemporalType.DATE)
    private Date fechaSalida;
    @Basic(optional = false)
    @Column(name = "MOTIVO")
    private String motivo;
    @JoinColumn(name = "ID_TIENDA", referencedColumnName = "ID_TIENDA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tienda tienda;
    @JoinColumn(name = "ID_MATERIA_PRIMA", referencedColumnName = "ID_MATERIA_PRIMA")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MateriaPrima materiaPrima;

    public SalidaMateriaPrimaTienda() {
    }

    public SalidaMateriaPrimaTienda(Integer idSalidaMateriaPrimaTienda) {
        this.idSalidaMateriaPrimaTienda = idSalidaMateriaPrimaTienda;
    }

    public SalidaMateriaPrimaTienda(Integer idSalidaMateriaPrimaTienda, BigDecimal cantidad, Date fechaSalida, String motivo) {
        this.idSalidaMateriaPrimaTienda = idSalidaMateriaPrimaTienda;
        this.cantidad = cantidad;
        this.fechaSalida = fechaSalida;
        this.motivo = motivo;
    }

    public Integer getIdSalidaMateriaPrimaTienda() {
        return idSalidaMateriaPrimaTienda;
    }

    public void setIdSalidaMateriaPrimaTienda(Integer idSalidaMateriaPrimaTienda) {
        this.idSalidaMateriaPrimaTienda = idSalidaMateriaPrimaTienda;
    }

    public BigDecimal getCantidad() {
        return cantidad;
    }

    public void setCantidad(BigDecimal cantidad) {
        this.cantidad = cantidad;
    }

    public Date getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(Date fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getMotivo() {
        return motivo;
    }

    public void setMotivo(String motivo) {
        this.motivo = motivo;
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
        hash += (idSalidaMateriaPrimaTienda != null ? idSalidaMateriaPrimaTienda.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SalidaMateriaPrimaTienda)) {
            return false;
        }
        SalidaMateriaPrimaTienda other = (SalidaMateriaPrimaTienda) object;
        if ((this.idSalidaMateriaPrimaTienda == null && other.idSalidaMateriaPrimaTienda != null) || (this.idSalidaMateriaPrimaTienda != null && !this.idSalidaMateriaPrimaTienda.equals(other.idSalidaMateriaPrimaTienda))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.SalidaMateriaPrimaTienda[idSalidaMateriaPrimaTienda=" + idSalidaMateriaPrimaTienda + "]";
    }

}
