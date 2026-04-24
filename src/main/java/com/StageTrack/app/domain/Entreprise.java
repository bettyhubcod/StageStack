package com.StageTrack.app.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "entreprises")
@Data
public class Entreprise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nomEntreprise;

    @Column(nullable = false)
    private String adresseEntreprise;

    @Column(nullable = false)
    private String secteurActivite;
}