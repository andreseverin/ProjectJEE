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
    private List<Ingredients> composition;


    public IngredientsCtrl() {
        this.ingred = new Ingredients();
    }

    public List<Ingredients> getIngredients(){
        return dao.allIngredients();
    }
    
    public void addIngredient(){
        composition.add(selectedIngred);
        this.selectedIngred = new Ingredients();
    }

    public IngredientsDAO getDao() {
        return dao;
    }

    public void setDao(IngredientsDAO dao) {
        this.dao = dao;
    }

    public Ingredients getIngred() {
        return ingred;
    }

    public void setIngred(Ingredients ingred) {
        this.ingred = ingred;
    }

    public Ingredients getSelectedIngred() {
        return selectedIngred;
    }

    public void setSelectedIngred(Ingredients selectedIngred) {
        this.selectedIngred = selectedIngred;
    }

    public List<Ingredients> getComposition() {
        return composition;
    }

    public void setComposition(List<Ingredients> composition) {
        this.composition = composition;
    }
    
    
}
