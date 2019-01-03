package com.example.codeclan.pirateservice.repository.pirates;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.projections.PirateProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = PirateProjection.class)
public interface PirateRepository extends JpaRepository<Pirate, Long>, PirateRepositoryCustom {
}
