package com.StageTrack.app.DTO;

import lombok.Data;
import java.time.LocalDate;

@Data
public class NoteRequest {
    private String fait;
    private String appris;
    private String probleme;
    private String solution;
    private String plus;
    private LocalDate date;
    private Long stageId;
}