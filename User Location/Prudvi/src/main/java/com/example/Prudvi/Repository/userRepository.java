package com.example.Prudvi.Repository;

import com.example.Prudvi.model.userLocation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface userRepository extends JpaRepository<userLocation, Integer> {
}
