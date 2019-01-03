package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.repository.pirates.PirateRepository;
import com.example.codeclan.pirateservice.repository.raids.RaidRepository;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pirates")
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @Autowired
    RaidRepository raidRepository;

    @PutMapping(value = "/{id}/raid/{raidId}")
    public void updateaddPirate(@PathVariable long id, @PathVariable long raidId){
        Pirate pirate = pirateRepository.getOne(id);
        Raid raid = raidRepository.getOne(raidId);
        raid.addPirate(pirate);
        pirate.addRaid(raid);
        pirateRepository.save(pirate);
    }
}
