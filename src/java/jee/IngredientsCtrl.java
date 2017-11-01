/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.io.Serializable;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author severinlhommelet
 */

@ManagedBean
@ViewScoped
public class IngredientsCtrl implements Serializable{
    
    @EJB
    private IngredientsDAO dao;
    private Ingredients ingred;
    private Ingredients selectedIngred;

    public IngredientsCtrl() {
        this.ingred = new Ingredients();
    }

    public List<Ingredients> getIngredients(){
        return dao.allIngredients();
    }
    
}
