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
@Table(name = "material_producto")
@NamedQueries({
    @NamedQuery(name = "MaterialProducto.findAll", query = "SELECT m FROM MaterialProducto m"),
    @NamedQuery(name = "MaterialProducto.findByIdMaterialProducto", query = "SELECT m FROM MaterialProducto m WHERE m.idMaterialProducto = :idMaterialProducto"),
    @NamedQuery(name = "MaterialProducto.findByNombreMaterialProducto", query = "SELECT m FROM MaterialProducto m WHERE m.nombreMaterialProducto = :nombreMaterialProducto"),
    @NamedQuery(name = "MaterialProducto.findByDescripcion", query = "SELECT m FROM MaterialProducto m WHERE m.descripcion = :descripcion")})
public class MaterialProducto implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID_MATERIAL_PRODUCTO")
    private Integer idMaterialProducto;
    @Basic(optional = false)
    @Column(name = "NOMBRE_MATERIAL_PRODUCTO")
    private String nombreMaterialProducto;
    @Basic(optional = false)
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "materialProducto", fetch = FetchType.EAGER)
    private List<Producto> productoList;

    public MaterialProducto() {
    }

    public MaterialProducto(Integer idMaterialProducto) {
        this.idMaterialProducto = idMaterialProducto;
    }

    public MaterialProducto(Integer idMaterialProducto, String nombreMaterialProducto, String descripcion) {
        this.idMaterialProducto = idMaterialProducto;
        this.nombreMaterialProducto = nombreMaterialProducto;
        this.descripcion = descripcion;
    }

    public Integer getIdMaterialProducto() {
        return idMaterialProducto;
    }

    public void setIdMaterialProducto(Integer idMaterialProducto) {
        this.idMaterialProducto = idMaterialProducto;
    }

    public String getNombreMaterialProducto() {
        return nombreMaterialProducto;
    }

    public void setNombreMaterialProducto(String nombreMaterialProducto) {
        this.nombreMaterialProducto = nombreMaterialProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public List<Producto> getProductoList() {
        return productoList;
    }

    public void setProductoList(List<Producto> productoList) {
        this.productoList = productoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idMaterialProducto != null ? idMaterialProducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MaterialProducto)) {
            return false;
        }
        MaterialProducto other = (MaterialProducto) object;
        if ((this.idMaterialProducto == null && other.idMaterialProducto != null) || (this.idMaterialProducto != null && !this.idMaterialProducto.equals(other.idMaterialProducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "be.MaterialProducto[idMaterialProducto=" + idMaterialProducto + "]";
    }

}
