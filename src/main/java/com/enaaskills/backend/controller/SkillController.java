package com.enaaskills.backend.controller;


import com.enaaskills.backend.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

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


}



















