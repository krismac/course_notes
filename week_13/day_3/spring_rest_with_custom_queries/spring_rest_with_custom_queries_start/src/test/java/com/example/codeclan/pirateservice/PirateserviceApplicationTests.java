package com.example.codeclan.pirateservice;

import com.example.codeclan.pirateservice.models.Pirate;
import com.example.codeclan.pirateservice.models.Raid;
import com.example.codeclan.pirateservice.models.Ship;
import com.example.codeclan.pirateservice.repository.piraterepository.PirateRepository;
import com.example.codeclan.pirateservice.repository.RaidRepository;
import com.example.codeclan.pirateservice.repository.ShipRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
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
	public void createPirateAndShipThenSave(){

		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);
	}

	@Test
	public void createPirateAndRaidThenSave(){
		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);
		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);

		Raid raid = new Raid("Tortuga", 100);
		raidRepository.save(raid);

		jack.addRaid(raid);
		raid.addPirate(jack);
		raidRepository.save(raid);
		
	}

	@Test
	public void findAllPiratesOver35(){
		Ship dutchman = new Ship("The Flying Dutchman");
		shipRepository.save(dutchman);

		Pirate jack = new Pirate("jack", "sparrow", 32, dutchman);
		pirateRepository.save(jack);

		Pirate john = new Pirate("john", "silver", 38, dutchman);
		pirateRepository.save(john);

		Pirate hook = new Pirate("cpt", "hook", 44, dutchman);
		pirateRepository.save(hook);

		List<Pirate> foundOver = pirateRepository.findAllPiratesOver(35);

	}


}
