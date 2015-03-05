
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.PrecioProductoFacadeLocal;
import be.PrecioProducto;
import be.Producto;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS
 * ,  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */
@ManagedBean
@SessionScoped






public class ManagedBeanPrecioProducto implements Serializable{
    @EJB
    private  PrecioProductoFacadeLocal precioProductoFacade ;
    private PrecioProducto precioproducto;
    private List<PrecioProducto> lista ;
    private List<PrecioProducto> lista2 ;


    private Producto producto_seleccionado;
    private BigDecimal precio ;
    public ManagedBeanPrecioProducto() {
        precio= new BigDecimal(0);
        precioproducto = new PrecioProducto();
        producto_seleccionado = new Producto();
        lista = new LinkedList<PrecioProducto>();
        lista2 = new LinkedList<PrecioProducto>();

    }

    public Producto getProducto_seleccionado() {
        return producto_seleccionado;
    }

    public void setProducto_seleccionado(Producto producto_seleccionado) {
        this.producto_seleccionado = producto_seleccionado;
    }

    public BigDecimal getPrecio() {
        return precio;
    }

    public void setPrecio(BigDecimal precio) {
        this.precio = precio;
    }

   



    public PrecioProducto getPrecioproducto() {
        return precioproducto;
    }

    public void setPrecioproducto(PrecioProducto precioproducto) {
        this.precioproducto = precioproducto;
    }

public List<PrecioProducto> getListaPrecioProductos(){
    lista = new LinkedList<PrecioProducto>();
    try {
        lista = precioProductoFacade.findAll();
    } catch (Exception e) {
   e.printStackTrace();
    }
    return lista;
}


public String Nuevo(){
    precio = new BigDecimal(0);
    precioproducto = new PrecioProducto();
//precioproducto = new PrecioProducto();
return "nuevo_precio_producto?faces-redirect=true";
    }

public String Editar(){
    return "editar_precio_producto";
 }

  public String creando(){

    try {
        
      PrecioProducto nuevo = new PrecioProducto(producto_seleccionado.getIdProducto(), new Date(), precio);
        precioProductoFacade.create(nuevo);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "precio_productos?faces-redirect=true";

}



  public String actualizar(){

    try {
        precioproducto.setFechaActualizacion(new Date());
       precioProductoFacade.edit(precioproducto);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "precio_productos?faces-redirect=true";

}

   public String Volver_PrecioProductos(){
return "index?faces-redirect=true";
     }



   

    


}
