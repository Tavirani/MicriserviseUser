package com.example.microserviceuser.repositories;

import com.example.microserviceuser.entities.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;


@RepositoryRestResource
public interface UserRepository extends JpaRepository<Utilisateur, Long> {
    @RestResource(path = "/byUsername")
    List<Utilisateur> findByUsername(@Param(value = "username") Utilisateur utilisateur);

}
