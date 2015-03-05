/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package bc;

import be.DetalleServicioProducto;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author argos
 */
@Stateless
public class DetalleServicioProductoFacade extends AbstractFacade<DetalleServicioProducto> implements DetalleServicioProductoFacadeLocal {
    @PersistenceContext(unitName = "sistema-ejbPU")
    private EntityManager em;

    protected EntityManager getEntityManager() {
        return em;
    }

    public DetalleServicioProductoFacade() {
        super(DetalleServicioProducto.class);
    }

}
