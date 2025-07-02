package com.enaaskills.backend.repository;

import com.enaaskills.backend.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SkillRepository extends JpaRepository<Skill, Long> {

    @Query(value = "SELECT s FROM Skill s LEFT JOIN FETCH s.subSkills")
    public List<Skill> findSkillsWithSubSkills();

}
