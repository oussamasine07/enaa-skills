package com.enaaskills.backend.controller;


import com.enaaskills.backend.dto.validationDTO.ValidateSkillDTO;
import com.enaaskills.backend.model.Skill;
import com.enaaskills.backend.service.SkillService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController (
            final SkillService skillService
    ) {
        this.skillService = skillService;
    }

    @GetMapping
    public ResponseEntity<?> index () {
        return skillService.listSkills();
    }

    @PostMapping
    public ResponseEntity<?> newSkill (@Valid @RequestBody ValidateSkillDTO validateSkillDTO) {
        Skill newSkill = new Skill();
        newSkill.setName(validateSkillDTO.name());

        return skillService.createSkill( newSkill );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getSkillById ( @PathVariable Long id ) {
        return skillService.getSkillById( id );
    }

}



















