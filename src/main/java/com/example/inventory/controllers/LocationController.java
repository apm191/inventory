package com.example.inventory.controllers;

import com.example.inventory.models.Location;
import com.example.inventory.services.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class LocationController
{
    @Autowired
    private LocationService locationService;

    @GetMapping("/location")
    public List<Location> getAllLocations()
    {
        return locationService.getAllLocation();
    }

    @GetMapping("/location/{locationId}")
    public Optional<Location> getLocation(@PathVariable int locationId)
    {
        return locationService.getLocation(locationId);
    }
}
