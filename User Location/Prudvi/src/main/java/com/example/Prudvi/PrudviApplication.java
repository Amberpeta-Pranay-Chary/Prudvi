package com.example.Prudvi;

import com.example.Prudvi.model.userLocation;
import com.example.Prudvi.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class PrudviApplication  implements CommandLineRunner{
	@Autowired
	userRepository userRepository;
	@Autowired
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(PrudviApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		userLocation userLocation1=new userLocation();
//		userLocation1.setPassword("Prudvi@5");
//		userLocation1.setUsername("prudvi665@gmail.com");
//		userLocation1.setId(1);
//		userLocation1.setName("Prudvi");
//		userLocation1.setLatitude(5.5);
//		userLocation1.setLongitude(7.0);
//		userLocation1.setAuthorities("reader");
//		userRepository.save(userLocation1);
//		userLocation userLocation1=userRepository.findById(6).orElse(null);
//		userLocation1.setPassword(passwordEncoder.encode(userLocation1.getPassword()));
//		userRepository.save(userLocation1);
	}
}
