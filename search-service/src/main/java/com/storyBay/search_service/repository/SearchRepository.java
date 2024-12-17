package com.storyBay.search_service.repository;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.storyBay.search_service.model.Story;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SearchRepository {

    @Autowired
    private MongoDatabase mongoDatabase;

    public List<Story> searchStories(Bson searchFilter) {
        MongoCollection<Document> collection = mongoDatabase.getCollection("story");
        List<Story> stories = new ArrayList<>();
        for (Document doc : collection.find(searchFilter)) {
            stories.add(new Story(
                    doc.getString("storyId"),
                    doc.getString("titleName"),
                    doc.getString("storyContent"),
                    doc.getString("authorId"),
                    doc.getString("authorName"),
                    doc.getString("genreId"),
                    doc.getInteger("likedCount"),
                    doc.getInteger("dislikedCount"),
                    doc.getDate("publishingDate"),
                    doc.getString("storyImgPath"),
                    doc.getInteger("readTime")
            ));
        }
        return stories;
    }
}
