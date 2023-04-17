package com.example.mission.services;

import com.example.mission.Exception.OutOfNumberException;
import com.example.mission.entities.Competence;
import com.example.mission.entities.Mymission;
import com.example.mission.entities.User;
import com.example.mission.repositories.MymissionRepository;
import com.example.mission.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class MymissionService implements IMymissionService {
    MymissionRepository MymissionRepository;

    UserRepository userRepository;

    public MymissionService(MymissionRepository MymissionRepository , UserRepository userRepository) {
        this.MymissionRepository = MymissionRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Mymission ajouterMymission(Mymission Mymission) {
        return MymissionRepository.save(Mymission);
    }

    @Override
    public Mymission modifierMymission(Mymission Mymission) {
        return MymissionRepository.save(Mymission);
    }

    @Override
    public List<Mymission> afficherMymission() {
        return MymissionRepository.findAll();
    }

    @Override
    public Mymission afficherMymission(Long id) {
        return MymissionRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerMymission(Long id) {
        MymissionRepository.deleteById(id);
    }

    @Override
    public Mymission addMissionWithCompetence(Mymission mymission) {
        MymissionRepository.save(mymission);
        Set<Competence> competences =mymission.getCompetences();
        mymission.setCompetences(null);
        for (Competence competence:competences){
            competence.setMission(mymission);
            MymissionRepository.save(mymission);
        }
        return mymission;
    }

    @Override
    @Transactional
    public Mymission AssignUserToMission(Long idMission, String nameU) {
        Mymission mymission = MymissionRepository.findById(idMission).orElse(null);
        Long nbPlacesMission = MymissionRepository.getNbUsers(idMission);
        mymission.setUsers(null);
        for (User user:mymission.getUsers()){
            if(mymission.getNbPlaces() > nbPlacesMission) {
                user.setMission(mymission);
                userRepository.save(user);
            }else if (mymission.getNbPlaces() == nbPlacesMission){
                throw new OutOfNumberException("This Mission is full");
            }
        }
        MymissionRepository.save(mymission);
        return mymission;
    }
}