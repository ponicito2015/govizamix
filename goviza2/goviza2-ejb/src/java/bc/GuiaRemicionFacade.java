/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.GuiaRemicion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class GuiaRemicionFacade extends AbstractFacade<GuiaRemicion> implements GuiaRemicionFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public GuiaRemicionFacade() {
        super(GuiaRemicion.class);
    }

}
