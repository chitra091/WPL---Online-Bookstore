/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author eric
 */
@Entity
@Table(name = "record")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Record.findAll", query = "SELECT r FROM Record r"),
    @NamedQuery(name = "Record.findById", query = "SELECT r FROM Record r WHERE r.recordPK.id = :id"),
    @NamedQuery(name = "Record.findBySeller", query = "SELECT r FROM Record r WHERE r.seller = :seller"),
    @NamedQuery(name = "Record.findByBuyer", query = "SELECT r FROM Record r WHERE r.recordPK.buyer = :buyer"),
    @NamedQuery(name = "Record.findByTotalPrice", query = "SELECT r FROM Record r WHERE r.totalPrice = :totalPrice"),
    @NamedQuery(name = "Record.findByRecordTime", query = "SELECT r FROM Record r WHERE r.recordTime = :recordTime")})
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecordPK recordPK;
    @Size(max = 50)
    @Column(name = "seller")
    private String seller;
    @Column(name = "totalPrice")
    private Integer totalPrice;
    @Column(name = "recordTime")
    @Temporal(TemporalType.DATE)
    private Date recordTime;
    @JoinColumn(name = "buyer", referencedColumnName = "UserName", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Customer customer;

    public Record() {
    }

    public Record(RecordPK recordPK) {
        this.recordPK = recordPK;
    }

    public Record(int id, String buyer) {
        this.recordPK = new RecordPK(id, buyer);
    }

    public RecordPK getRecordPK() {
        return recordPK;
    }

    public void setRecordPK(RecordPK recordPK) {
        this.recordPK = recordPK;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Date getRecordTime() {
        return recordTime;
    }

    public void setRecordTime(Date recordTime) {
        this.recordTime = recordTime;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recordPK != null ? recordPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Record)) {
            return false;
        }
        Record other = (Record) object;
        if ((this.recordPK == null && other.recordPK != null) || (this.recordPK != null && !this.recordPK.equals(other.recordPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Record[ recordPK=" + recordPK + " ]";
    }
    
}
