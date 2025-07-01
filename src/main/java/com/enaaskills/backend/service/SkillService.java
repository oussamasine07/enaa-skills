package com.enaaskills.backend.service;

import com.enaaskills.backend.exception.NotFoundException;
import com.enaaskills.backend.model.Skill;
import com.enaaskills.backend.repository.SkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SkillService {

    private final SkillRepository skillRepository;

    public SkillService (
            final SkillRepository skillRepository
    ) {
        this.skillRepository = skillRepository;
    }

    public ResponseEntity<?> listSkills () {
        List<Skill> skills = skillRepository.findAll();

        return new ResponseEntity<>(skills, HttpStatus.OK);
    }

    public ResponseEntity<?> getSkillById( Long skillId ) {
        Skill skill = skillRepository.findById( skillId )
                .orElseThrow(() -> new NotFoundException("this skill is not found"));

        return new ResponseEntity<>(skill, HttpStatus.OK);
    }

    public ResponseEntity<?> createSkill ( Skill skill ) {
        return new ResponseEntity<>(skillRepository.save( skill ), HttpStatus.OK);
    }

    public ResponseEntity<?> updateSkill (Skill skill, Long skillId ) {
        Skill updatedSkill = skillRepository.findById( skillId )
                .orElseThrow(() -> new NotFoundException("you can't update an unfound skill"));

        updatedSkill.setName( skill.getName() );

        return new ResponseEntity<>(skillRepository.save( updatedSkill ), HttpStatus.OK);
    }

    public ResponseEntity<?> deleteSkill ( Long skillId ) {
        Skill deletedSkill = skillRepository.findById( skillId )
                .orElseThrow(() -> new NotFoundException("you can't delete an unfound skill"));

        Map<String, String> success = new HashMap<>();
        success.put("status", "success");
        success.put("message", "skill: " + deletedSkill.getName() + " was deleted Successfully");

        skillRepository.deleteById( skillId );

        return new ResponseEntity<>( success, HttpStatus.OK );

    }

}
