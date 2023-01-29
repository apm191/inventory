package com.example.inventory.services;

import com.example.inventory.dao.Container.ContainerRepository;
import com.example.inventory.dao.Container.ContainerRepository_JDBC;
import com.example.inventory.dao.Item.ItemRepository;
import com.example.inventory.dao.Item.ItemRepository_JDBC;
import com.example.inventory.models.Container;
import com.example.inventory.models.Item;
import com.example.inventory.models.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService
{
    @Autowired
    private ItemRepository_JDBC itemRepositoryJdbc;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ContainerService containerService;

    @Autowired
    private LocationService locationService;

    public List<Item> getAllitems(){
        return itemRepositoryJdbc.getItems();
    }

    public Item getItem(String itemId)
    {
        return itemRepositoryJdbc.getItem(itemId);
    }

    public int setItem(Item item)
    {
        String check = itemRepositoryJdbc.checkItem(item);
        if(check!="No Item Found!!")
        {
            Item registeredItem = getItem(check);
            int numberOfContainers = registeredItem.getContainerList().size()-1;
            String availableSpace = containerService.availableSpace(registeredItem.getContainerList().get(numberOfContainers),item.quantity);

            if(availableSpace=="Available")
            {
                Container container = containerService.getContainer(registeredItem.getContainerList().get(numberOfContainers));
                container.setCurrQuantity(container.getCurrQuantity()+item.quantity);
                containerService.updateContainer(container);
                registeredItem.setQuantity(registeredItem.getQuantity()+item.quantity);
                itemRepository.save(registeredItem);
                return container.getContainerId();
            }
            else
            {
                Container container = new Container();
                container.setMaxCapacity(1000);
                container.setCurrQuantity(item.quantity);
                container.setItemId(item.getSku());
                Location location=new Location();
                location.setLocationName("Unloading Area");
                location.setLocationType("Tote");
                locationService.setLocation(location);

                container.setLocation(location);
                containerService.setContainer(container);

                registeredItem.setQuantity(registeredItem.getQuantity()+item.quantity);
                registeredItem.getContainerList().add(container.getContainerId());
                itemRepository.save(registeredItem);

                return container.getContainerId();
            }
        }
        else
        {
            Container container = new Container();
            container.setMaxCapacity(1000);
            container.setCurrQuantity(item.quantity);
            container.setItemId(item.getSku());

            Location location=new Location();
            location.setLocationName("Unloading Area");
            location.setLocationType("Tote");
            locationService.setLocation(location);

            container.setLocation(location);
            containerService.setContainer(container);

            item.getContainerList().add(container.getContainerId());
            itemRepository.save(item);
            return container.getContainerId();
        }
    }

    public void deleteItem(String itemId)
    {
        itemRepository.deleteById(itemId);
    }

    public void updateItem(Item item)
    {
        itemRepository.save(item);
    }
}
