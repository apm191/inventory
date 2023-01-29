package com.example.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Tote
{
    @Id
    public String toteId;
    public String toteLocation;

    @Override
    public String toString() {
        return "Tote{" +
                "toteId='" + toteId + '\'' +
                ", toteLocation='" + toteLocation + '\'' +
                '}';
    }

    public String getToteId() {
        return toteId;
    }

    public void setToteId(String toteId) {
        this.toteId = toteId;
    }

    public String getToteLocation() {
        return toteLocation;
    }

    public void setToteLocation(String toteLocation) {
        this.toteLocation = toteLocation;
    }

    public Tote() {
    }

    public Tote(String toteId, String toteLocation) {
        this.toteId = toteId;
        this.toteLocation = toteLocation;
    }
}
