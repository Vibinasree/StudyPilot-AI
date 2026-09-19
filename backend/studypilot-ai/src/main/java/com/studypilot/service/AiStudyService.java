package com.studypilot.service;

import com.studypilot.dto.AiStudyRequest;
import org.springframework.stereotype.Service;

@Service
public class AiStudyService {

    public String generateStudyContent(AiStudyRequest request) {

        String topic = request.getTopic();
        String question = request.getQuestion();
        String difficulty = request.getDifficulty();

        return """
                Study Topic: %s

                Difficulty: %s

                Question:
                %s

                AI-generated study content will be connected here.
                """.formatted(topic, difficulty, question);
    }
}