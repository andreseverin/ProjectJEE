package jee;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author severinlhommelet
 */

@Stateless
public class PossedeDAO {
    
    @PersistenceContext(unitName = "ProjectJEEPU")
    private EntityManager em;
    
    public void add(Possede p)
    {
        em.persist(p);
        em.flush();
    }
}
