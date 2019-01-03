package com.example.codeclan.pirateservice.projections;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedRaidPirates", types= Raid.class)
public interface RaidProjection {
    long getId();
    String getLocation();
    int getLoot();
    List<Pirate> getPirates();
}
