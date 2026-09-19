package com.studypilot.controller;

import com.studypilot.dto.StudyPlanRequest;
import com.studypilot.entity.StudyPlan;
import com.studypilot.service.StudyPlanService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/study-plans")
public class StudyPlanController {

    private final StudyPlanService studyPlanService;

    public StudyPlanController(StudyPlanService studyPlanService) {
        this.studyPlanService = studyPlanService;
    }

    @PostMapping("/user/{userId}")
    public ResponseEntity<StudyPlan> createPlan(
            @PathVariable Long userId,
            @Valid @RequestBody StudyPlanRequest request) {

        return ResponseEntity.ok(
                studyPlanService.createPlan(userId, request)
        );
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<StudyPlan>> getUserPlans(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                studyPlanService.getUserPlans(userId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudyPlan> getPlan(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studyPlanService.getPlanById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<StudyPlan> updatePlan(
            @PathVariable Long id,
            @Valid @RequestBody StudyPlanRequest request) {

        return ResponseEntity.ok(
                studyPlanService.updatePlan(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlan(
            @PathVariable Long id) {

        studyPlanService.deletePlan(id);

        return ResponseEntity.noContent().build();
    }
}