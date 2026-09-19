package com.studypilot.service;

import com.studypilot.entity.StudyDay;
import com.studypilot.entity.StudyPlan;
import com.studypilot.repository.StudyDayRepository;
import com.studypilot.repository.StudyPlanRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class StudyDayService {

    private final StudyDayRepository studyDayRepository;
    private final StudyPlanRepository studyPlanRepository;

    public StudyDayService(StudyDayRepository studyDayRepository,
                           StudyPlanRepository studyPlanRepository) {
        this.studyDayRepository = studyDayRepository;
        this.studyPlanRepository = studyPlanRepository;
    }

    public StudyDay createStudyDay(Long studyPlanId, LocalDate studyDate) {

        StudyPlan plan = studyPlanRepository.findById(studyPlanId)
                .orElseThrow(() -> new RuntimeException("Study plan not found"));

        StudyDay studyDay = new StudyDay();
        studyDay.setStudyDate(studyDate);
        studyDay.setCompleted(false);
        studyDay.setStudyPlan(plan);

        return studyDayRepository.save(studyDay);
    }

    public List<StudyDay> getStudyDays(Long studyPlanId) {
        return studyDayRepository.findByStudyPlanId(studyPlanId);
    }

    public StudyDay getStudyDayById(Long id) {
        return studyDayRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Study day not found"));
    }

    public StudyDay markCompleted(Long id) {

        StudyDay studyDay = getStudyDayById(id);
        studyDay.setCompleted(true);

        return studyDayRepository.save(studyDay);
    }
}