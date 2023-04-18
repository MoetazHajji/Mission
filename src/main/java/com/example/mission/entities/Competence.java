package com.example.mission.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.ManyToMany;
import lombok.*;
import jakarta.persistence.*;
import java.util.Set;

import java.util.Date;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Competence {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String cname ;

    @JsonIgnore
    @ManyToMany(mappedBy = "competences")
    private Set<Mymission> missions;

}



