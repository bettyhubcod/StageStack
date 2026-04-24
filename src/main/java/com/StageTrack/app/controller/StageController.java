package com.StageTrack.app.controller;

import com.StageTrack.app.domain.Stage;
import com.StageTrack.app.service.StageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StageController {

    private final StageService stageService;

    public StageController(StageService stageService) {
        this.stageService = stageService;
    }

    // Affiche la page home avec la liste des stages
    @GetMapping("/")
    public String home(Model model) {
        // On envoie la liste des stages à la page HTML
        model.addAttribute("stages", stageService.tousLesStages());
        // On prépare un objet vide pour le formulaire
        model.addAttribute("stage", new Stage());
        return "home";
    }

    // Reçoit les données du formulaire quand on clique "Créer le stage"
    @PostMapping("/stages/creer")
    public String creerStage(@ModelAttribute Stage stage) {
        stageService.sauvegarder(stage);
        return "redirect:/";  // Redirige vers la page home après création
    }
}