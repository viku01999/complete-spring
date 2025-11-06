package com.example.zoomanagement.service;

import com.example.zoomanagement.entity.Habitat;
import com.example.zoomanagement.repository.HabitatRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HabitatService {

    private final HabitatRepository habitatRepository;

    public HabitatService(HabitatRepository habitatRepository) {
        this.habitatRepository = habitatRepository;
    }

    public List<Habitat> getAllHabitats() {
        return habitatRepository.findAll();
    }
}
