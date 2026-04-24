package com.StageTrack.app.repository;

import com.StageTrack.app.domain.Stage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StageRepository extends JpaRepository<Stage, Long> {
    // JpaRepository nous donne déjà gratuitement :
    // save()      → sauvegarder un stage
    // findAll()   → récupérer tous les stages
    // findById()  → trouver un stage par id
    // delete()    → supprimer un stage
    // On n'a rien à écrire pour l'instant !
}