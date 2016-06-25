/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "BOOKS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Books.findAll", query = "SELECT b FROM Books b")})
public class Books implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected BooksPK booksPK;
    @Size(max = 100)
    @Column(name = "Title")
    private String title;
    @Size(max = 30)
    @Column(name = "FirstName")
    private String firstName;
    @Size(max = 30)
    @Column(name = "LastName")
    private String lastName;
    @Size(max = 100)
    @Column(name = "Publisher")
    private String publisher;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Price")
    private Float price;
    @Size(max = 50)
    @Column(name = "category")
    private String category;
    @Column(name = "quantity")
    private Integer quantity;
    @Size(max = 200)
    @Column(name = "href")
    private String href;
    @Size(max = 30)
    @Column(name = "Publish_date")
    private String publishdate;

    public Books() {
    }

    public Books(BooksPK booksPK) {
        this.booksPK = booksPK;
    }

    public Books(String isbn, String owner) {
        this.booksPK = new BooksPK(isbn, owner);
    }
    public Books(String title, String firstName, String lastName, 
                    String publisher, float price, String publishdate,String category,
                    int quantity,String href, BooksPK pk){
        this.title = title;
        this.firstName = firstName;
        this.lastName = lastName;
        this.publisher = publisher;
        this.price = price;
        this.publishdate = publishdate;
        this.category = category;
        this.quantity = quantity;
        this.href = href; 
        this.booksPK = pk;   
    }

    public BooksPK getBooksPK() {
        return booksPK;
    }

    public void setBooksPK(BooksPK booksPK) {
        this.booksPK = booksPK;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public String getPublishdate() {
        return publishdate;
    }

    public void setPublishdate(String publishdate) {
        this.publishdate = publishdate;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (booksPK != null ? booksPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Books)) {
            return false;
        }
        Books other = (Books) object;
        if ((this.booksPK == null && other.booksPK != null) || (this.booksPK != null && !this.booksPK.equals(other.booksPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entity.Books[ booksPK=" + booksPK + " ]";
    }
    
}
