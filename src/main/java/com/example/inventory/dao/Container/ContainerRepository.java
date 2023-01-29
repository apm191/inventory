package com.example.inventory.dao.Container;

import com.example.inventory.models.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainerRepository extends JpaRepository<Container,String> {
}
