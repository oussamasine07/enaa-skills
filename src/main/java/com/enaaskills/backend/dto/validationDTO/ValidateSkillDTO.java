package com.enaaskills.backend.dto.validationDTO;

import jakarta.validation.constraints.NotBlank;

public record ValidateSkillDTO(
        @NotBlank(message = "skill name field is required")
        String name
) {
}
