package com.enaaskills.backend.controller;

import com.enaaskills.backend.model.SubSkill;
import com.enaaskills.backend.repository.SubSkillRepository;
import com.enaaskills.backend.service.SubSkillService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/sub-skill")
public class SubSkillController {

   private final SubSkillService subSkillService;

   public SubSkillController (
           final SubSkillService subSkillService
   ) {
       this.subSkillService = subSkillService;
   }

    @GetMapping
    public ResponseEntity<?> getAllSubSkills () {

        return subSkillService.listSubSkills();
    }

}










