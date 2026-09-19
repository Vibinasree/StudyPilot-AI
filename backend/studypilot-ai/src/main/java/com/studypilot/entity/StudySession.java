package com.studypilot.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "study_sessions")
public class StudySession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String topic;

    private int durationMinutes;

    private LocalDateTime startedAt;

    private LocalDateTime endedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "study_day_id", nullable = false)
    private StudyDay studyDay;

    public StudySession() {
    }

    public StudySession(String topic, int durationMinutes,
                        LocalDateTime startedAt, StudyDay studyDay) {
        this.topic = topic;
        this.durationMinutes = durationMinutes;
        this.startedAt = startedAt;
        this.studyDay = studyDay;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDateTime getStartedAt() {
        return startedAt;
    }

    public void setStartedAt(LocalDateTime startedAt) {
        this.startedAt = startedAt;
    }

    public LocalDateTime getEndedAt() {
        return endedAt;
    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;
    }

    public StudyDay getStudyDay() {
        return studyDay;
    }

    public void setStudyDay(StudyDay studyDay) {
        this.studyDay = studyDay;
    }
}