package com.studypilot.service;

import com.studypilot.dto.StudySessionRequest;
import com.studypilot.entity.StudyDay;
import com.studypilot.entity.StudySession;
import com.studypilot.repository.StudyDayRepository;
import com.studypilot.repository.StudySessionRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudySessionService {

    private final StudySessionRepository studySessionRepository;
    private final StudyDayRepository studyDayRepository;

    public StudySessionService(StudySessionRepository studySessionRepository,
                               StudyDayRepository studyDayRepository) {
        this.studySessionRepository = studySessionRepository;
        this.studyDayRepository = studyDayRepository;
    }

    public StudySession createSession(StudySessionRequest request) {

        StudyDay studyDay = studyDayRepository.findById(request.getStudyDayId())
                .orElseThrow(() -> new RuntimeException("Study day not found"));

        StudySession session = new StudySession();

        session.setTopic(request.getTopic());
        session.setDurationMinutes(request.getDurationMinutes());
        session.setStartedAt(LocalDateTime.now());
        session.setStudyDay(studyDay);

        return studySessionRepository.save(session);
    }

    public StudySession endSession(Long id) {

        StudySession session = studySessionRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Study session not found"));

        session.setEndedAt(LocalDateTime.now());

        return studySessionRepository.save(session);
    }

    public List<StudySession> getSessions(Long studyDayId) {
        return studySessionRepository.findByStudyDayId(studyDayId);
    }
}