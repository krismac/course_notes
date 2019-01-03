package com.example.codeclan.pirateservice.repository.raids;

import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.projections.RaidProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = RaidProjection.class)
public interface RaidRepository extends JpaRepository<Raid, Long>, RaidRepositoryCustom {
}
