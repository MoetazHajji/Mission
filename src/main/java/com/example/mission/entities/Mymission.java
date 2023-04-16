package com.example.mission.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import lombok.*;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Set;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mymission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String title ;
    String description;
    String location;
    @Temporal(TemporalType.DATE)
    LocalDate dateDebut;
    @Temporal(TemporalType.DATE)
    LocalDate dateFin;
    Long nbPlaces;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private Set<Competence> Competences;

    @OneToMany(mappedBy = "mission",cascade = CascadeType.ALL)
    private Set<User> users;

}


