package com.enaaskills.backend.mapper;

import com.enaaskills.backend.dto.mappingDTO.MappedSkillDTO;
import com.enaaskills.backend.model.Skill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SkillMapper {
    Skill toEntity(MappedSkillDTO mappedSkillDTO);
    MappedSkillDTO toDTO( Skill skill );
}
