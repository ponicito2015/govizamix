/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.Formulacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class FormulacionFacade extends AbstractFacade<Formulacion> implements FormulacionFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public FormulacionFacade() {
        super(Formulacion.class);
    }

}
