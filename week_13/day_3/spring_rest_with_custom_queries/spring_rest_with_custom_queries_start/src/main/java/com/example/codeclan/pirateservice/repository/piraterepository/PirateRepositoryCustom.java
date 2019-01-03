package com.example.codeclan.pirateservice.repository.piraterepository;

import com.example.codeclan.pirateservice.models.Pirate;

import java.util.List;

public interface PirateRepositoryCustom {
    public List<Pirate> findAllPiratesOver(int age);
}
