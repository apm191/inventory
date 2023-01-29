package com.example.inventory.controllers;

import com.example.inventory.models.Container;
import com.example.inventory.services.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
public class ContainerController
{
    @Autowired
    private ContainerService containerService;

    @GetMapping("/container")
    public List<Container> getAllContainers()
    {
        return containerService.getAllContainers();
    }

    @GetMapping("/container/{containerId}")
    public Container getContainer(@PathVariable int containerId)
    {
        return containerService.getContainer(containerId);
    }

    @PostMapping("/container")
    public void setContainer(@RequestBody Container container)
    {
        containerService.setContainer(container);
    }

    @PutMapping("/container")
    public void updateContainer(@RequestBody Container container)
    {
        containerService.updateContainer(container);
    }

    @DeleteMapping("/container/{containerId}")
    public void deleteContainer(@RequestParam int containerId) {
        containerService.deleteContainer(containerId);
    }

}
