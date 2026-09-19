package com.studypilot.controller;

import com.studypilot.entity.Quiz;
import com.studypilot.entity.QuizAnswer;
import com.studypilot.entity.QuizAttempt;
import com.studypilot.service.QuizAttemptService;
import com.studypilot.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
public class QuizController {

    private final QuizService quizService;
    private final QuizAttemptService quizAttemptService;

    public QuizController(
            QuizService quizService,
            QuizAttemptService quizAttemptService) {

        this.quizService = quizService;
        this.quizAttemptService = quizAttemptService;
    }

    @PostMapping("/topic/{topicId}")
    public ResponseEntity<Quiz> createQuiz(
            @PathVariable Long topicId,
            @RequestParam String title,
            @RequestParam String description) {

        return ResponseEntity.ok(
                quizService.createQuiz(
                        topicId,
                        title,
                        description
                )
        );
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<Quiz>> getQuizzes(
            @PathVariable Long topicId) {

        return ResponseEntity.ok(
                quizService.getQuizzesByTopic(topicId)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Quiz> getQuiz(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                quizService.getQuizById(id)
        );
    }

    @PostMapping("/{quizId}/questions")
    public ResponseEntity<QuizAnswer> addQuestion(
            @PathVariable Long quizId,
            @RequestParam String question,
            @RequestParam String selectedAnswer,
            @RequestParam String correctAnswer) {

        return ResponseEntity.ok(
                quizService.addQuestion(
                        quizId,
                        question,
                        selectedAnswer,
                        correctAnswer
                )
        );
    }

    @GetMapping("/{quizId}/questions")
    public ResponseEntity<List<QuizAnswer>> getQuestions(
            @PathVariable Long quizId) {

        return ResponseEntity.ok(
                quizService.getQuestions(quizId)
        );
    }

    @PostMapping("/{quizId}/attempt")
    public ResponseEntity<QuizAttempt> submitAttempt(
            @PathVariable Long quizId,
            @RequestParam Long userId,
            @RequestParam int score,
            @RequestParam int totalQuestions) {

        return ResponseEntity.ok(
                quizAttemptService.submitAttempt(
                        userId,
                        quizId,
                        score,
                        totalQuestions
                )
        );
    }

    @GetMapping("/attempts/user/{userId}")
    public ResponseEntity<List<QuizAttempt>> getUserAttempts(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                quizAttemptService.getUserAttempts(userId)
        );
    }

    @GetMapping("/attempts/quiz/{quizId}")
    public ResponseEntity<List<QuizAttempt>> getQuizAttempts(
            @PathVariable Long quizId) {

        return ResponseEntity.ok(
                quizAttemptService.getQuizAttempts(quizId)
        );
    }
}