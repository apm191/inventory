package com.example.inventory.controllers;

import com.example.inventory.models.Item;
import com.example.inventory.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InventoryController
{
    @Autowired
    private ItemService itemService;
    @GetMapping("/inventory")
    public List<Item> getAllitems(){
        return itemService.getAllitems();
    }

    @GetMapping("/inventory/{itemId}")
    public Item getInventoryItem(@PathVariable String itemId)
    {
        return itemService.getItem(itemId);
    }

    @PostMapping("/inventory")
    public int setInventoryItem(@RequestBody Item item){
        return itemService.setItem(item);
    }

    @PutMapping("/inventory")
    public void updateInventoryItem(@RequestBody Item item)
    {
        itemService.updateItem(item);
    }

    @DeleteMapping("inventory/{itemId}")
    public void deleteInventoryItem(@PathVariable String itemId)
    {
        itemService.deleteItem(itemId);
    }

}
