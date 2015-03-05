/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.IngresoMateriaPrimaTienda;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class IngresoMateriaPrimaTiendaFacade extends AbstractFacade<IngresoMateriaPrimaTienda> implements IngresoMateriaPrimaTiendaFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public IngresoMateriaPrimaTiendaFacade() {
        super(IngresoMateriaPrimaTienda.class);
    }

}
