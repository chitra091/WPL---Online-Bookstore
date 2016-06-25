/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author eric
 */
@Embeddable
public class RecordPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "id")
    private int id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "buyer")
    private String buyer;

    public RecordPK() {
    }

    public RecordPK(int id, String buyer) {
        this.id = id;
        this.buyer = buyer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBuyer() {
        return buyer;
    }

    public void setBuyer(String buyer) {
        this.buyer = buyer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) id;
        hash += (buyer != null ? buyer.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecordPK)) {
            return false;
        }
        RecordPK other = (RecordPK) object;
        if (this.id != other.id) {
            return false;
        }
        if ((this.buyer == null && other.buyer != null) || (this.buyer != null && !this.buyer.equals(other.buyer))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RecordPK[ id=" + id + ", buyer=" + buyer + " ]";
    }
    
}
