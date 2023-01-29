package com.example.inventory.dao.Bin;

import com.example.inventory.models.Bin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BinRepository extends JpaRepository<Bin,String> {
}
