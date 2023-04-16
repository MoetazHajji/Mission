package com.example.mission.services;

import com.example.mission.entities.Competence;
import com.example.mission.entities.Mymission;

import java.util.List;

public interface IMymissionService {
    Mymission ajouterMymission (Mymission Mymission);
    Mymission modifierMymission (Mymission Mymission);
    List<Mymission> afficherMymission();
    Mymission afficherMymission(Long id);
    void supprimerMymission(Long id);

    Mymission addMissionWithCompetence(Mymission mymission);

    Mymission AssignUserToMission(Long idMission,String nameU);
}
