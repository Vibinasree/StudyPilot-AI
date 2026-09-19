package com.studypilot.service;

import com.studypilot.dto.StudyPlanRequest;
import com.studypilot.entity.StudyPlan;
import com.studypilot.entity.User;
import com.studypilot.repository.StudyPlanRepository;
import com.studypilot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudyPlanService {

    private final StudyPlanRepository studyPlanRepository;
    private final UserRepository userRepository;

    public StudyPlanService(StudyPlanRepository studyPlanRepository,
                            UserRepository userRepository) {
        this.studyPlanRepository = studyPlanRepository;
        this.userRepository = userRepository;
    }

    public StudyPlan createPlan(Long userId, StudyPlanRequest request) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        StudyPlan plan = new StudyPlan();

        plan.setTitle(request.getTitle());
        plan.setDescription(request.getDescription());
        plan.setStartDate(request.getStartDate());
        plan.setEndDate(request.getEndDate());
        plan.setUser(user);

        return studyPlanRepository.save(plan);
    }

    public List<StudyPlan> getUserPlans(Long userId) {
        return studyPlanRepository.findByUserId(userId);
    }

    public StudyPlan getPlanById(Long id) {
        return studyPlanRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Study plan not found"));
    }

    public StudyPlan updatePlan(Long id, StudyPlanRequest request) {

        StudyPlan plan = getPlanById(id);

        plan.setTitle(request.getTitle());
        plan.setDescription(request.getDescription());
        plan.setStartDate(request.getStartDate());
        plan.setEndDate(request.getEndDate());

        return studyPlanRepository.save(plan);
    }

    public void deletePlan(Long id) {

        StudyPlan plan = getPlanById(id);
        studyPlanRepository.delete(plan);
    }
}