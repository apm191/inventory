package com.example.inventory.services;

import com.example.inventory.dao.Location.LocationRepository;
import com.example.inventory.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LocationService
{
    @Autowired
    private LocationRepository locationRepository;
    public void setLocation(Location location)
    {
        locationRepository.save(location);
    }

}
