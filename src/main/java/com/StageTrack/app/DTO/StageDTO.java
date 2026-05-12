package com.StageTrack.app.DTO;



import lombok.Data;
import java.time.LocalDate;

// Cet objet reçoit exactement ce que l'utilisateur tape dans le formulaire
@Data
public class StageDTO {

    private String titre;
    private String poste;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private String description;

    // L'utilisateur choisit une entreprise existante par son id
    private Long entrepriseId;

    // L'utilisateur choisit un maître de stage par son id
    private Long maitreStageId;
}