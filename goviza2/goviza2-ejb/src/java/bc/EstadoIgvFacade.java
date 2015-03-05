/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.EstadoIgv;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class EstadoIgvFacade extends AbstractFacade<EstadoIgv> implements EstadoIgvFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public EstadoIgvFacade() {
        super(EstadoIgv.class);
    }

}
