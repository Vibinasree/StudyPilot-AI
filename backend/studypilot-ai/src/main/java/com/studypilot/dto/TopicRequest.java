package com.studypilot.dto;

import jakarta.validation.constraints.NotBlank;

public class TopicRequest {

    @NotBlank
    private String name;

    private String description;

    @NotBlank
    private String difficulty;

    public TopicRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }
}