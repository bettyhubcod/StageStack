package com.StageTrack.app.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "stages")
public class Stage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String poste;

    @Column(nullable = false)
    private LocalDate dateDebut;

    @Column(nullable = false)
    private LocalDate dateFin;

    private String description;

    @Column(nullable = false)
    private String statut;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;

    @ManyToOne
    @JoinColumn(name = "maitre_stage_id")
    private MaitreStage maitreStage;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
    private List<Note> notes;

    @OneToMany(mappedBy = "stage", cascade = CascadeType.ALL)
    private List<Projet> projets;
}