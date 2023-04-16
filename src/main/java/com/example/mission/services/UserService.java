package com.example.mission.services;

import com.example.mission.entities.User;
import com.example.mission.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    
    com.example.mission.repositories.UserRepository UserRepository;

    public UserService(UserRepository UserRepository) {
        this.UserRepository = UserRepository;
    }

    @Override
    public User ajouterUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public User modifierUser(User User) {
        return UserRepository.save(User);
    }

    @Override
    public List<User> afficherUser() {
        return UserRepository.findAll();
    }

    @Override
    public User afficherUser(Long id) {
        return UserRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerUser(Long id) {
        UserRepository.deleteById(id);
    }
}
