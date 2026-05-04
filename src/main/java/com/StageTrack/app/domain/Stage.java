package com.StageTrack.app.domain;
import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDate;

public class Stage {

    private Long id;

    @Column(nullable = false)

    private LocalDate dateDebut;

    private LocalDate dateFin;

}