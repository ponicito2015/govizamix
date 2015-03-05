
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package beans;
import bc.MotivoTransladoFacturaFacadeLocal;
import be.MotivoTransladoFactura;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.SelectItem;
/**
 *
 * @author root : Zavaleta De la Cruz Yury Daniel
 * Copyright 2011 Zavaleta De la Cruz Yury Daniel

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.

 */



@ManagedBean
@SessionScoped
public class ManagedBeanMotivoTransladoFactura implements Serializable {
    @EJB
    private MotivoTransladoFacturaFacadeLocal motivoTransladoFacturaFacade;

    private List<MotivoTransladoFactura> lista;
private MotivoTransladoFactura motivo;

  private List<SelectItem> motivosItems = new LinkedList<SelectItem>();
private HashMap<Integer, MotivoTransladoFactura> mymotivos = new HashMap<Integer,MotivoTransladoFactura>();



    public ManagedBeanMotivoTransladoFactura() {
        lista = new LinkedList<MotivoTransladoFactura>();
        motivo = new MotivoTransladoFactura();
    }

    public List<MotivoTransladoFactura> getLista() {
        try {
            lista = motivoTransladoFacturaFacade.findAll();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lista;
    }

    public void setLista(List<MotivoTransladoFactura> lista) {
        this.lista = lista;
    }

    public MotivoTransladoFactura getMotivo() {
        return motivo;
    }

    public void setMotivo(MotivoTransladoFactura motivo) {
        this.motivo = motivo;
    }

    public List<SelectItem> getMotivosItems() {

         lista = new ArrayList<MotivoTransladoFactura>();
        motivosItems = new LinkedList<SelectItem>();
        lista = motivoTransladoFacturaFacade.findAll();
        for(MotivoTransladoFactura p: lista){
        mymotivos.put(p.getIdMotivoTransladoFactura(), p);
        motivosItems.add(new SelectItem(p, p.getMotivo()));
        }
        return motivosItems;
    }

    public void setMotivosItems(List<SelectItem> motivosItems) {
        this.motivosItems = motivosItems;
    }

    public HashMap<Integer, MotivoTransladoFactura> getMymotivos() {
        return mymotivos;
    }

    public void setMymotivos(HashMap<Integer, MotivoTransladoFactura> mymotivos) {
        this.mymotivos = mymotivos;
    }
 public MotivoTransladoFactura getMotivoTransladoFactura(Integer id) {
           return (MotivoTransladoFactura) mymotivos.get(id);

    }

 public String Nuevo(){
motivo = new MotivoTransladoFactura();
 return "nuevo_motivo_translado_factura";
 }

 public String crear(){
     try {
        motivoTransladoFacturaFacade.create(motivo);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "motivos_translado_factura?faces-redirect=true";
 }

 public String editar(){
     try {
        motivoTransladoFacturaFacade.edit(motivo);
     } catch (Exception e) {
    e.printStackTrace();
     }
return "motivos_translado_factura?faces-redirect=true";
 }


  public String Volver_motivo(){
return "index?faces-redirect=true";
     }
public String Edicion(){
return "editar_motivo";
     }


}
