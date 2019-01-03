package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.piraterepository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pirates")
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @GetMapping(value = "/older/{age}")
    public List<Pirate> findAllPiratesOver( @PathVariable int age){
        return pirateRepository.findAllPiratesOver(age);
    }
}
