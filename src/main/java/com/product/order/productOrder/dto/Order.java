package com.product.order.productOrder.dto;

import java.util.UUID;

import javax.persistence.*;

@Entity
@Table(name="PRODUCT_ORDER")
public class Order {
    @Id   
    private Integer id;
    private String name;
    private double price;
    private int quantity;
    private double total;
    
    @Column(name = "ORDER_PRODUCT_ID")
    private String productId;
  
    @Transient
    private String corelationId= UUID.randomUUID().toString();
    public Order() {

    }
    public Order(int id,String name, double price, int quantity,String productId) {
    	this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;        
        this.total = price * quantity;
        this.productId = productId;

    }

    public Integer getId() {
        return id;
    }

    public void setProductIdID(String productID) {
        this.productId = productID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getCorelationId() {
        return corelationId;
    }
 

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", total=" + total +
                ", corelationId='" + corelationId + '\'' +
                '}';
    }
}