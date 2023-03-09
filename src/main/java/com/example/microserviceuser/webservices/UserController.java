package com.example.microserviceuser.webservices;

import com.example.microserviceuser.entities.Utilisateur;
import com.example.microserviceuser.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.rmi.ServerException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private UserRepository userRepo;


//    Au lieu de utiliser Autowired on peut utiliser ce constructeur :
//    public UserController(UserRepository userRepository){
//        this.userRepository = userRepository;
//    }


    @GetMapping(path = "/Utilisateur")
    public List<Utilisateur> getUtilisateur() {
        return userRepo.findAll();
    }

    @GetMapping(path = "/Utilisateur/{id}")
    public Utilisateur getUtilisateur(@PathVariable(name = "id") Long clientId) {
        return userRepo.findById(clientId).get();
    }

    @PutMapping(path = "/Utilisateur/{id}")
    public Utilisateur update(@PathVariable(name = "id") Long clientId, @RequestBody Utilisateur utilisateur) {
        Utilisateur userToModify = userRepo.findById(clientId).get();
        userToModify.setUsername(utilisateur.getUsername());
        userToModify.setPassword(utilisateur.getPassword());
        userToModify.setEmail(utilisateur.getEmail());

        return userRepo.save(userToModify);

    }

    @PostMapping(path = "/Utilisateur")
    public Utilisateur create(@RequestBody Utilisateur utilisateur){
        return userRepo.save(utilisateur);
    }
    @DeleteMapping(path ="/Utilisateur/{id}")
    public void delete(@PathVariable Long clientId) {
        userRepo.deleteById(clientId);
    }
}



