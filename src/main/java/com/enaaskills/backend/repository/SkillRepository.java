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

    @Query(value = "select\n" +
            "\tskills.name,\n" +
            "\tcount(*)    \n" +
            "from skills\n" +
            "inner join sub_skills\n" +
            "on skills.id = sub_skills.skill_id\n" +
            "where sub_skills.is_valid = 1\n" +
            "group by skills.name;", nativeQuery = true)
    public List<Skill> countValiatedSubSkillsBySkill();

}
