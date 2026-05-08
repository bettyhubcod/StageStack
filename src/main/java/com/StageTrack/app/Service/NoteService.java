package com.StageTrack.app.Service;

import com.StageTrack.app.DTO.NoteRequest;
import com.StageTrack.app.DTO.NoteResponse;
import com.StageTrack.app.Repository.NoteRepository;
import com.StageTrack.app.domain.Note;
import com.StageTrack.app.domain.Stage;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor

public class NoteService {
    private final NoteRepository noteRepository;

    public NoteResponse creer(NoteRequest request) {



        Note note = new Note();


        note.setFait(request.getFait());
        note.setAppris(request.getAppris());
        note.setProbleme(request.getProbleme());
        note.setSolution(request.getSolution());
        note.setPlus(request.getPlus());
        note.setDate(request.getDate());


        Note saved = noteRepository.save(note);


        return toResponse(saved);
    }

    public NoteResponse recupererParId(Long id) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"));
        return toResponse(note);
    }
    public List<NoteResponse> recupererToutesLesNotes() {

        // 1. Je récupère toutes les notes de la DB
        List<Note> notes = noteRepository.findAll();

        // 2. Je crée une liste vide de réponses
        List<NoteResponse> responses = new ArrayList<>();

        // 3. Pour chaque note je convertis et j'ajoute dans la liste
        for (Note note : notes) {
            NoteResponse response = toResponse(note);
            responses.add(response);
        }

        // 4. Je renvoie la liste
        return responses;
    }

    public NoteResponse modifier(Long id, NoteRequest request) {
        Note note = noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"));

        note.setFait(request.getFait());
        note.setAppris(request.getAppris());
        note.setProbleme(request.getProbleme());
        note.setSolution(request.getSolution());
        note.setPlus(request.getPlus());
        note.setDate(request.getDate());

        return toResponse(noteRepository.save(note));
    }

    public void supprimer(Long id) {
        noteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Note introuvable"));
        noteRepository.deleteById(id);
    }



    private NoteResponse toResponse(Note note) {
        NoteResponse response = new NoteResponse();
        response.setId(note.getId());
        response.setFait(note.getFait());
        response.setAppris(note.getAppris());
        response.setProbleme(note.getProbleme());
        response.setSolution(note.getSolution());
        response.setPlus(note.getPlus());
        response.setDate(note.getDate());
        return response;
    }

}
