package com.example.codeclan.pirateservice.projections;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import org.springframework.data.rest.core.config.Projection;

import java.util.Date;
import java.util.List;

@Projection(name= "embedShip", types = Pirate.class)
public interface PirateProjection {
    long getId();
    String getFirstName();
    String getLastName();
    int getAge();
    Date getJoinDate();
    Ship getShip();
    List<Raid> getRaids();
}
