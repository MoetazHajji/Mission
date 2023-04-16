package com.example.mission.services;

import org.springframework.stereotype.Service;


import com.example.mission.entities.Competence;
import com.example.mission.repositories.CompetenceRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CompetenceService implements ICompetenceService {
    CompetenceRepository CompetenceRepository;

    public CompetenceService(CompetenceRepository CompetenceRepository) {
        this.CompetenceRepository = CompetenceRepository;
    }

    @Override
    public Competence ajouterCompetence(Competence Competence) {
        return CompetenceRepository.save(Competence);
    }

    @Override
    public Competence modifierCompetence(Competence Competence) {
        return CompetenceRepository.save(Competence);
    }

    @Override
    public List<Competence> afficherCompetence() {
        return CompetenceRepository.findAll();
    }

    @Override
    public Competence afficherCompetence(Long id) {
        return CompetenceRepository.findById(id).orElse(null);
    }

    @Override
    public void supprimerCompetence(Long id) {
        CompetenceRepository.deleteById(id);

    }

    @Override
    public Competence getComByName(String name) {
        return CompetenceRepository.findCompetenceByCname(name);
    }
}