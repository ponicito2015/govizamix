/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.ReporteFumigacion;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class ReporteFumigacionFacade extends AbstractFacade<ReporteFumigacion> implements ReporteFumigacionFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public ReporteFumigacionFacade() {
        super(ReporteFumigacion.class);
    }

}
