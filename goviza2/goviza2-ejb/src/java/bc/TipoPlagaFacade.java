/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.TipoPlaga;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class TipoPlagaFacade extends AbstractFacade<TipoPlaga> implements TipoPlagaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public TipoPlagaFacade() {
        super(TipoPlaga.class);
    }

}
