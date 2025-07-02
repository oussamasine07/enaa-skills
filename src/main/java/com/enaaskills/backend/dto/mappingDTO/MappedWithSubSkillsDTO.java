package com.enaaskills.backend.dto.mappingDTO;

import java.util.List;

public record MappedWithSubSkillsDTO(
        Long id,
        String name,
        List<MappedSubSkillDTO> subSkills
) {

}
