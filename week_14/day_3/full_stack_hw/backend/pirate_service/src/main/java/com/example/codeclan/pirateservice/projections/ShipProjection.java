package com.example.codeclan.pirateservice.projections;

import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.rest.core.config.Projection;

import java.util.List;

@Projection(name = "embedPirates", types = Ship.class)
public interface ShipProjection {
    long getId();
    String getName();
    List<PirateProjection> getPirates();
}
