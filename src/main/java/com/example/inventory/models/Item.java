package com.example.inventory.models;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
public class Item
{
    @Id
    private String sku;
    public String name;
    public int quantity;
    public int price;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    @Temporal(TemporalType.DATE)
    public Date expiryDate;
    @Column(name = "containers")
    @ElementCollection(targetClass = Integer.class)
    public List<Integer> containerList;

    @Override
    public String toString() {
        return "Item{" +
                "sku='" + sku + '\'' +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", expiryDate=" + expiryDate +
                ", containerList=" + containerList +
                '}';
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public List<Integer> getContainerList() {
        return containerList;
    }

    public void setContainerList(List<Integer> containerList) {
        this.containerList = containerList;
    }

    public Item() {
    }

    public Item(String sku, String name, int quantity, int price, Date expiryDate, List<Integer> containerList) {
        this.sku = sku;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.expiryDate = expiryDate;
        this.containerList = containerList;
    }
}
