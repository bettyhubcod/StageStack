package com.StageTrack.app.controller;

import com.StageTrack.app.DTO.StageDTO;
import com.StageTrack.app.repository.EntrepriseRepository;
import com.StageTrack.app.repository.MaitreStageRepository;
import com.StageTrack.app.service.StageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StageController {

    private final StageService stageService;
    private final EntrepriseRepository entrepriseRepository;
    private final MaitreStageRepository maitreStageRepository;

    public StageController(StageService stageService,
                           EntrepriseRepository entrepriseRepository,
                           MaitreStageRepository maitreStageRepository) {
        this.stageService = stageService;
        this.entrepriseRepository = entrepriseRepository;
        this.maitreStageRepository = maitreStageRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("stages", stageService.tousLesStages());
        model.addAttribute("stageDTO", new StageDTO());
        model.addAttribute("entreprises", entrepriseRepository.findAll());
        model.addAttribute("maitresStage", maitreStageRepository.findAll());
        return "home";
    }

    @PostMapping("/stages/creer")
    public String creerStage(@ModelAttribute StageDTO stageDTO) {
        stageService.creerDepuisDTO(stageDTO);
        return "redirect:/";
    }
}