package com.studypilot.service;

import com.studypilot.entity.Quiz;
import com.studypilot.entity.QuizAttempt;
import com.studypilot.entity.User;
import com.studypilot.repository.QuizAttemptRepository;
import com.studypilot.repository.QuizRepository;
import com.studypilot.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class QuizAttemptService {

    private final QuizAttemptRepository quizAttemptRepository;
    private final UserRepository userRepository;
    private final QuizRepository quizRepository;

    public QuizAttemptService(QuizAttemptRepository quizAttemptRepository,
                              UserRepository userRepository,
                              QuizRepository quizRepository) {
        this.quizAttemptRepository = quizAttemptRepository;
        this.userRepository = userRepository;
        this.quizRepository = quizRepository;
    }

    public QuizAttempt submitAttempt(Long userId,
                                     Long quizId,
                                     int score,
                                     int totalQuestions) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Quiz quiz = quizRepository.findById(quizId)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));

        QuizAttempt attempt = new QuizAttempt();

        attempt.setScore(score);
        attempt.setTotalQuestions(totalQuestions);
        attempt.setAttemptedAt(LocalDateTime.now());
        attempt.setUser(user);
        attempt.setQuiz(quiz);

        return quizAttemptRepository.save(attempt);
    }

    public List<QuizAttempt> getUserAttempts(Long userId) {
        return quizAttemptRepository.findByUserId(userId);
    }

    public List<QuizAttempt> getQuizAttempts(Long quizId) {
        return quizAttemptRepository.findByQuizId(quizId);
    }
}