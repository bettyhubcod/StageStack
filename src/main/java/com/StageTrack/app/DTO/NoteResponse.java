package com.StageTrack.app.DTO;

import jakarta.persistence.Entity;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
public class NoteResponse {
    private Long id;
    private String fait;
    private String appris;
    private String probleme;
    private String solution;
    private String plus;
    private LocalDate date;
    private Long stageId;
}
