package com.studypilot.controller;

import com.studypilot.dto.StudySessionRequest;
import com.studypilot.entity.StudySession;
import com.studypilot.service.StudyDayService;
import com.studypilot.service.StudySessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/study")
public class StudySessionController {

    private final StudySessionService studySessionService;
    private final StudyDayService studyDayService;

    public StudySessionController(
            StudySessionService studySessionService,
            StudyDayService studyDayService) {

        this.studySessionService = studySessionService;
        this.studyDayService = studyDayService;
    }

    @PostMapping("/days/{studyPlanId}")
    public ResponseEntity<?> createStudyDay(
            @PathVariable Long studyPlanId,
            @RequestParam LocalDate studyDate) {

        return ResponseEntity.ok(
                studyDayService.createStudyDay(
                        studyPlanId,
                        studyDate
                )
        );
    }

    @GetMapping("/days/{studyPlanId}")
    public ResponseEntity<?> getStudyDays(
            @PathVariable Long studyPlanId) {

        return ResponseEntity.ok(
                studyDayService.getStudyDays(studyPlanId)
        );
    }

    @PutMapping("/days/{id}/complete")
    public ResponseEntity<?> completeStudyDay(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studyDayService.markCompleted(id)
        );
    }

    @PostMapping("/sessions")
    public ResponseEntity<StudySession> createSession(
            @RequestBody StudySessionRequest request) {

        return ResponseEntity.ok(
                studySessionService.createSession(request)
        );
    }

    @PutMapping("/sessions/{id}/end")
    public ResponseEntity<StudySession> endSession(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                studySessionService.endSession(id)
        );
    }

    @GetMapping("/sessions/day/{studyDayId}")
    public ResponseEntity<List<StudySession>> getSessions(
            @PathVariable Long studyDayId) {

        return ResponseEntity.ok(
                studySessionService.getSessions(studyDayId)
        );
    }
}