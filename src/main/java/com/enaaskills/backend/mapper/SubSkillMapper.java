package com.enaaskills.backend.mapper;

import com.enaaskills.backend.dto.mappingDTO.MappedSubSkillDTO;
import com.enaaskills.backend.model.SubSkill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SubSkillMapper {
    SubSkill toEntity(MappedSubSkillDTO mappedSubSkillDTO);
    MappedSubSkillDTO toDTO( SubSkill subSkill );
}
