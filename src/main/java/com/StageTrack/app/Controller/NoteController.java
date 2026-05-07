package com.StageTrack.app.Controller;

import com.StageTrack.app.DTO.NoteRequest;
import com.StageTrack.app.DTO.NoteResponse;
import com.StageTrack.app.Service.NoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notes")
@RequiredArgsConstructor
public class NoteController {

    private final NoteService noteService;

    // CREATE
    @PostMapping
    public ResponseEntity<NoteResponse> creer(@Valid @RequestBody NoteRequest request) {
        return ResponseEntity.ok(noteService.creer(request));
    }

    // READ ONE
    @GetMapping("/{id}")
    public ResponseEntity<NoteResponse> recupererParId(@PathVariable Long id) {
        return ResponseEntity.ok(noteService.recupererParId(id));
    }

    // READ ALL
    @GetMapping
    public ResponseEntity<List<NoteResponse>> recupererToutesLesNotes() {
        return ResponseEntity.ok(noteService.recupererToutesLesNotes());
    }

    // UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<NoteResponse> modifier(@PathVariable Long id,
                                                 @Valid @RequestBody NoteRequest request) {
        return ResponseEntity.ok(noteService.modifier(id, request));
    }

    // DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> supprimer(@PathVariable Long id) {
        noteService.supprimer(id);
        return ResponseEntity.noContent().build();
    }
}


