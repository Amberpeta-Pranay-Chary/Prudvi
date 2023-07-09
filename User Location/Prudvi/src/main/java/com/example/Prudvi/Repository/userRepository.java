package com.example.Prudvi.Repository;

import com.example.Prudvi.model.userLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

public interface userRepository extends JpaRepository<userLocation, Integer> {
    UserDetails findByUsername(String username);
}
