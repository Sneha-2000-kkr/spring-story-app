package com.storyBay.search_service.service;

import com.storyBay.search_service.model.Story;
import com.storyBay.search_service.model.SearchCriteria;
import com.storyBay.search_service.repository.SearchRepository;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mongodb.client.model.Filters;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.conversions.Bson;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private SearchRepository searchRepository;

    // Method to search stories based on criteria
    public List<Story> searchStories(SearchCriteria searchCriteria) {
        Bson filter = buildSearchFilter(searchCriteria);
        return searchRepository.searchStories(filter); // Delegate MongoDB search to repository
    }

    // Helper method to build the MongoDB filter based on search criteria
    private Bson buildSearchFilter(SearchCriteria searchCriteria) {
        List<Bson> filters = new ArrayList<>();

        if (searchCriteria.getTitle() != null) {
            filters.add(Filters.regex("titleName", searchCriteria.getTitle(), "i"));
        }

        if (searchCriteria.getAuthorId() != null) {
            filters.add(Filters.eq("authorId", searchCriteria.getAuthorId()));
        }

        if (searchCriteria.getGenreId() != null) {
            filters.add(Filters.eq("genreId", searchCriteria.getGenreId()));
        }

        if (searchCriteria.getStatus() != null) {
            filters.add(Filters.eq("status", searchCriteria.getStatus()));
        }

        if (searchCriteria.getMinLikedCount() != null) {
            filters.add(Filters.gte("likedCount", searchCriteria.getMinLikedCount()));
        }

        if (searchCriteria.getMaxLikedCount() != null) {
            filters.add(Filters.lte("likedCount", searchCriteria.getMaxLikedCount()));
        }

        if (searchCriteria.getMinReadTime() != null) {
            filters.add(Filters.gte("readTime", searchCriteria.getMinReadTime()));
        }

        if (searchCriteria.getMaxReadTime() != null) {
            filters.add(Filters.lte("readTime", searchCriteria.getMaxReadTime()));
        }

        return Filters.and(filters); // Combine all filters
    }
}
