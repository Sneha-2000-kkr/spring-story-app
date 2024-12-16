package com.storyBay.story_service.service;


import com.storyBay.story_service.model.Story;
import com.storyBay.story_service.repository.StoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepo storyRepository;
    @Autowired
    private Story story;

    public List<Story> getAllStories() {
        return storyRepository.findAll();
    }

    public Story getStoryById(String id) {
        return storyRepository.findById(id);
    }

    public Story saveStory(Story story) {
        return storyRepository.save(story);
    }

    public Story updateStory(String id, Story story) {
        story.setStoryId(id);
        return storyRepository.save(story);
    }

    public void deleteStory(String id) {
        storyRepository.deleteById(id);
    }

}
