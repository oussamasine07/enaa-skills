package com.enaaskills.backend.service;

import com.enaaskills.backend.model.SubSkill;
import com.enaaskills.backend.repository.SkillRepository;
import com.enaaskills.backend.repository.SubSkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubSkillService {

    private final SubSkillRepository subSkillRepository;

    public SubSkillService (
            final SubSkillRepository subSkillRepository
    ) {
        this.subSkillRepository = subSkillRepository;
    }

    public ResponseEntity<?> listSubSkills () {
        List<SubSkill> subSkills =  subSkillRepository.findAll();

        return new ResponseEntity<>( subSkills, HttpStatus.OK);
    }

    public ResponseEntity<?> createSubSkill ( SubSkill subSkill ) {
        SubSkill newSubSkill = subSkillRepository.save( subSkill );
        return new ResponseEntity<>(newSubSkill, HttpStatus.OK);
    }

}












