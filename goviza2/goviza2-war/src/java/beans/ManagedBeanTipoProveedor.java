
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.TipoProveedorFacadeLocal;
import be.TipoProveedor;
import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;

/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */




@ManagedBean
@SessionScoped
public class ManagedBeanTipoProveedor implements Serializable {
  @EJB
    private TipoProveedorFacadeLocal tipoProveedorFacade;

       private List<SelectItem> tipoproveedoresItems = new LinkedList<SelectItem>();
private HashMap<Integer, TipoProveedor> myptipoproveedores = new HashMap<Integer,TipoProveedor>();

private TipoProveedor tipoproveedor;
 private List<TipoProveedor> lista;
public ManagedBeanTipoProveedor() {
tipoproveedor = new TipoProveedor();
lista = new LinkedList<TipoProveedor>();
        }

    public HashMap<Integer, TipoProveedor> getMyptipoproveedores() {
        return myptipoproveedores;
    }

    public TipoProveedor getTipoproveedor() {
        return tipoproveedor;
    }

    public void setTipoproveedor(TipoProveedor tipoproveedor) {
        this.tipoproveedor = tipoproveedor;
    }

    public void setMyptipoproveedores(HashMap<Integer, TipoProveedor> myptipoproveedores) {
        this.myptipoproveedores = myptipoproveedores;
    }


    public void setTipoproveedoresItems(List<SelectItem> tipoproveedoresItems) {
        this.tipoproveedoresItems = tipoproveedoresItems;
    }

public TipoProveedor getTipoProveedor(Integer id) {
           return (TipoProveedor) myptipoproveedores.get(id);

    }

public List<SelectItem> getTipoproveedoresItems() {

        lista = new LinkedList<TipoProveedor>();
        tipoproveedoresItems = new LinkedList<SelectItem>();
        lista = tipoProveedorFacade.findAll();
        for(TipoProveedor p: lista){
        myptipoproveedores.put(p.getIdTipoProveedor(), p);
            tipoproveedoresItems.add(new SelectItem(p, p.getNombre()));
        }
       return tipoproveedoresItems;
    }




 public List<TipoProveedor> getListaTipoProveedor(){
 List<TipoProveedor> lista = new LinkedList<TipoProveedor>();
     try {
       lista =  tipoProveedorFacade.findAll();
     } catch (Exception e) {
     }
return lista;
 }

  public String Nuevo(){
tipoproveedor = new TipoProveedor();
    return "nuevo_tipo_proveedor";
    }

  public String crear(){

    try {
                tipoProveedorFacade.create(tipoproveedor);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "tipo_proveedor?faces-redirect=true";

}


   public String edicion(){
return "editar_tipo_proveedor";
}
   public String editar(){

    try {
                tipoProveedorFacade.edit(tipoproveedor);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "tipo_proveedor?faces-redirect=true";

}
   public String Volver_TipoProveedor(){
return "index?faces-redirect=true";
     }


}
