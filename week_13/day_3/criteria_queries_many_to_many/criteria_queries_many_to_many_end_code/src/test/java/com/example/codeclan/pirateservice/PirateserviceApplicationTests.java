package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.repository.PirateRepository.PirateRepository;
import com.example.codeclan.pirateservice.repository.RaidRepository.RaidRepository;
import com.example.codeclan.pirateservice.repository.ShipRepository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PirateserviceApplicationTests {

	@Autowired
	PirateRepository pirateRepository;

	@Autowired
	ShipRepository shipRepository;

	@Autowired
	RaidRepository raidRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetPiratesForShip(){
		List<Pirate> results = shipRepository.findAllPiratesForShip(1L);

	}


	@Test
	public void canGetPiratesOverAge35(){
		List<Pirate> results = pirateRepository.findAllPiratesOverAge(35);
	}

	@Test
	public void canGetPirateWithLoot(){
		List<Pirate> results = pirateRepository.getAllPiratesFromRaidWithLoot(100);

	}


}
