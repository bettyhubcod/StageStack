package com.StageTrack.app.service;

import com.StageTrack.app.domain.Stage;
import com.StageTrack.app.repository.StageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service   // Dit à Spring que cette classe est un service
public class StageService {

    // Spring injecte automatiquement le repository
    private final StageRepository stageRepository;

    // Constructeur : Spring Boot injecte StageRepository ici
    public StageService(StageRepository stageRepository) {
        this.stageRepository = stageRepository;
    }

    // Sauvegarder un stage
    public Stage sauvegarder(Stage stage) {
        return stageRepository.save(stage);
    }

    // Récupérer tous les stages
    public List<Stage> tousLesStages() {
        return stageRepository.findAll();
    }
}