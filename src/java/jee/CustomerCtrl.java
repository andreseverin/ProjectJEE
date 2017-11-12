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
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import static jee.Customer_.password;
import org.primefaces.context.RequestContext;

/**
 *
 * @author severinlhommelet
 */

@ManagedBean
@ViewScoped
public class CustomerCtrl implements Serializable {
    
    @EJB
    private CustomerDAO dao;
    //private Customer user;
    private PossedeCtrl possede;
    private boolean loggedIn = false;
    
    @PostConstruct
    public void init(){
        //user = new Customer();
        possede = new PossedeCtrl();
    }

    public PossedeCtrl getPossede() {
        return possede;
    }

    public void setPossede(PossedeCtrl possede) {
        this.possede = possede;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }
//
//    public Customer getUser() {
//        return user;
//    }
//
//    public void setUser(Customer currentUser) {
//        this.user = currentUser;
//    }

    
   
    public CustomerDAO getDao() {
        return dao;
    }

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }
    
    public void login(ActionEvent event,Customer user) throws IOException {
        List<Customer> customers = dao.allCustomer();
     
        for(Customer cu : customers){
            if(cu.getName().equals(user.getName()) && cu.getPassword().equals(user.getPassword())){
                loggedIn = true;
                FacesContext.getCurrentInstance().getExternalContext().redirect("mainWindow.xhtml");
                user = new Customer(cu.getIdCustomer());
            }
        }

    }
    
    public void register(ActionEvent event,Customer user) throws IOException {
        
        if(user.getName() != null && user.getPassword()!= null) {
            loggedIn = true;
            possede.setUser(user);
            dao.add(user);
            FacesContext.getCurrentInstance().getExternalContext().redirect("mainWindow.xhtml");
        }
    } 
    
    public void disconnect(){
        loggedIn = false;
    }
}
