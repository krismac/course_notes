package com.codeclan.example.WhiskyTracker;

import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class WhiskyTrackerApplicationTests {

	@Autowired
	WhiskyRepository whiskyRepository;

	@Autowired
	DistilleryRepository distilleryRepository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void canGetAllWhiskiesForYear(){
		List<Whisky> found = whiskyRepository.getAllWhiskiesForYear(2018);
		assertEquals(2, found.size());
		assertEquals("The Glendronach Revival", found.get(0).getName());
		assertEquals("The Glendronach Original", found.get(1).getName());
	}

	@Test
	public void canGetAllWhiskiesFromRegionHighland(){
		List<Whisky> found = whiskyRepository.getAllWhiskiesFromRegion("Highland");
		assertEquals(2, found.size());
		assertEquals("The Glendronach Revival", found.get(0).getName());
		assertEquals("The Glendronach Original", found.get(1).getName());

	}

	@Test
	public void canGetAllWhiskiesFromRegionSpeyside(){
		List<Whisky> found = whiskyRepository.getAllWhiskiesFromRegion("Speyside");
		assertEquals(1, found.size());
		assertEquals("The Macallan Anniversary Malt", found.get(0).getName());
	}



	@Test
	public void canGetAllWhiskiesFromDistilleryAged(){
		List<Whisky> found = whiskyRepository.getWhiskyFromDistilleryAged(1L, 15);
		assertEquals(1, found.size());
	}

	@Test
	public void canGetDistilleriesForWhiskiesAged(){
		List<Distillery> found = distilleryRepository.getDistilleriesForWhiskiesAged(12);
		assertEquals(2, found.size());
	}

	@Test
	public void canGetDistilleriesForRegionSpey(){
		List<Distillery> found = distilleryRepository.getDistilleriesForRegion("Speyside");
		assertEquals(2, found.size());
	}
}
