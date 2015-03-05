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
@Table(name = "reporte_desratizacion")
@NamedQueries({
    @NamedQuery(name = "ReporteDesratizacion.findAll", query = "SELECT r FROM ReporteDesratizacion r"),
    @NamedQuery(name = "ReporteDesratizacion.findByIdReporteDesratizacion", query = "SELECT r FROM ReporteDesratizacion r WHERE r.idReporteDesratizacion = :idReporteDesratizacion"),
    @NamedQuery(name = "ReporteDesratizacion.findByFecha", query = "SELECT r FROM ReporteDesratizacion r WHERE r.fecha = :fecha"),
    @NamedQuery(name = "ReporteDesratizacion.findByDescripcionCliente", query = "SELECT r FROM ReporteDesratizacion r WHERE r.descripcionCliente = :descripcionCliente"),
    @NamedQuery(name = "ReporteDesratizacion.findByHoraInicio", query = "SELECT r FROM ReporteDesratizacion r WHERE r.horaInicio = :horaInicio"),
    @NamedQuery(name = "ReporteDesratizacion.findByDuracionMinutos", query = "SELECT r FROM ReporteDesratizacion r WHERE r.duracionMinutos = :duracionMinutos"),
    @NamedQuery(name = "ReporteDesratizacion.findByNumeroEstacionesInstaladas", query = "SELECT r FROM ReporteDesratizacion r WHERE r.numeroEstacionesInstaladas = :numeroEstacionesInstaladas"),
    @NamedQuery(name = "ReporteDesratizacion.findByCantidadProductoUtilizado", query = "SELECT r FROM ReporteDesratizacion r WHERE r.cantidadProductoUtilizado = :cantidadProductoUtilizado"),
    @NamedQuery(name = "ReporteDesratizacion.findByPorcentajeAvance", query = "SELECT r FROM ReporteDesratizacion r WHERE r.porcentajeAvance = :porcentajeAvance"),
    @NamedQuery(name = "ReporteDesratizacion.findByComentariosCliente", query = "SELECT r FROM ReporteDesratizacion r WHERE r.comentariosCliente = :comentariosCliente"),
    @NamedQuery(name = "ReporteDesratizacion.findByObservacionesCliente", query = "SELECT r FROM ReporteDesratizacion r WHERE r.observacionesCliente = :observacionesCliente"),
    @NamedQuery(name = "ReporteDesratizacion.findByRequerimientosDiaSiguiente", query = "SELECT r FROM ReporteDesratizacion r WHERE r.requerimientosDiaSiguiente = :requerimientosDiaSiguiente")})
public class ReporteDesratizacion implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_REPORTE_DESRATIZACION")
    private Integer idReporteDesratizacion;
    @Basic(optional = false)
    @Column(name = "FECHA")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION_CLIENTE")
    private String descripcionCliente;
    @Basic(optional = false)
    @Column(name = "HORA_INICIO")
    private String horaInicio;
    @Basic(optional = false)
    @Column(name = "DURACION_MINUTOS")
    private int duracionMinutos;
    @Basic(optional = false)
    @Column(name = "NUMERO_ESTACIONES_INSTALADAS")
    private int numeroEstacionesInstaladas;
    @Basic(optional = false)
    @Column(name = "CANTIDAD_PRODUCTO_UTILIZADO")
    private String cantidadProductoUtilizado;
    @Basic(optional = false)
    @Column(name = "PORCENTAJE_AVANCE")
    private int porcentajeAvance;
    @Basic(optional = false)
    @Column(name = "COMENTARIOS_CLIENTE")
    private String comentariosCliente;
    @Basic(optional = false)
    @Column(name = "OBSERVACIONES_CLIENTE")
    private String observacionesCliente;
    @Basic(optional = false)
    @Column(name = "REQUERIMIENTOS_DIA_SIGUIENTE")
    private String requerimientosDiaSiguiente;
    @JoinColumn(name = "ID_EMPLEADO", referencedColumnName = "ID_EMPLEADO")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Empleado empleado;
    @JoinColumn(name = "ID_CONTRATO_FUMIGACION", referencedColumnName = "ID_CONTRATO_FUMIGACION")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private ContratoFumigacion contratoFumigacion;

    public ReporteDesratizacion() {
    }

    public ReporteDesratizacion(Integer idReporteDesratizacion) {
        this.idReporteDesratizacion = idReporteDesratizacion;
    }

    public ReporteDesratizacion(Integer idReporteDesratizacion, Date fecha, String descripcionCliente, String horaInicio, int duracionMinutos, int numeroEstacionesInstaladas, String cantidadProductoUtilizado, int porcentajeAvance, String comentariosCliente, String observacionesCliente, String requerimientosDiaSiguiente) {
        this.idReporteDesratizacion = idReporteDesratizacion;
        this.fecha = fecha;
        this.descripcionCliente = descripcionCliente;
        this.horaInicio = horaInicio;
        this.duracionMinutos = duracionMinutos;
        this.numeroEstacionesInstaladas = numeroEstacionesInstaladas;
        this.cantidadProductoUtilizado = cantidadProductoUtilizado;
        this.porcentajeAvance = porcentajeAvance;
        this.comentariosCliente = comentariosCliente;
        this.observacionesCliente = observacionesCliente;
        this.requerimientosDiaSiguiente = requerimientosDiaSiguiente;
    }

    public Integer getIdReporteDesratizacion() {
        return idReporteDesratizacion;
    }

    public void setIdReporteDesratizacion(Integer idReporteDesratizacion) {
        this.idReporteDesratizacion = idReporteDesratizacion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getDescripcionCliente() {
        return descripcionCliente;
    }

    public void setDescripcionCliente(String descripcionCliente) {
        this.descripcionCliente = descripcionCliente;
    }

    public String getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(String horaInicio) {
        this.horaInicio = horaInicio;
    }

    public int getDuracionMinutos() {
        return duracionMinutos;
    }

    public void setDuracionMinutos(int duracionMinutos) {
        this.duracionMinutos = duracionMinutos;
    }

    public int getNumeroEstacionesInstaladas() {
        return numeroEstacionesInstaladas;
    }

    public void setNumeroEstacionesInstaladas(int numeroEstacionesInstaladas) {
        this.numeroEstacionesInstaladas = numeroEstacionesInstaladas;
    }

    public String getCantidadProductoUtilizado() {
        return cantidadProductoUtilizado;
    }

    public void setCantidadProductoUtilizado(String cantidadProductoUtilizado) {
        this.cantidadProductoUtilizado = cantidadProductoUtilizado;
    }

    public int getPorcentajeAvance() {
        return porcentajeAvance;
    }

    public void setPorcentajeAvance(int porcentajeAvance) {
        this.porcentajeAvance = porcentajeAvance;
    }

    public String getComentariosCliente() {
        return comentariosCliente;
    }

    public void setComentariosCliente(String comentariosCliente) {
        this.comentariosCliente = comentariosCliente;
    }

    public String getObservacionesCliente() {
        return observacionesCliente;
    }

    public void setObservacionesCliente(String observacionesCliente) {
        this.observacionesCliente = observacionesCliente;
    }

    public String getRequerimientosDiaSiguiente() {
        return requerimientosDiaSiguiente;
    }

    public void setRequerimientosDiaSiguiente(String requerimientosDiaSiguiente) {
        this.requerimientosDiaSiguiente = requerimientosDiaSiguiente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public ContratoFumigacion getContratoFumigacion() {
        return contratoFumigacion;
    }

    public void setContratoFumigacion(ContratoFumigacion contratoFumigacion) {
        this.contratoFumigacion = contratoFumigacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idReporteDesratizacion != null ? idReporteDesratizacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ReporteDesratizacion)) {
            return false;
        }
        ReporteDesratizacion other = (ReporteDesratizacion) object;
        if ((this.idReporteDesratizacion == null && other.idReporteDesratizacion != null) || (this.idReporteDesratizacion != null && !this.idReporteDesratizacion.equals(other.idReporteDesratizacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.ReporteDesratizacion[idReporteDesratizacion=" + idReporteDesratizacion + "]";
    }

}
