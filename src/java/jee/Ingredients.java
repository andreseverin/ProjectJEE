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
@Table(name = "Ingredients")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ingredients.findAll", query = "SELECT i FROM Ingredients i")
    , @NamedQuery(name = "Ingredients.findById", query = "SELECT i FROM Ingredients i WHERE i.id = :id")
    , @NamedQuery(name = "Ingredients.findByNom", query = "SELECT i FROM Ingredients i WHERE i.nom = :nom")
    , @NamedQuery(name = "Ingredients.findByImage", query = "SELECT i FROM Ingredients i WHERE i.image = :image")
    , @NamedQuery(name = "Ingredients.findByPrix", query = "SELECT i FROM Ingredients i WHERE i.prix = :prix")})
public class Ingredients implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idIngredient")
    private Collection<Possede> possedeCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nom")
    private String nom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Column(name = "prix")
    private long prix;

    public Ingredients() {
    }

    public Ingredients(Integer id) {
        this.id = id;
    }

    public Ingredients(Integer id, String nom, String image, long prix) {
        this.id = id;
        this.nom = nom;
        this.image = image;
        this.prix = prix;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public long getPrix() {
        return prix;
    }

    public void setPrix(long prix) {
        this.prix = prix;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ingredients)) {
            return false;
        }
        Ingredients other = (Ingredients) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "jee.Ingredients[ id=" + id + " ]";
    }

    @XmlTransient
    public Collection<Possede> getPossedeCollection() {
        return possedeCollection;
    }

    public void setPossedeCollection(Collection<Possede> possedeCollection) {
        this.possedeCollection = possedeCollection;
    }
    
}
