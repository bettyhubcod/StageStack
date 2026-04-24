package com.StageTrack.app.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pieces_jointes")
@Data
public class PieceJointe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String urlFichier;

    @Column(nullable = false)
    private String typeFichier; // IMAGE / VIDEO / AUDIO / DOCUMENT

    @Column(nullable = false)
    private String nomFichier;

    @ManyToOne
    @JoinColumn(name = "note_id", nullable = false)
    private Note note;
}