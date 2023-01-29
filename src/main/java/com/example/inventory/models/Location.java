package com.example.inventory.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Location
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int locationId;
    public String locationName;
    public String locationType;

    public Location() {
    }

    @Override
    public String toString() {
        return "Location{" +
                "locationId='" + locationId + '\'' +
                ", locationName='" + locationName + '\'' +
                ", locationType='" + locationType + '\'' +
                '}';
    }

    public int getLocationId() {
        return locationId;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }

    public Location(String locationName, String locationType) {
        this.locationName = locationName;
        this.locationType = locationType;
    }
}
