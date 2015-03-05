/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.TipoCuentaContable;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class TipoCuentaContableFacade extends AbstractFacade<TipoCuentaContable> implements TipoCuentaContableFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoCuentaContableFacade() {
        super(TipoCuentaContable.class);
    }

}
