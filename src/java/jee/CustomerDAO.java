/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author severinlhommelet
 */

@Stateless
public class CustomerDAO {
    
    
    @PersistenceContext(unitName = "ProjectJEEPU")
    private EntityManager em;
    
    public List<Customer> allCustomer(){
        Query query = em.createNamedQuery("Customer.findAll");
        return query.getResultList();
    }
    
    public void add(Customer e)
    {
        em.persist(e);
        em.flush();
    }
}
