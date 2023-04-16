package com.example.mission.entities;

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
public class Message {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String msg ;
    //@ManyToOne
    //private Set<Admin> Admin;
    //@ManyToOne
    //private Set<User> User;
}
