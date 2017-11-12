/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author severinlhommelet
 */
@ManagedBean
@ViewScoped
public class PossedeCtrl implements Serializable {
    
    @EJB
    private PossedeDAO dao;
    private Possede possede;
    private List<Ingredients> composition;
    private CustomerCtrl userCtrl;
    private Customer user;
    private CustomerDAO userDAO;
    
    @PostConstruct
    public void init()
    {
        composition = new ArrayList<Ingredients>();
        userCtrl =  new CustomerCtrl();
        user = new Customer();
        possede = new Possede();
    }    

    public PossedeDAO getDao() {
        return dao;
    }

    public void setDao(PossedeDAO dao) {
        this.dao = dao;
    }
    

    public CustomerCtrl getUserCtrl() {
        return userCtrl;
    }

    public void setUserCtrl(CustomerCtrl userCtrl) {
        this.userCtrl = userCtrl;
    }

    public Possede getPossede() {
        return possede;
    }

    public void setPossede(Possede possede) {
        this.possede = possede;
    }

    public List<Ingredients> getComposition() {
        return composition;
    }

    public void setComposition(List<Ingredients> composition) {
        this.composition = composition;
    }

    public Customer getUser() {
        return user;
    }

    public void setUser(Customer user) {
        this.user = user;
    }
    

    public void createCustomerBurger()
    {
        for(Ingredients i : composition)
        {          
            possede.setIdIngredient(i);
            possede.setIdCustomer(user);
            possede.setOrdre(composition.indexOf(i)+1);
        }
        dao.add(possede);
    }
    
    public void addIngred(Ingredients i){
        composition.add(0,i);
    }
    
    public void removeIngred(Ingredients i){
        composition.remove(i);
    }
    
    public void clearCompo(){
        composition.clear();
    }   

}
