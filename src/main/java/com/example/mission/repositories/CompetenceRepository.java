package com.example.mission.repositories;


import com.example.mission.entities.Competence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetenceRepository extends JpaRepository<Competence, Long> {
    Competence findCompetenceByCname(String cname);
}
