package com.example.mission.services;

import com.example.mission.Exception.OutOfNumberException;
import com.example.mission.entities.Competence;
import com.example.mission.entities.Mymission;
import com.example.mission.entities.User;
import com.example.mission.repositories.CompetenceRepository;
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
    private final CompetenceRepository competenceRepository;

    public MymissionService(MymissionRepository MymissionRepository , UserRepository userRepository,
                            CompetenceRepository competenceRepository) {
        this.MymissionRepository = MymissionRepository;
        this.userRepository = userRepository;
        this.competenceRepository = competenceRepository;
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
    public Mymission addMissionWithCompetence(Long idMission,Set<Long> idCompts ) {
        Mymission mymission = MymissionRepository.findById(idMission).orElse(null);
        Set<Competence> competenceList = new HashSet<>();
        for (Long idCompetence:idCompts){
            Competence competence=competenceRepository.findById(idCompetence).orElse(null);
            competenceList.add(competence);
            mymission.setCompetences(competenceList);
            competenceRepository.save(competence);
        }
        MymissionRepository.save(mymission);
        return mymission;
    }

    @Override
    @Transactional
    public Mymission AssignUserToMission(Long idMission, String nameU) {
        Mymission mymission = MymissionRepository.findById(idMission).orElse(null);
       /* User user=userRepository.findUserByName(nameU);
        Long nbPlacesMission = MymissionRepository.getNbUsers(idMission);
        Set<User> UserList = new HashSet<>();
        if(mymission.getNbPlaces() > nbPlacesMission) {
            UserList.add(user);
            user.setMission(mymission);
            userRepository.save(user);
            mymission.setUsers(UserList);
            MymissionRepository.save(mymission);
        }else if (mymission.getNbPlaces() == nbPlacesMission){
            throw new OutOfNumberException("This Mission is full");
        }*/
        return mymission;
    }

    @Override
    public boolean verifMissionCapacity(Long idMission) {
        Mymission mymission = MymissionRepository.findById(idMission).orElse(null);
        Long nbPlacesMission = MymissionRepository.getNbUsers(idMission);
        if (mymission.getNbPlaces() > nbPlacesMission){
            return true;
        }else if (mymission.getNbPlaces() == nbPlacesMission){
            return false;
        }else
            return false;
    }

    @Override
    public Set<Competence> getCompetencesForMission(Long missionId) {
        Mymission mission = MymissionRepository.findById(missionId).orElse(null);
        return mission.getCompetences();
    }
}