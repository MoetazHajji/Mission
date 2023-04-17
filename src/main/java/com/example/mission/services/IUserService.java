package com.example.mission.services;

import com.example.mission.entities.Mymission;
import com.example.mission.entities.User;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public interface IUserService {
    User ajouterUser (User User);
    User modifierUser (User User);
    List<User> afficherUser();
    User afficherUser(Long id);
    void supprimerUser(Long id);

    User getByName(String name);
}
