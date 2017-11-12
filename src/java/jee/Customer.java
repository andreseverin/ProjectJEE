/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author severinlhommelet
 */
@Entity
@Table(name = "Customer")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Customer.findAll", query = "SELECT c FROM Customer c")
    , @NamedQuery(name = "Customer.findByIdCustomer", query = "SELECT c FROM Customer c WHERE c.idCustomer = :idCustomer")
    , @NamedQuery(name = "Customer.findByName", query = "SELECT c FROM Customer c WHERE c.name = :name")
    , @NamedQuery(name = "Customer.findByPassword", query = "SELECT c FROM Customer c WHERE c.password = :password")})
public class Customer implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idCustomer")
    private Collection<Possede> possedeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idCustomer")
    private Integer idCustomer;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "password")
    private String password;

    public Customer() {
    }

    public Customer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Customer(Integer idCustomer, String name, String password) {
        this.idCustomer = idCustomer;
        this.name = name;
        this.password = password;
    }

    public Integer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Integer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCustomer != null ? idCustomer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Customer)) {
            return false;
        }
        Customer other = (Customer) object;
        if ((this.idCustomer == null && other.idCustomer != null) || (this.idCustomer != null && !this.idCustomer.equals(other.idCustomer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.Customer[ idCustomer=" + idCustomer + " ]";
    }

    @XmlTransient
    public Collection<Possede> getPossedeCollection() {
        return possedeCollection;
    }

    public void setPossedeCollection(Collection<Possede> possedeCollection) {
        this.possedeCollection = possedeCollection;
    }
    
}
