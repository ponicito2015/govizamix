
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.ClienteFacadeLocal;
import be.Cliente;
import be.Mercado;
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
 **Copyright  Anthony Ramos Mori
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
public class ManagedBeanCliente  implements Serializable{
    @EJB
    private ClienteFacadeLocal clienteFacade;


    private Cliente cliente;
    private List<Cliente> lista ;
 private List<SelectItem> clientesItems = new LinkedList<SelectItem>();
 private HashMap<Integer, Cliente> myclientes = new HashMap<Integer,Cliente>();

    public ManagedBeanCliente() {
    cliente = new Cliente();
    lista = new LinkedList<Cliente>();

    }

    public List<SelectItem> getClientesItems() {
        return clientesItems;
    }

    public void setClientesItems(List<SelectItem> clientesItems) {
        this.clientesItems = clientesItems;
    }

    public HashMap<Integer, Cliente> getMyclientes() {
        return myclientes;
    }

    public void setMyclientes(HashMap<Integer, Cliente> myclientes) {
        this.myclientes = myclientes;
    }

    public Cliente getCliente() {
        return cliente;
    }
 public Cliente getCliente(Integer id) {
    return (Cliente) myclientes.get(id);
     }
    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  
    public String Nuevo(){
    cliente = new Cliente();
    return "nuevo_cliente";
    }


    public String Crear(){

        try {
            cliente.setMercado(new Mercado(1));
clienteFacade.create(cliente);
        } catch (Exception e) {
        e.printStackTrace();
        }

    return "ventas?faces-redirect=true";
    }

     public String Crear_desde_Mantenimiento(){

        try {
            cliente.setMercado(new Mercado(1));
clienteFacade.create(cliente);
        } catch (Exception e) {
        e.printStackTrace();
        }
return "clientes?faces-redirect=true";
    }


     public String edicion(){
return "editar_cliente";
    }

     public String editar(){

        try {
          clienteFacade.edit(cliente);
        } catch (Exception e) {
        e.printStackTrace();
        }
return "clientes?faces-redirect=true";
    }


   public  List<Cliente> getLista_Clientes(){
       try {
           lista = clienteFacade.findAll();
       } catch (Exception e) {
           e.printStackTrace();
       }
       return lista;
    }


    public String Volver_Clientes(){
return "index?faces-redirect=true";
     }

    public List<Cliente> completar_filtrado_Clientes(String nombre) {
 lista = new LinkedList<Cliente>();
            for(Cliente p : clienteFacade.findAll()){
                 myclientes.put(p.getIdCliente(), p);
    if (p.getNombreCliente().toUpperCase().indexOf(nombre.toUpperCase())!=-1){
    lista.add(p);

    }
    }
       return lista;
    }


    public void llenar_myClientes(){
    try {

        for(Cliente p : clienteFacade.findAll()){
        myclientes.put(p.getIdCliente(),p);
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}
