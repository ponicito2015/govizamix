/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.MotivoTransladoFactura;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class MotivoTransladoFacturaFacade extends AbstractFacade<MotivoTransladoFactura> implements MotivoTransladoFacturaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public MotivoTransladoFacturaFacade() {
        super(MotivoTransladoFactura.class);
    }

}
