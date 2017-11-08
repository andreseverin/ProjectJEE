/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.awt.event.ActionEvent;
import java.io.Serializable;
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
    private Customer selectedUser;

    public Customer getSelectedUser() {
        return selectedUser;
    }

    public void setSelectedUser(Customer selectedUser) {
        this.selectedUser = selectedUser;
    }


    @PostConstruct
    public void init(){
        selectedUser = new Customer();
    }
    
   
    public CustomerDAO getDao() {
        return dao;
    }

    public void setDao(CustomerDAO dao) {
        this.dao = dao;
    }

    
    public void login(ActionEvent event) {
        RequestContext context = RequestContext.getCurrentInstance();
        FacesMessage message = null;
        boolean loggedIn = false;
        
        if(selectedUser.getName() != null && selectedUser.getName().equals("admin") && selectedUser.getPassword()!= null && selectedUser.getPassword().equals("admin")) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Welcome", selectedUser.getName());
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        context.addCallbackParam("loggedIn", loggedIn);
    } 
    
    
}
