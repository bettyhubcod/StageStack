package com.StageTrack.app.domain;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "maitres_stage")
@Data
public class MaitreStage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @Column(nullable = true)
    private String mail;

    @Column(nullable = false)
    private String poste;

    @ManyToOne
    @JoinColumn(name = "entreprise_id", nullable = false)
    private Entreprise entreprise;
}