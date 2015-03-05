/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.ModeloProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class ModeloProductoFacade extends AbstractFacade<ModeloProducto> implements ModeloProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ModeloProductoFacade() {
        super(ModeloProducto.class);
    }

}
