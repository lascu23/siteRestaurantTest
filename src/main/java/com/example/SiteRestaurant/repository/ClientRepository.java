package com.example.SiteRestaurant.repository;

import com.example.SiteRestaurant.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client readByEmail(String email);
}

