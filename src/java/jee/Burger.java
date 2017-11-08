/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jee;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author severinlhommelet
 */
@Entity
@Table(name = "Burger")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Burger.findAll", query = "SELECT b FROM Burger b")
    , @NamedQuery(name = "Burger.findByIdBurger", query = "SELECT b FROM Burger b WHERE b.idBurger = :idBurger")
    , @NamedQuery(name = "Burger.findBySalade", query = "SELECT b FROM Burger b WHERE b.salade = :salade")
    , @NamedQuery(name = "Burger.findByBacon", query = "SELECT b FROM Burger b WHERE b.bacon = :bacon")
    , @NamedQuery(name = "Burger.findByFromage", query = "SELECT b FROM Burger b WHERE b.fromage = :fromage")
    , @NamedQuery(name = "Burger.findByCornichons", query = "SELECT b FROM Burger b WHERE b.cornichons = :cornichons")
    , @NamedQuery(name = "Burger.findByOignons", query = "SELECT b FROM Burger b WHERE b.oignons = :oignons")
    , @NamedQuery(name = "Burger.findBySteak", query = "SELECT b FROM Burger b WHERE b.steak = :steak")
    , @NamedQuery(name = "Burger.findByTomates", query = "SELECT b FROM Burger b WHERE b.tomates = :tomates")})
public class Burger implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idBurger")
    private Integer idBurger;
    @Basic(optional = false)
    @NotNull
    @Column(name = "salade")
    private int salade;
    @Basic(optional = false)
    @NotNull
    @Column(name = "bacon")
    private int bacon;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fromage")
    private int fromage;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cornichons")
    private int cornichons;
    @Basic(optional = false)
    @NotNull
    @Column(name = "oignons")
    private int oignons;
    @Basic(optional = false)
    @NotNull
    @Column(name = "steak")
    private int steak;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tomates")
    private int tomates;
    @JoinColumn(name = "idCustomer", referencedColumnName = "idCustomer")
    @ManyToOne(optional = false)
    private Customer idCustomer;

    public Burger() {
    }

    public Burger(Integer idBurger) {
        this.idBurger = idBurger;
    }

    public Burger(Integer idBurger, int salade, int bacon, int fromage, int cornichons, int oignons, int steak, int tomates) {
        this.idBurger = idBurger;
        this.salade = salade;
        this.bacon = bacon;
        this.fromage = fromage;
        this.cornichons = cornichons;
        this.oignons = oignons;
        this.steak = steak;
        this.tomates = tomates;
    }

    public Integer getIdBurger() {
        return idBurger;
    }

    public void setIdBurger(Integer idBurger) {
        this.idBurger = idBurger;
    }

    public int getSalade() {
        return salade;
    }

    public void setSalade(int salade) {
        this.salade = salade;
    }

    public int getBacon() {
        return bacon;
    }

    public void setBacon(int bacon) {
        this.bacon = bacon;
    }

    public int getFromage() {
        return fromage;
    }

    public void setFromage(int fromage) {
        this.fromage = fromage;
    }

    public int getCornichons() {
        return cornichons;
    }

    public void setCornichons(int cornichons) {
        this.cornichons = cornichons;
    }

    public int getOignons() {
        return oignons;
    }

    public void setOignons(int oignons) {
        this.oignons = oignons;
    }

    public int getSteak() {
        return steak;
    }

    public void setSteak(int steak) {
        this.steak = steak;
    }

    public int getTomates() {
        return tomates;
    }

    public void setTomates(int tomates) {
        this.tomates = tomates;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idBurger != null ? idBurger.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Burger)) {
            return false;
        }
        Burger other = (Burger) object;
        if ((this.idBurger == null && other.idBurger != null) || (this.idBurger != null && !this.idBurger.equals(other.idBurger))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.Burger[ idBurger=" + idBurger + " ]";
    }
    
}
