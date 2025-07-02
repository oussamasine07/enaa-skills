package com.enaaskills.backend.service;

import com.enaaskills.backend.dto.mappingDTO.MappedSubSkillDTO;
import com.enaaskills.backend.mapper.SubSkillMapper;
import com.enaaskills.backend.model.SubSkill;
import com.enaaskills.backend.repository.SkillRepository;
import com.enaaskills.backend.repository.SubSkillRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubSkillService {

    private final SubSkillRepository subSkillRepository;
    private final SubSkillMapper subSkillMapper;

    public SubSkillService (
            final SubSkillRepository subSkillRepository,
            final SubSkillMapper subSkillMapper
    ) {
        this.subSkillRepository = subSkillRepository;
        this.subSkillMapper = subSkillMapper;
    }

    public ResponseEntity<?> listSubSkills () {
        List<MappedSubSkillDTO> subSkills =  subSkillRepository.findAll()
                .stream()
                .map(subSkillMapper::toDTO)
                .collect(Collectors.toList());

        return new ResponseEntity<>( subSkills, HttpStatus.OK);
    }

    public ResponseEntity<?> createSubSkill ( SubSkill subSkill ) {
        SubSkill newSubSkill = subSkillRepository.save( subSkill );
        return new ResponseEntity<>(newSubSkill, HttpStatus.OK);
    }

}












