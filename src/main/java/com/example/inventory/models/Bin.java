package com.example.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Bin
{
    @Id
    public String binId;
    public String binLocation;

    @Override
    public String toString() {
        return "Bin{" +
                "binId='" + binId + '\'' +
                ", binLocation='" + binLocation + '\'' +
                '}';
    }

    public String getBinId() {
        return binId;
    }

    public void setBinId(String binId) {
        this.binId = binId;
    }

    public String getBinLocation() {
        return binLocation;
    }

    public void setBinLocation(String binLocation) {
        this.binLocation = binLocation;
    }

    public Bin() {
    }

    public Bin(String binId, String binLocation) {
        this.binId = binId;
        this.binLocation = binLocation;
    }
}
