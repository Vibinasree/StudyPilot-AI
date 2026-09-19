package com.studypilot.controller;

import com.studypilot.dto.TopicRequest;
import com.studypilot.entity.Topic;
import com.studypilot.service.TopicService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/topics")
public class TopicController {

    private final TopicService topicService;

    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(
            @Valid @RequestBody TopicRequest request) {

        return ResponseEntity.ok(
                topicService.createTopic(request)
        );
    }

    @GetMapping
    public ResponseEntity<List<Topic>> getAllTopics() {

        return ResponseEntity.ok(
                topicService.getAllTopics()
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<Topic> getTopic(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                topicService.getTopicById(id)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<Topic> updateTopic(
            @PathVariable Long id,
            @Valid @RequestBody TopicRequest request) {

        return ResponseEntity.ok(
                topicService.updateTopic(id, request)
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTopic(
            @PathVariable Long id) {

        topicService.deleteTopic(id);

        return ResponseEntity.noContent().build();
    }
}