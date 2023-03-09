package com.example.microserviceuser.entities;
import java.time.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data  @AllArgsConstructor @NoArgsConstructor @ToString
public class Utilisateur {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long clientId;
    private String username;
    private String email;
    private String password;
    private LocalDate registerDate;
}

