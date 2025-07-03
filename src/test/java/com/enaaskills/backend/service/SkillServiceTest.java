package com.enaaskills.backend.service;

import com.enaaskills.backend.dto.mappingDTO.MappedSubSkillDTO;
import com.enaaskills.backend.dto.mappingDTO.MappedWithSubSkillsDTO;
import com.enaaskills.backend.mapper.SkillMapper;
import com.enaaskills.backend.mapper.SkillMapperWithSubSkills;
import com.enaaskills.backend.model.Skill;
import com.enaaskills.backend.repository.SkillRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class SkillServiceTest {

    @Mock
    SkillRepository skillRepository;

    @Mock
    SkillMapper skillMapper;

    @Mock
    SkillMapperWithSubSkills skillMapperWithSubSkills;

    @InjectMocks
    private SkillService skillService;

    @Test
    public void getAllSkills () {
        Skill skill1 = new Skill();
        skill1.setName("C4");

        Skill skill2 = new Skill();
        skill2.setName("C5");

        List<Skill> skills = List.of(skill1, skill2);

        // mock subSkill DTO
        MappedSubSkillDTO sub1 = new MappedSubSkillDTO(1L, "sub 1");
        MappedSubSkillDTO sub2 = new MappedSubSkillDTO(2L, "sub 2");

        // mock skill DTO
        MappedWithSubSkillsDTO mappedWithSubSkillsDTO1 = new MappedWithSubSkillsDTO(1L, "skill 1", List.of(sub1));
        MappedWithSubSkillsDTO mappedWithSubSkillsDTO2 = new MappedWithSubSkillsDTO(2L, "skill 2", List.of(sub2));

        when(skillRepository.findAll()).thenReturn(skills);
        when(skillMapperWithSubSkills.toDTO(skill1)).thenReturn(mappedWithSubSkillsDTO1);
        when(skillMapperWithSubSkills.toDTO(skill2)).thenReturn(mappedWithSubSkillsDTO2);

        ResponseEntity<?> result = skillService.listSkills();

        assertEquals(HttpStatus.OK, result.getStatusCode());



    }



}
