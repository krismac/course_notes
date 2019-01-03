package com.codeclan.example.WhiskyTracker.repositories.WhiskyRepository;

import com.codeclan.example.WhiskyTracker.models.Whisky;

import java.util.List;

public interface WhiskyRepositoryCustom {
    List<Whisky> getAllWhiskiesForYear(int year);

    List<Whisky> getAllWhiskiesFromRegion(String region);

    List<Whisky> getWhiskyFromDistilleryAged(Long distilleryId, int age);
}
