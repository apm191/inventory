package com.example.inventory.dao.Location;

import com.example.inventory.models.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Integer> {
}
