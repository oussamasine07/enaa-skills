package com.enaaskills.backend.dto.validationDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ValidateSubSkillDTO(
        @NotBlank(message = "sub skill name is required")
        String name,

        @NotNull(message = "skill is required")
        Long skill_id,

        Boolean isValic
) {
}
