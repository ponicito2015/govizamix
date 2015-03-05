/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.ColorProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class ColorProductoFacade extends AbstractFacade<ColorProducto> implements ColorProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ColorProductoFacade() {
        super(ColorProducto.class);
    }

}
