package com.studypilot.service;

import com.studypilot.entity.Quiz;
import com.studypilot.entity.QuizAnswer;
import com.studypilot.entity.Topic;
import com.studypilot.repository.QuizAnswerRepository;
import com.studypilot.repository.QuizRepository;
import com.studypilot.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuizService {

    private final QuizRepository quizRepository;
    private final QuizAnswerRepository quizAnswerRepository;
    private final TopicRepository topicRepository;

    public QuizService(QuizRepository quizRepository,
                       QuizAnswerRepository quizAnswerRepository,
                       TopicRepository topicRepository) {
        this.quizRepository = quizRepository;
        this.quizAnswerRepository = quizAnswerRepository;
        this.topicRepository = topicRepository;
    }

    public Quiz createQuiz(Long topicId, String title, String description) {

        Topic topic = topicRepository.findById(topicId)
                .orElseThrow(() -> new RuntimeException("Topic not found"));

        Quiz quiz = new Quiz();
        quiz.setTitle(title);
        quiz.setDescription(description);
        quiz.setTopic(topic);

        return quizRepository.save(quiz);
    }

    public List<Quiz> getQuizzesByTopic(Long topicId) {
        return quizRepository.findByTopicId(topicId);
    }

    public Quiz getQuizById(Long id) {
        return quizRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Quiz not found"));
    }

    public QuizAnswer addQuestion(Long quizId,
                                  String question,
                                  String selectedAnswer,
                                  String correctAnswer) {

        Quiz quiz = getQuizById(quizId);

        QuizAnswer answer = new QuizAnswer();
        answer.setQuestion(question);
        answer.setSelectedAnswer(selectedAnswer);
        answer.setCorrectAnswer(correctAnswer);
        answer.setQuiz(quiz);

        return quizAnswerRepository.save(answer);
    }

    public List<QuizAnswer> getQuestions(Long quizId) {
        return quizAnswerRepository.findByQuizId(quizId);
    }
}