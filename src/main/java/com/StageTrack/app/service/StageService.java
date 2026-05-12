package com.StageTrack.app.service;

import com.StageTrack.app.DTO.StageDTO;
import com.StageTrack.app.domain.Entreprise;
import com.StageTrack.app.domain.MaitreStage;
import com.StageTrack.app.domain.Stage;
import com.StageTrack.app.repository.EntrepriseRepository;
import com.StageTrack.app.repository.MaitreStageRepository;
import com.StageTrack.app.repository.StageRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StageService {

    private final StageRepository stageRepository;
    private final EntrepriseRepository entrepriseRepository;
    private final MaitreStageRepository maitreStageRepository;

    public StageService(StageRepository stageRepository,
                        EntrepriseRepository entrepriseRepository,
                        MaitreStageRepository maitreStageRepository) {
        this.stageRepository = stageRepository;
        this.entrepriseRepository = entrepriseRepository;
        this.maitreStageRepository = maitreStageRepository;
    }

    // Crée un Stage à partir des données du formulaire (DTO)
    public Stage creerDepuisDTO(StageDTO dto) {

        // Cherche l'entreprise par son id
        Entreprise entreprise = entrepriseRepository.findById(dto.getEntrepriseId())
                .orElseThrow(() -> new RuntimeException("Entreprise introuvable"));

        // Cherche le maître de stage si fourni
        MaitreStage maitreStage = null;
        if (dto.getMaitreStageId() != null) {
            maitreStage = maitreStageRepository.findById(dto.getMaitreStageId())
                    .orElse(null);
        }

        // Construit l'objet Stage
        Stage stage = new Stage();
        stage.setTitre(dto.getTitre());
        stage.setPoste(dto.getPoste());
        stage.setDateDebut(dto.getDateDebut());
        stage.setDateFin(dto.getDateFin());
        stage.setDescription(dto.getDescription());
        stage.setStatut("A_VENIR");
        stage.setEntreprise(entreprise);
        stage.setMaitreStage(maitreStage);

        return stageRepository.save(stage);
    }

    // Récupère tous les stages
    public List<Stage> tousLesStages() {
        return stageRepository.findAll();
    }
}