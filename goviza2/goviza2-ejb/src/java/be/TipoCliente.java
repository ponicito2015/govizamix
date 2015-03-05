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
@Table(name = "tipo_cliente")
@NamedQueries({
    @NamedQuery(name = "TipoCliente.findAll", query = "SELECT t FROM TipoCliente t"),
    @NamedQuery(name = "TipoCliente.findByIdTipoCliente", query = "SELECT t FROM TipoCliente t WHERE t.idTipoCliente = :idTipoCliente"),
    @NamedQuery(name = "TipoCliente.findByNombreTipoCliente", query = "SELECT t FROM TipoCliente t WHERE t.nombreTipoCliente = :nombreTipoCliente"),
    @NamedQuery(name = "TipoCliente.findByDescripcion", query = "SELECT t FROM TipoCliente t WHERE t.descripcion = :descripcion")})
public class TipoCliente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_TIPO_CLIENTE")
    private Integer idTipoCliente;
    @Basic(optional = false)
    @Column(name = "NOMBRE_TIPO_CLIENTE")
    private String nombreTipoCliente;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tipoCliente", fetch = FetchType.EAGER)
    private List<Cliente> clienteList;

    public TipoCliente() {
    }

    public TipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public TipoCliente(Integer idTipoCliente, String nombreTipoCliente, String descripcion) {
        this.idTipoCliente = idTipoCliente;
        this.nombreTipoCliente = nombreTipoCliente;
        this.descripcion = descripcion;
    }

    public Integer getIdTipoCliente() {
        return idTipoCliente;
    }

    public void setIdTipoCliente(Integer idTipoCliente) {
        this.idTipoCliente = idTipoCliente;
    }

    public String getNombreTipoCliente() {
        return nombreTipoCliente;
    }

    public void setNombreTipoCliente(String nombreTipoCliente) {
        this.nombreTipoCliente = nombreTipoCliente;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Cliente> getClienteList() {
        return clienteList;
    }

    public void setClienteList(List<Cliente> clienteList) {
        this.clienteList = clienteList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idTipoCliente != null ? idTipoCliente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TipoCliente)) {
            return false;
        }
        TipoCliente other = (TipoCliente) object;
        if ((this.idTipoCliente == null && other.idTipoCliente != null) || (this.idTipoCliente != null && !this.idTipoCliente.equals(other.idTipoCliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.TipoCliente[idTipoCliente=" + idTipoCliente + "]";
    }

}
