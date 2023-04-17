package com.example.mission.controller;

import jakarta.persistence.Entity;
import org.springframework.web.bind.annotation.*;
import com.example.mission.entities.Mymission;
import com.example.mission.services.IMymissionService;

import java.util.List;
@RestController
@RequestMapping("Mymission")
@CrossOrigin(origins = "http://localhost:4200")
public class MymissionController {
     IMymissionService MymissionService;

    public MymissionController(IMymissionService IMymissionService) {
        this.MymissionService = IMymissionService;
    }

    @PostMapping("/add")
    public Mymission ajouterMymission(@RequestBody Mymission Mymission) {
        return MymissionService.ajouterMymission(Mymission);
    }
    @PutMapping("/update")
    public Mymission modifierMymission(@RequestBody Mymission Mymission) {
        return MymissionService.modifierMymission(Mymission);
    }
    @GetMapping("/getAll")
    public List<Mymission> afficherMymission() {
        return MymissionService.afficherMymission();
    }

    @GetMapping("/getById/{id}")
    public Mymission afficherMymission(@PathVariable("id") Long id) {
        return MymissionService.afficherMymission(id);
    }

    @DeleteMapping("/delete/{id}")
    public void supprimerMymission(@PathVariable("id") Long id) {
        MymissionService.supprimerMymission(id);
    }

    @PostMapping("/addWC")
    public Mymission addMissionWithCompetence(@RequestBody Mymission mymission){
        return MymissionService.addMissionWithCompetence(mymission);
    }

    

}
