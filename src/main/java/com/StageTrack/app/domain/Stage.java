package com.StageTrack.app.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Data               // Lombok génère automatiquement les getters/setters
@Entity             // Dit à JPA que cette classe = une table en base
@Table(name = "stages")  // Nom de la table dans PostgreSQL
public class Stage {

    @Id                                        // Clé primaire
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Auto-incrément
    private Long id;

    @Column(nullable = false)   // Cette colonne ne peut pas être vide
    private String entreprise;

    @Column(nullable = false)
    private String poste;

    private String encadrant;

    @Column(name = "date_debut")
    private LocalDate dateDebut;

    @Column(name = "date_fin")
    private LocalDate dateFin;

    private String description;
}