package com.example.microserviceuser;

import com.example.microserviceuser.entities.Utilisateur;
import com.example.microserviceuser.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class MicroServiceUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroServiceUserApplication.class, args);
    }
    @Bean
    CommandLineRunner start(UserRepository userRepo){
        return args -> {
            userRepo.save(new Utilisateur(null, "Julien", "name", "password", LocalDate.now()));
            userRepo.save(new Utilisateur(null, "Pierre", "name", "password", LocalDate.now()));
            userRepo.save(new Utilisateur(null, "Awat", "name", "password", LocalDate.now()));
            userRepo.save(new Utilisateur(null, "Kevin", "name", "password", LocalDate.now()));
            userRepo.findAll().forEach(utilisateur -> System.out.println(utilisateur.toString()));

        };
    }
}
