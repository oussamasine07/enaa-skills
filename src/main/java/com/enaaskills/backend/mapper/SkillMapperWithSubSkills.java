package com.enaaskills.backend.mapper;

import com.enaaskills.backend.dto.mappingDTO.MappedWithSubSkillsDTO;
import com.enaaskills.backend.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {SubSkillMapper.class})
public interface SkillMapperWithSubSkills {

    Skill toEntity ( MappedWithSubSkillsDTO mappedSkillDTO );
    MappedWithSubSkillsDTO toDTO(Skill skill );

}
