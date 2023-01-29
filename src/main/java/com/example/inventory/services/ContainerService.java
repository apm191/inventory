package com.example.inventory.services;

import com.example.inventory.dao.Container.ContainerRepository;
import com.example.inventory.dao.Container.ContainerRepository_JDBC;
import com.example.inventory.models.Container;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContainerService
{
    @Autowired
    private ContainerRepository containerRepository;
    @Autowired
    private ContainerRepository_JDBC containerRepositoryJdbc;

    public List<Container> getAllContainers(){
        return containerRepositoryJdbc.getAllContainers();
    }

    public Container getContainer(int containerId)
    {
        return containerRepositoryJdbc.getContainer(containerId);
    }

    public void setContainer(Container container)
    {
        containerRepository.save(container);
    }

    public void updateContainer(Container container)
    {
        containerRepository.save(container);
    }

    public void deleteContainer(int containerId)
    {
        containerRepository.deleteById(String.valueOf(containerId));
    }

    public String availableSpace(int containerId, int quantity)
    {
        Container container = getContainer(containerId);
        if((container.maxCapacity-container.currQuantity)>=quantity)
        {
            return "Available";
        }
        return "Not Available";
    }
}
