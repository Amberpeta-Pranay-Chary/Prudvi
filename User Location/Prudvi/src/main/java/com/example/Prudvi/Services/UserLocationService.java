package com.example.Prudvi.Services;

import com.example.Prudvi.Repository.userRepository;
import com.example.Prudvi.model.userLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class UserLocationService {
    @Autowired
    userRepository userRepository;
    public void create(userLocation userLocation) {
        userRepository.save(userLocation);
    }

    public void update(userLocation userLocation) {
        userLocation userLocation1=userRepository.findById(userLocation.getId()).orElse(null);
        if(userLocation1==null)
             new Exception("User is not Present to Update");
        userRepository.save(userLocation);
    }
    public List<userLocation> getNearestUsers(int limit) {
        // Retrieve all user locations from the database
        List<userLocation> allUserLocations = userRepository.findAll();

        // Calculate the distances from (0,0) for each user location
        List<UserLocationDistance> userLocationDistances = new ArrayList<>();
        for (userLocation userLocation : allUserLocations) {
            double distance = calculateDistance(userLocation.getLatitude(), userLocation.getLongitude(), 0, 0);
            userLocationDistances.add(new UserLocationDistance(userLocation, distance));
        }

        // Sort the user locations by distance in ascending order
        userLocationDistances.sort(Comparator.comparingDouble(UserLocationDistance::getDistance));

        // Retrieve the nearest N user locations
        List<userLocation> nearestUserLocations = new ArrayList<>();
        for (int i = 0; i < Math.min(limit, userLocationDistances.size()); i++) {
            nearestUserLocations.add(userLocationDistances.get(i).getUserLocation());
        }

        return nearestUserLocations;
    }

    private double calculateDistance(double lat1, double lon1, double lat2, double lon2) {
        // Implement the logic to calculate the distance between two coordinates
        // You can use formulas like Haversine or Vincenty's formulae

        // Dummy implementation
        return Math.abs(lat1 - lat2) + Math.abs(lon1 - lon2);
    }

    private static class UserLocationDistance {
        private final userLocation userLocation;
        private final double distance;

        public UserLocationDistance(userLocation userLocation, double distance) {
            this.userLocation = userLocation;
            this.distance = distance;
        }

        public userLocation getUserLocation() {
            return userLocation;
        }

        public double getDistance() {
            return distance;
        }

    }
}
