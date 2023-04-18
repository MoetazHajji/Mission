package com.example.mission.services;

import com.example.mission.entities.Competence;
import com.example.mission.entities.Mymission;

import java.util.List;
import java.util.Set;

public interface IMymissionService {
    Mymission ajouterMymission (Mymission Mymission);
    Mymission modifierMymission (Mymission Mymission);
    List<Mymission> afficherMymission();
    Mymission afficherMymission(Long id);
    void supprimerMymission(Long id);

    Mymission addMissionWithCompetence(Long idMission,Set<Long> idCompts);

    Mymission AssignUserToMission(Long idMission,String nameU);

    boolean verifMissionCapacity(Long idMission);

    Set<Competence> getCompetencesForMission(Long missionId);
}
