package com.storyBay.story_service.service;


import com.storyBay.story_service.model.Story;
import com.storyBay.story_service.repository.StoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoryService {

    @Autowired
    private StoryRepository storyRepository;
    @Autowired
    private Story story;



    public List<Story> getAllStories() {
        return storyRepository.findAllStories();
    }

    public Story getStoryById(String id) {
        return storyRepository.findStoryById(id);
    }

    public Story saveStory(Story story) {
        return storyRepository.saveStory(story);

    }

//    public Story updateStory(String id, Story story) {
//        story.setStoryId(id);
//        return storyRepository.saveStory(story);
//    }

    public void deleteStory(String id) {
        storyRepository.deleteStoryById(id);
    }

}
