package com.example.codeclan.pirateservice.repository.PirateRepository;

import com.example.codeclan.pirateservice.models.Pirate;

import java.util.List;

public interface PirateRepositoryCustom {
    List<Pirate> findAllPiratesOverAge(int age);
    List<Pirate> getAllPiratesFromRaidWithLoot(int loot);
}
