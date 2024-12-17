package com.storyBay.search_service.controller;

import com.storyBay.search_service.model.SearchCriteria;
import com.storyBay.search_service.model.Story;
import com.storyBay.search_service.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
@RequestMapping("/api/story")
public class SearchController {
    @Autowired
    private SearchService searchService;

    // Endpoint for searching stories
    @PostMapping("/search")
    public List<Story> searchStories(@RequestBody SearchCriteria searchCriteria) {
        return searchService.searchStories(searchCriteria);
    }
}
