package com.garagonic.goodsin.UIEntities;

import com.garagonic.goodsin.repository.Goods;

import java.util.Date;

public class UIGoods {

    private int id;

    private String rack;
    private String shelf;
    private Integer shelfPosition;
    private Integer po;
    private Integer wo;
    private Integer so;
    private String comment;
    private Date inDate;
    private Date outDate;
    private String customer;
    private String title;
    private Long barcode;
    private boolean inStock;

    public UIGoods(Goods goods) {
        this.id = goods.getId();
        this.rack = goods.getRack();
        this.shelf = goods.getShelf();
        this.shelfPosition = mapIntToInteger(goods.getShelfPosition());
        this.po = mapIntToInteger(goods.getPo());
        this.wo = mapIntToInteger(goods.getWo());
        this.so = mapIntToInteger(goods.getSo());
        this.comment = goods.getComment();
        this.inDate = goods.getInDate();
        this.outDate = goods.getOutDate();
        this.customer = goods.getCustomer();
        this.title = goods.getTitle();
        this.barcode = goods.getBarcode();
        this.inStock = goods.isInStock();
    }

    public Goods goodsConverter(){
        Goods goods = new Goods();
        goods.setId(id);
        goods.setRack(rack);
        goods.setShelf(shelf);
        goods.setShelfPosition(mapIntegerToInt(shelfPosition));
        goods.setPo(mapIntegerToInt(po));
        goods.setWo(mapIntegerToInt(wo));
        goods.setSo(mapIntegerToInt(so));
        goods.setComment(comment);
        goods.setInDate(inDate);
        goods.setOutDate(outDate);
        goods.setCustomer(customer);
        goods.setTitle(title);
        goods.setBarcode(barcode);
        goods.setInStock(inStock);

        return goods;
    }
    private  int mapIntegerToInt(Integer i){
        return  i == null ? 0 : i;
    }

    private Integer mapIntToInteger(int i) {
        return i == 0 ? null : i;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isInStock() {
        return inStock;
    }

    public void setInStock(boolean inStock) {
        this.inStock = inStock;
    }

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

    public Integer getShelfPosition() {
        return shelfPosition;
    }

    public void setShelfPosition(Integer shelfPosition) {
        this.shelfPosition = shelfPosition;
    }

    public Integer getPo() {
        return po;
    }

    public void setPo(Integer po) {
        this.po = po;
    }

    public Integer getWo() {
        return wo;
    }

    public void setWo(Integer wo) {
        this.wo = wo;
    }

    public Integer getSo() {
        return so;
    }

    public void setSo(Integer so) {
        this.so = so;
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
