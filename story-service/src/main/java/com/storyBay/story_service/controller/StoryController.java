package com.storyBay.story_service.controller;

import com.storyBay.story_service.model.Story;
import com.storyBay.story_service.service.StoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/story")
public class StoryController {

    @Autowired
    private StoryService storyService;

    @GetMapping("/")
    public List<Story> getAllStories() {
        return storyService.getAllStories();
    }

    @GetMapping("/{id}")
    public Story getStoryById(@PathVariable String id) {
        return storyService.getStoryById(id);
    }

    @PostMapping
    public Story createStory(@RequestBody Story story) {
        return storyService.saveStory(story);
    }

//    @PutMapping("/{id}")
//    public Story updateStory(@PathVariable String id, @RequestBody Story story) {
//        return storyService.updateStory(id, story);
//    }

    @DeleteMapping("/{id}")
    public void deleteStory(@PathVariable String id) {
        storyService.deleteStory(id);
    }
}
