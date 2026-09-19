package com.studypilot.controller;

import com.studypilot.dto.AiStudyRequest;
import com.studypilot.service.AiStudyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/ai")
public class AiStudyController {

    private final AiStudyService aiStudyService;

    public AiStudyController(AiStudyService aiStudyService) {
        this.aiStudyService = aiStudyService;
    }

    @PostMapping("/study")
    public ResponseEntity<String> generateStudyContent(
            @Valid @RequestBody AiStudyRequest request) {

        return ResponseEntity.ok(
                aiStudyService.generateStudyContent(request)
        );
    }
}