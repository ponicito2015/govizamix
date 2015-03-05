/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;

import bc.ZonaCiudadFacadeLocal;
import be.ZonaCiudad;
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
 * @author root
 */
@ManagedBean
@SessionScoped
public class ManagedBeanZona implements Serializable{
  
    @EJB
    private ZonaCiudadFacadeLocal zonaFacade;
  private ZonaCiudad zona;
   private List<ZonaCiudad> lista ;
    private List<SelectItem> zonasItems = new LinkedList<SelectItem>();
private HashMap<Integer, ZonaCiudad> myzonas = new HashMap<Integer,ZonaCiudad>();
    public ManagedBeanZona() {
    zona = new ZonaCiudad();
    }

    public HashMap<Integer, ZonaCiudad> getMyzonas() {
        return myzonas;
    }

    public void setMyzonas(HashMap<Integer, ZonaCiudad> myzonas) {
        this.myzonas = myzonas;
    }

    public ZonaCiudad getZona() {
        return zona;
    }

    public void setZona(ZonaCiudad zona) {
        this.zona = zona;
    }

    public List<SelectItem> getZonasItems() {




          lista = new LinkedList<ZonaCiudad>();
        zonasItems = new LinkedList<SelectItem>();
        lista = zonaFacade.findAll();
        for(ZonaCiudad p: lista){
        myzonas.put(p.getIdZonaCiudad(), p);
            zonasItems.add(new SelectItem(p, p.getDescripcionZonaCiudad()));
        }


        return zonasItems;
    }


     public ZonaCiudad getZona(Integer id) {
           return (ZonaCiudad) myzonas.get(id);

    }

    public void setZonasItems(List<SelectItem> zonasItems) {
        this.zonasItems = zonasItems;
    }


     public String Nuevo(){
     zona = new ZonaCiudad();
    return "nueva_zona";
    }


  public String Editar(){
    return "editar_zona";
    }

  public String crear(){

    try {
        zona.setFlagEstado("SI");

    zonaFacade.create(zona);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "zona_clientes?faces-redirect=true";

}

  public String editar(){

    try {
            zonaFacade.edit(zona);
    } catch (Exception e) {
        e.printStackTrace();
    }
    return "zona_clientes?faces-redirect=true";

}


   public String Volver_ZonaCliente(){
return "index?faces-redirect=true";
     }

    public List<ZonaCiudad> getLista() {
        lista = new LinkedList<ZonaCiudad>();
        try {
       lista =  zonaFacade.findAll();
     } catch (Exception e) {
     }
        return lista;
    }

    public void setLista(List<ZonaCiudad> lista) {
        this.lista = lista;
    }




}
