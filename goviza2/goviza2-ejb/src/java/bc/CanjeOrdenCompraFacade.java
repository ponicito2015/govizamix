/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.CanjeOrdenCompra;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class CanjeOrdenCompraFacade extends AbstractFacade<CanjeOrdenCompra> implements CanjeOrdenCompraFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public CanjeOrdenCompraFacade() {
        super(CanjeOrdenCompra.class);
    }

}
