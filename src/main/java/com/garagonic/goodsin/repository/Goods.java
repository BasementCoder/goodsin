package com.garagonic.goodsin.repository;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

@Entity(name = "goods")
public class Goods implements Serializable {

    public Goods() {
        inDate = Calendar.getInstance().getTime();
    }
    @Id
    @Column(length=20)
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    private String rack;
    private String shelf;
    private int shelfPosition;
    private int PO;
    private int WO;
    private int SO;
    private String comment;
    private Date inDate;
    private Date outDate;
    private String customer;
    private String title;
    private long barcode;

    public long getBarcode() {
        return barcode;
    }

    public void setBarcode(long barcode) {
        this.barcode = barcode;
    }

    public String getLocation() {
        return getRack() + "-" + getShelf() + "-" + getShelfPosition();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public int getID() {
        return hashCode();
    }

    public String getRack() {
        return rack;
    }

    public void setRack(String rack) {
        if (rack != null) {
            rack = rack.toUpperCase();
        }
        this.rack = rack;
    }

    public String getShelf() {
        return shelf;
    }

    public void setShelf(String shelf) {
        if (shelf != null) {
            shelf = shelf.toUpperCase();
        }
        this.shelf = shelf;
    }

    public int getShelfPosition() {
        return shelfPosition;
    }

    public void setShelfPosition(int shelfPosition) {
        this.shelfPosition = shelfPosition;
    }

    public int getPO() {
        return PO;
    }

    public void setPO(int PO) {
        this.PO = PO;
    }

    public int getWO() {
        return WO;
    }

    public void setWO(int WO) {
        this.WO = WO;
    }

    public int getSO() {
        return SO;
    }

    public void setSO(int SO) {
        this.SO = SO;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getInDate() {
        return inDate;
    }

    public void setInDate(Date inDate) {
        this.inDate = inDate;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

}
