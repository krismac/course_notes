package com.codeclan.example.pirateservice_d1_starter.projections;


import com.codeclan.example.pirateservice_d1_starter.models.Pirate;
import com.codeclan.example.pirateservice_d1_starter.models.Ship;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "embedShip", types = Pirate.class)
public interface EmbedShip {
    String getFirstName();
    String getLastName();
    int getAge();
    Ship getShip();
}
