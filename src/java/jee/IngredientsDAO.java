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
public class IngredientsDAO {
    
    @PersistenceContext(unitName = "projetJEEPU")
    private EntityManager em;
    
    public List<Ingredients> allIngredients(){
        Query query = em.createNamedQuery("Ingredients.findAll");
        return query.getResultList();
    }
    
}
