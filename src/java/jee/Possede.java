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
@Table(name = "Possede")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Possede.findAll", query = "SELECT p FROM Possede p")
    , @NamedQuery(name = "Possede.findByIdPossede", query = "SELECT p FROM Possede p WHERE p.idPossede = :idPossede")
    , @NamedQuery(name = "Possede.findByOrdre", query = "SELECT p FROM Possede p WHERE p.ordre = :ordre")})
public class Possede implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPossede")
    private Integer idPossede;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ordre")
    private int ordre;
    @JoinColumn(name = "idCustomer", referencedColumnName = "idCustomer")
    @ManyToOne(optional = false)
    private Customer idCustomer;
    @JoinColumn(name = "idIngredient", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Ingredients idIngredient;

    public Possede() {
    }

    public Possede(Integer idPossede) {
        this.idPossede = idPossede;
    }

    public Possede(Integer idPossede, int ordre) {
        this.idPossede = idPossede;
        this.ordre = ordre;
    }

    public Integer getIdPossede() {
        return idPossede;
    }

    public void setIdPossede(Integer idPossede) {
        this.idPossede = idPossede;
    }

    public int getOrdre() {
        return ordre;
    }

    public void setOrdre(int ordre) {
        this.ordre = ordre;
    }

    public Customer getIdCustomer() {
        return idCustomer;
    }

    public void setIdCustomer(Customer idCustomer) {
        this.idCustomer = idCustomer;
    }

    public Ingredients getIdIngredient() {
        return idIngredient;
    }

    public void setIdIngredient(Ingredients idIngredient) {
        this.idIngredient = idIngredient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPossede != null ? idPossede.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Possede)) {
            return false;
        }
        Possede other = (Possede) object;
        if ((this.idPossede == null && other.idPossede != null) || (this.idPossede != null && !this.idPossede.equals(other.idPossede))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.Possede[ idPossede=" + idPossede + " ]";
    }
    
}
