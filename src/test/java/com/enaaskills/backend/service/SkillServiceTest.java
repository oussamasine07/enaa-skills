package com.enaaskills.backend.service;

import com.enaaskills.backend.dto.mappingDTO.MappedSubSkillDTO;
import com.enaaskills.backend.mapper.SkillMapper;
import com.enaaskills.backend.model.Skill;
import com.enaaskills.backend.repository.SkillRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {

    @Mock
    SkillRepository skillRepository;

    @Mock
    SkillMapper skillMapper;

    @InjectMocks
    private SkillService skillService;

    @Test
    void getAllSkills () {
        Skill skill1 = new Skill();
        skill1.setName("C4");

        Skill skill2 = new Skill();
        skill2.setName("C5");

        List<Skill> skills = List.of(skill1, skill2);

        lenient().when(skillRepository.findAll()).thenReturn(skills);

        ResponseEntity result = skillService.listSkills();

        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void getSkillById () {
        Skill skill = new Skill();
        skill.setId(1L);
        skill.setName("C4");

        lenient().when(skillRepository.findById(1L)).thenReturn(Optional.of(skill));

        ResponseEntity result = skillService.getSkillById(1L);

        assertEquals(HttpStatus.OK, result.getStatusCode());

    }

    @Test
    void createSkill () {
        Skill skill = new Skill();
        skill.setId(1L);
        skill.setName("C4");

        when(skillRepository.save(any(Skill.class))).thenReturn(skill);

        ResponseEntity<Skill> result = (ResponseEntity<Skill>) skillService.createSkill( skill );

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("C4", result.getBody().getName());

    }

    @Test
    void updateSkill () {
        Skill skill = new Skill();
        skill.setId(1L);
        skill.setName("C4");

        Skill updatedSkill = new Skill();
        updatedSkill.setId(1L);
        updatedSkill.setName("new skill");

        lenient().when(skillRepository.findById(1L)).thenReturn(Optional.of(skill));
        when(skillRepository.save(any(Skill.class))).thenAnswer(invocationOnMock -> invocationOnMock.getArgument(0));

        ResponseEntity<Skill> result = (ResponseEntity<Skill>) skillService.updateSkill(updatedSkill,1L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("new skill", result.getBody().getName());
    }

    @Test
    void deleteSkill () {
        Skill skill = new Skill();
        skill.setId(1L);
        skill.setName("C4");
        lenient().when(skillRepository.findById(1L)).thenReturn(Optional.of(skill));
        doNothing().when(skillRepository).deleteById(1L);

        ResponseEntity<Map<String, String>> result = (ResponseEntity<Map<String, String>>) skillService.deleteSkill(1L);

        assertEquals(HttpStatus.OK, result.getStatusCode());
        assertEquals("success", result.getBody().get("status"));

    }



}
