package com.example.inventory.dao.Item;

import com.example.inventory.models.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item,String> {
}
