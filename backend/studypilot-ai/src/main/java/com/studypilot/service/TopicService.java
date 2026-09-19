package com.studypilot.service;

import com.studypilot.dto.TopicRequest;
import com.studypilot.entity.Topic;
import com.studypilot.repository.TopicRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {

    private final TopicRepository topicRepository;

    public TopicService(TopicRepository topicRepository) {
        this.topicRepository = topicRepository;
    }

    public Topic createTopic(TopicRequest request) {

        Topic topic = new Topic();
        topic.setName(request.getName());
        topic.setDescription(request.getDescription());
        topic.setDifficulty(request.getDifficulty());

        return topicRepository.save(topic);
    }

    public List<Topic> getAllTopics() {
        return topicRepository.findAll();
    }

    public Topic getTopicById(Long id) {
        return topicRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Topic not found"));
    }

    public Topic updateTopic(Long id, TopicRequest request) {

        Topic topic = getTopicById(id);

        topic.setName(request.getName());
        topic.setDescription(request.getDescription());
        topic.setDifficulty(request.getDifficulty());

        return topicRepository.save(topic);
    }

    public void deleteTopic(Long id) {

        Topic topic = getTopicById(id);
        topicRepository.delete(topic);
    }
}