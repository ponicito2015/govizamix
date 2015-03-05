/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package be;

import java.io.Serializable;
import java.math.BigDecimal;
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

/**
 *
 * @author argos
 */
@Entity
@Table(name = "detalle_formulacion_insumos")
@NamedQueries({
    @NamedQuery(name = "DetalleFormulacionInsumos.findAll", query = "SELECT d FROM DetalleFormulacionInsumos d"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByIdFormulacion", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.detalleFormulacionInsumosPK.idFormulacion = :idFormulacion"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByIdMateriaPrima", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.detalleFormulacionInsumosPK.idMateriaPrima = :idMateriaPrima"),
    @NamedQuery(name = "DetalleFormulacionInsumos.findByProporcion", query = "SELECT d FROM DetalleFormulacionInsumos d WHERE d.proporcion = :proporcion")})
public class DetalleFormulacionInsumos implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DetalleFormulacionInsumosPK detalleFormulacionInsumosPK;
    @Basic(optional = false)
    @Column(name = "PROPORCION")
    private BigDecimal proporcion;
    @JoinColumn(name = "ID_MATERIA_PRIMA", referencedColumnName = "ID_MATERIA_PRIMA", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private MateriaPrima materiaPrima;
    @JoinColumn(name = "ID_FORMULACION", referencedColumnName = "ID_FORMULACION", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Formulacion formulacion;

    public DetalleFormulacionInsumos() {
    }

    public DetalleFormulacionInsumos(DetalleFormulacionInsumosPK detalleFormulacionInsumosPK) {
        this.detalleFormulacionInsumosPK = detalleFormulacionInsumosPK;
    }

    public DetalleFormulacionInsumos(DetalleFormulacionInsumosPK detalleFormulacionInsumosPK, BigDecimal proporcion) {
        this.detalleFormulacionInsumosPK = detalleFormulacionInsumosPK;
        this.proporcion = proporcion;
    }

    public DetalleFormulacionInsumos(int idFormulacion, int idMateriaPrima) {
        this.detalleFormulacionInsumosPK = new DetalleFormulacionInsumosPK(idFormulacion, idMateriaPrima);
    }

    public DetalleFormulacionInsumosPK getDetalleFormulacionInsumosPK() {
        return detalleFormulacionInsumosPK;
    }

    public void setDetalleFormulacionInsumosPK(DetalleFormulacionInsumosPK detalleFormulacionInsumosPK) {
        this.detalleFormulacionInsumosPK = detalleFormulacionInsumosPK;
    }

    public BigDecimal getProporcion() {
        return proporcion;
    }

    public void setProporcion(BigDecimal proporcion) {
        this.proporcion = proporcion;
    }

    public MateriaPrima getMateriaPrima() {
        return materiaPrima;
    }

    public void setMateriaPrima(MateriaPrima materiaPrima) {
        this.materiaPrima = materiaPrima;
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
        hash += (detalleFormulacionInsumosPK != null ? detalleFormulacionInsumosPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DetalleFormulacionInsumos)) {
            return false;
        }
        DetalleFormulacionInsumos other = (DetalleFormulacionInsumos) object;
        if ((this.detalleFormulacionInsumosPK == null && other.detalleFormulacionInsumosPK != null) || (this.detalleFormulacionInsumosPK != null && !this.detalleFormulacionInsumosPK.equals(other.detalleFormulacionInsumosPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.DetalleFormulacionInsumos[detalleFormulacionInsumosPK=" + detalleFormulacionInsumosPK + "]";
    }

}
