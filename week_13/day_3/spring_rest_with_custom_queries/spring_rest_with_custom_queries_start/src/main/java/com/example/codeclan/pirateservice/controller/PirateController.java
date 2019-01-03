package com.example.codeclan.pirateservice.controller;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.piraterepository.PirateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
public class PirateController {
    @Autowired
    PirateRepository pirateRepository;

    @RequestMapping(value = "/pirates", method = RequestMethod.GET)
    public List<Pirate> getAllPirates(){
        return pirateRepository.findAll();
    }
}
