package com.enaaskills.backend.service;

import com.enaaskills.backend.model.SubSkill;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SubSkillServiceTest {

    @Autowired
    private SubSkillService subSkillService;

    @Test
    void listSubSkills() {

        SubSkill subSkill = new SubSkill();
        subSkill.setName("subskill one");

        ResponseEntity<SubSkill> createSubSkill = (ResponseEntity<SubSkill>) subSkillService.createSubSkill( subSkill );

        ResponseEntity<SubSkill> subSkills = (ResponseEntity<SubSkill>) subSkillService.listSubSkills();
        assertNotNull( subSkills );

    }

    @Test
    void createSubSkill() {

        SubSkill subSkill = new SubSkill();
        subSkill.setName("subskill one");

        ResponseEntity<SubSkill> createSubSkill = (ResponseEntity<SubSkill>) subSkillService.createSubSkill( subSkill );

        assertEquals(HttpStatus.OK, createSubSkill.getStatusCode());
    }
}
















