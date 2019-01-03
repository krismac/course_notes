package com.codeclan.example.WhiskyTracker.components;


import com.codeclan.example.WhiskyTracker.models.Distillery;
import com.codeclan.example.WhiskyTracker.models.Whisky;
import com.codeclan.example.WhiskyTracker.repositories.DistilleryRepository.DistilleryRepository;
import com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository.WhiskyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    DistilleryRepository distilleryRepository;

    @Autowired
    WhiskyRepository whiskyRepository;

    public DataLoader() {

    }

    public void run(ApplicationArguments args) {
        Distillery distillery1 = new Distillery("Glendronach", "Highland");
        distilleryRepository.save(distillery1);


        Whisky whisky1 = new Whisky("The Glendronach Revival", 15, 2018, distillery1);
        whiskyRepository.save(whisky1);

        Distillery distillery2 = new Distillery("Rosebank", "Lowland");
        distilleryRepository.save(distillery2);

        Whisky whisky2 = new Whisky("The Rosebank 12 - Flora and Fona", 12, 1991, distillery2);
        whiskyRepository.save(whisky2);


        Distillery distillery3 = new Distillery("Macallan", "Speyside");
        distilleryRepository.save(distillery3);


        Whisky whisky3 = new Whisky("The Macallan Anniversary Malt", 25, 1995, distillery3);
        whiskyRepository.save(whisky3);

        Whisky whisky4 = new Whisky("The Glendronach Original", 12, 2018, distillery1);
        whiskyRepository.save(whisky4);

        Distillery distillery4 = new Distillery("Balvenie", "Speyside");
        distilleryRepository.save(distillery4);
    }
}
