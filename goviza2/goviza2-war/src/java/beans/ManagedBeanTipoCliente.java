
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.TipoClienteFacadeLocal;
import be.TipoCliente;
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
public class ManagedBeanTipoCliente implements Serializable{
    @EJB
    private TipoClienteFacadeLocal tipoClienteFacade;


    private TipoCliente tipo_cliente;
    private List<TipoCliente> lista ;
    private List<SelectItem> tipoclientesItems = new LinkedList<SelectItem>();
private HashMap<Integer, TipoCliente> mytipoclientes = new HashMap<Integer,TipoCliente>();
    public ManagedBeanTipoCliente() {
        tipo_cliente= new TipoCliente();
        lista= new LinkedList<TipoCliente>();
    }

    public TipoCliente getTipo_cliente() {
        return tipo_cliente;
    }

    public void setTipo_cliente(TipoCliente tipo_cliente) {
        this.tipo_cliente = tipo_cliente;
    }

    public HashMap<Integer, TipoCliente> getMytipoclientes() {
        return mytipoclientes;
    }

    public void setMytipoclientes(HashMap<Integer, TipoCliente> mytipoclientes) {
        this.mytipoclientes = mytipoclientes;
    }

    public List<SelectItem> getTipoclientesItems() {
        
        lista = new LinkedList<TipoCliente>();
        tipoclientesItems = new LinkedList<SelectItem>();
        lista = tipoClienteFacade.findAll();
        for(TipoCliente p: lista){
        mytipoclientes.put(p.getIdTipoCliente(), p);
            tipoclientesItems.add(new SelectItem(p, p.getNombreTipoCliente()));
        }
       return tipoclientesItems;
    }

    public void setTipoclientesItems(List<SelectItem> tipoclientesItems) {
        this.tipoclientesItems = tipoclientesItems;
    }

 public TipoCliente getTipoCliente(Integer id) {
           return (TipoCliente) mytipoclientes.get(id);

    }

 public List<TipoCliente> getListaTipoCliente(){
 List<TipoCliente> lista = new LinkedList<TipoCliente>();
     try {
       lista =  tipoClienteFacade.findAll();
     } catch (Exception e) {
     }
return lista;
 }

  public String Nuevo(){
tipo_cliente = new TipoCliente();
    return "nuevo_tipo_cliente";
    }


  public String Editar(){
    return "editar_tipo_cliente";
    }

  public String crear(){

    try {
                tipoClienteFacade.create(tipo_cliente);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "tipo_clientes?faces-redirect=true";

}

  public String editar(){

    try {
                tipoClienteFacade.edit(tipo_cliente);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "tipo_clientes?faces-redirect=true";

}


   public String Volver_TipoCliente(){
return "index?faces-redirect=true";
     }
}
