package com.StageTrack.app.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "etablissements")
@Data

public class Etablissement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String adresse;

    @Column(nullable = false)
    private String diplome;
}
