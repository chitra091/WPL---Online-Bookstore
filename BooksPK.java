/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

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
public class BooksPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 13)
    @Column(name = "ISBN")
    private String isbn;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "owner")
    private String owner;

    public BooksPK() {
    }

    public BooksPK(String isbn, String owner) {
        this.isbn = isbn;
        this.owner = owner;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (isbn != null ? isbn.hashCode() : 0);
        hash += (owner != null ? owner.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof BooksPK)) {
            return false;
        }
        BooksPK other = (BooksPK) object;
        if ((this.isbn == null && other.isbn != null) || (this.isbn != null && !this.isbn.equals(other.isbn))) {
            return false;
        }
        if ((this.owner == null && other.owner != null) || (this.owner != null && !this.owner.equals(other.owner))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.BooksPK[ isbn=" + isbn + ", owner=" + owner + " ]";
    }
    
}
