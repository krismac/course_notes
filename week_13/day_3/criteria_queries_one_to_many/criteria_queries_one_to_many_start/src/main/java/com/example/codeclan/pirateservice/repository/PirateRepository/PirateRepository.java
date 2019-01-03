package com.example.codeclan.pirateservice.repository.PirateRepository;

import com.example.codeclan.pirateservice.models.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long>, PirateRepositoryCustom {
}
