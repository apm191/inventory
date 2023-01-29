package com.example.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

//@Entity
public class temp
{
//    @Id
    public String containerId;
    public String containerType;

    @Override
    public String toString() {
        return "ItemContainer{" +
                "containerId='" + containerId + '\'' +
                ", containerType='" + containerType + '\'' +
                '}';
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getContainerType() {
        return containerType;
    }

    public void setContainerType(String containerType) {
        this.containerType = containerType;
    }

    public temp() {
    }

    public temp(String containerId, String containerType) {
        this.containerId = containerId;
        this.containerType = containerType;
    }
}
