package com.studypilot.dto;

import jakarta.validation.constraints.NotBlank;

public class AiStudyRequest {

    @NotBlank
    private String topic;

    private String question;

    private String difficulty;

    public AiStudyRequest() {
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}