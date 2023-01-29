package com.example.inventory.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Entity
public class Container
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int containerId;

    public int maxCapacity;
    public int currQuantity;
    public String itemId;
    @OneToOne
    public Location location;

    @Override
    public String toString() {
        return "Container{" +
                "containerId=" + containerId +
                ", maxCapacity=" + maxCapacity +
                ", currQuantity=" + currQuantity +
                ", itemId='" + itemId + '\'' +
                ", location=" + location +
                '}';
    }

    public int getContainerId() {
        return containerId;
    }

    public void setContainerId(int containerId) {
        this.containerId = containerId;
    }

    public int getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(int maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public int getCurrQuantity() {
        return currQuantity;
    }

    public void setCurrQuantity(int currQuantity) {
        this.currQuantity = currQuantity;
    }

    public String getItemId() {
        return itemId;
    }

    public void setItemId(String itemId) {
        this.itemId = itemId;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Container() {
    }

    public Container(int maxCapacity, int currQuantity, String itemId, Location location) {
        this.maxCapacity = maxCapacity;
        this.currQuantity = currQuantity;
        this.itemId = itemId;
        this.location = location;
    }
}
