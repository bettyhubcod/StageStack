package com.StageTrack.app.Service;

import com.StageTrack.app.DTO.NoteRequest;
import com.StageTrack.app.DTO.NoteResponse;
import com.StageTrack.app.Repository.NoteRepository;
import com.StageTrack.app.domain.Note;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
