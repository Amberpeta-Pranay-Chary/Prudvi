package com.example.Prudvi.Controller;

import com.example.Prudvi.Services.UserLocationService;
import com.example.Prudvi.model.userLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class UserLocationController {
    @Autowired
    UserLocationService userLocationService;

    @PostMapping("/create_data")
    public void createData(@RequestBody @Valid userLocation userLocation)
    {
        userLocationService.create(userLocation);
    }
    @PutMapping("/update_data")
    public void updateData(@RequestBody @Valid userLocation userLocation)
    {
        userLocationService.update(userLocation);
    }

    @GetMapping("/get_user")
    public List<userLocation> getUsers(@RequestParam("N") Integer N)
    {
       return userLocationService.getNearestUsers(N);
    }
}
