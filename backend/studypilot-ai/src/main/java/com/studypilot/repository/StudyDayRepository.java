package com.studypilot.repository;

import com.studypilot.entity.StudyDay;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudyDayRepository extends JpaRepository<StudyDay, Long> {

    List<StudyDay> findByStudyPlanId(Long studyPlanId);
}