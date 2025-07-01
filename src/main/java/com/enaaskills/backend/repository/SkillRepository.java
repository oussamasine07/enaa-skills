package com.enaaskills.backend.repository;

import com.enaaskills.backend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {

}
