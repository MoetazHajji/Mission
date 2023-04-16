package com.example.mission.services;

import com.example.mission.entities.Competence;

import java.util.List;

public interface ICompetenceService {
    Competence ajouterCompetence (Competence Competence);
    Competence modifierCompetence (Competence Competence);
    List<Competence> afficherCompetence();
    Competence afficherCompetence(Long id);
    void supprimerCompetence(Long id);
    Competence getComByName(String name);
}
