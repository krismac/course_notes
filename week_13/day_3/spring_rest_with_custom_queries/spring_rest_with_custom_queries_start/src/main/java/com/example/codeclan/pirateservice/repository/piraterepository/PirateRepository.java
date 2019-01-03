package com.example.codeclan.pirateservice.repository.piraterepository;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long>, PirateRepositoryCustom {
    public List<Pirate> findAllPiratesOver(int age);
}
