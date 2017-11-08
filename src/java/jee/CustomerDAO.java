/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author severinlhommelet
 */

@Stateless
public class CustomerDAO {
    
    
    @PersistenceContext(unitName = "ProjectJEEPU")
    private EntityManager em;
}
