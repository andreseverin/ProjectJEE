/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.io.Console;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import static sun.misc.Version.print;

/**
 *
 * @author severinlhommelet
 */

@ManagedBean
@ViewScoped
public class IngredientsCtrl implements Serializable{
    
    @EJB
    private IngredientsDAO dao;
    private Ingredients selectedIngred;


    public IngredientsCtrl() {
        this.selectedIngred = new Ingredients();
    
    }

    public List<Ingredients> getIngredients(){
        return dao.allIngredients();
    }

    public IngredientsDAO getDao() {
        return dao;
    }

    public void setDao(IngredientsDAO dao) {
        this.dao = dao;
    }

    public Ingredients getSelectedIngred() {
        return selectedIngred;
    }

    public void setSelectedIngred(Ingredients selectedIngred) {
        this.selectedIngred = selectedIngred;
    }

    
}
