
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.GastosEconomicosFacadeLocal;
import be.GastosEconomicos;
import java.io.Serializable;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
/**
 *
 **Copyright  2011 Yury Daniel Zavaleta De la Cruz  Licensed under the Apache License,
 * Version 2.0 (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0 Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and  limitations under the License.
 */



@ManagedBean
@SessionScoped
public class ManagedBeanGastoEconomico implements Serializable{
    @EJB
    private GastosEconomicosFacadeLocal gastosEconomicosFacade;
     private List<GastosEconomicos> lista ;
     private GastosEconomicos gastoseconomicos;
private Date fecha;
    public ManagedBeanGastoEconomico() {
    lista = new LinkedList<GastosEconomicos>();
    gastoseconomicos = new GastosEconomicos();
fecha = new Date();
    }

    public GastosEconomicos getGastoseconomicos() {
        return gastoseconomicos;
    }

    public void setGastoseconomicos(GastosEconomicos gastoseconomicos) {
        this.gastoseconomicos = gastoseconomicos;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    
     public String Nuevo(){
     gastoseconomicos = new GastosEconomicos();
     return "nuevo_gasto";
     }

     public String Gastos(){
     return "gastos";
     }

public List<GastosEconomicos> getListaGastos(){
    try {
        lista = gastosEconomicosFacade.findAll();
    } catch (Exception e) {
    e.printStackTrace();
    }
return lista;
}


public void FiltrarListaGastosFecha(){
   lista.clear();
    try {
      for(GastosEconomicos p : gastosEconomicosFacade.findAll()){
      if(fecha.equals(p.getFechaCreacion())){
      lista.add(p);
      }
      }
    } catch (Exception e) {
    e.printStackTrace();
    }

}



  public String crear(){

    try {
        gastoseconomicos.setFechaCreacion(new Date());
                gastosEconomicosFacade.create(gastoseconomicos);
                
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "gastos?faces-redirect=true";

}

   public String Volver_TipoCliente(){
return "finanzas?faces-redirect=true";
     }

    public List<GastosEconomicos> getLista() {

         lista.clear();
    try {
      for(GastosEconomicos p : gastosEconomicosFacade.findAll()){
      if(fecha.equals(p.getFechaCreacion())){
      lista.add(p);
      }
      }
    } catch (Exception e) {
    e.printStackTrace();
    }
        return lista;
    }

    public void setLista(List<GastosEconomicos> lista) {
        this.lista = lista;
    }


}
