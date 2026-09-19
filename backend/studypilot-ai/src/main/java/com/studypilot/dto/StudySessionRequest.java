package com.studypilot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudySessionRequest {

    @NotNull
    private Long studyDayId;

    @NotBlank
    private String topic;

    @Min(1)
    private int durationMinutes;

    public StudySessionRequest() {
    }

    public Long getStudyDayId() {
        return studyDayId;
    }

    public void setStudyDayId(Long studyDayId) {
        this.studyDayId = studyDayId;
    }

    public String getTopic() {
        return topic;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public int getDurationMinutes() {
        return durationMinutes;
    }

    public void setDurationMinutes(int durationMinutes) {
        this.durationMinutes = durationMinutes;
    }
}