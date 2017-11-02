/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author severinlhommelet
 */

@ManagedBean
@ViewScoped
public class Burger {
    private List<Ingredients> composition;
    
    public void addIngredient(Ingredients ing){
        composition.add(ing);
    }
    
}
