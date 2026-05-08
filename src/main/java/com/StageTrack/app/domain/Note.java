package com.StageTrack.app.domain;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

@Entity
@Table(name = "notes")
@Data
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String fait;

    @Column(nullable = false)
    private String appris;

    @Column(nullable = true)
    private String probleme;

    @Column(nullable = true)
    private String solution;

    @Column(nullable = true)
    private String plus;

    @Column(nullable = false)
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "stage_id", nullable = true)
    private Stage stage;
}